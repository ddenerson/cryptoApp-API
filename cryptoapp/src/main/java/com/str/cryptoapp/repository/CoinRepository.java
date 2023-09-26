package com.str.cryptoapp.repository;


import com.str.cryptoapp.dto.CoinTransactionDTO;
import com.str.cryptoapp.entities.Coin;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.Persistence;

import javax.persistence.*;
import java.util.List;

@Repository
@EnableAutoConfiguration
public class CoinRepository {




  // EntityManagerFactory emf = Persistence.createEntityManagerFactory("cryptoapp");
    @PersistenceUnit
    private EntityManager em;


    @Transactional
    public Coin insert (Coin coin){
        em.persist(coin);
        return coin;
    }

    @Transactional
    public Coin update(Coin coin){
        em.merge(coin);
        return coin;
    }

    public List<CoinTransactionDTO> getAll(){
        String jpql = "select new com.gm2.cryptoapp.dto.CoinTransationDTO(c.name, sum(c.quantity)) from Coin c group by c.name";
        TypedQuery<CoinTransactionDTO> query = em.createQuery(jpql, CoinTransactionDTO.class);
        return query.getResultList();
    }


    public List<Coin> getByName(String name){
        String jpql = "select c from Coin c where c.name like :name";
        TypedQuery<Coin> query = em.createQuery(jpql, Coin.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

    @Transactional
    public boolean remove(int id) {
        Coin coin = em.find(Coin.class, id);

        if(coin == null)
            throw new RuntimeException();

        em.remove(coin);
        return true;
    }

}