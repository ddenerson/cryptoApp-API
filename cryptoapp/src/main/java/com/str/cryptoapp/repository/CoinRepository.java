package com.str.cryptoapp.repository;

import com.str.cryptoapp.dto.CoinTransactionDTO;
import com.str.cryptoapp.entities.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CoinRepository {

    @Autowired
    private EntityManager entityManager;
    
    @Transactional
    /* Função para inserção */
    public Coin insert(Coin coin){
       entityManager.persist(coin);
        return coin;
    }

    public Coin update(Coin coin){
       entityManager.merge(coin);
        return coin;
    }

    /* Função para listar cadastro <nome,quantidade>  */
    public List<CoinTransactionDTO> getAll(){
       String jpql = "select new com.str.cryptoapp.dto.CoinTransactionDTO(c.name,sum(c.quantity)) from Coin c group by c.name";
       TypedQuery <CoinTransactionDTO> query = entityManager.createQuery(jpql, CoinTransactionDTO.class);
       return query.getResultList();
    }

    /* Função para listar cadastro atraves do nome
    public List<Coin> getByName(String name){
        Object[] attr = new Object[]{name};
        return jdbcTemplate.query(SELECT_BY_NAME, new RowMapper<Coin>() {
            @Override
            public Coin mapRow(ResultSet rs, int rowNum) throws SQLException {

                Coin coin = new Coin();
                coin.setId(rs.getInt("id"));
                coin.setName(rs.getString("name"));
                coin.setQuantity(rs.getBigDecimal("quantity"));
                coin.setPrice(rs.getBigDecimal("price"));
                coin.setDatetime(rs.getTimestamp("datetime"));
                return coin;
            }
        },attr);
    }

    Função para remover cadastro atraves do id
    public int remove(int id){
        return jdbcTemplate.update(DELETE,id);
    }

     */



}
