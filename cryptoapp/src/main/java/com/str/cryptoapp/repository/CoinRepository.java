package com.str.cryptoapp.repository;

import com.str.cryptoapp.dto.CoinTransactionDTO;
import com.str.cryptoapp.entities.Coin;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CoinRepository {

    private static final String INSERT = "INSERT INTO coin(name, price, quantity, datetime) VALUES (?,?,?,?)";

    private static final String SELECT_ALL = "SELECT name,SUM(quantity) AS quantity FROM coin GROUP BY name";

    private static final String SELECT_BY_NAME = "SELECT * FROM coin WHERE name = ?";

    private static final String DELETE = "DELETE * FROM coin WHERE id = ?";

    private static final String UPDATE = "UPDATE coin SET name = ?, price = ?, quantity = ? where id = ?";


    private final JdbcTemplate jdbcTemplate;

    public CoinRepository(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    /* Função para inserção */
    public Coin insert(Coin coin){

        Object[] attr = new Object[]{
               coin.getName(),
               coin.getPrice(),
               coin.getQuantity(),
               coin.getDatetime(),
        };
        jdbcTemplate.update(INSERT,attr);
        return coin;
    }

    public Coin update(Coin coin){
        Object[] attr = new Object[]{
                coin.getName(),
                coin.getPrice(),
                coin.getQuantity(),
                coin.getId()
        };
        jdbcTemplate.update(UPDATE,attr);
        return coin;

    }

    /* Função para listar cadastro <nome,quantidade>  */
    public List<CoinTransactionDTO> getAll(){
        return jdbcTemplate.query(SELECT_ALL, new RowMapper<CoinTransactionDTO>() {
            @Override
            public CoinTransactionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

                CoinTransactionDTO coin = new CoinTransactionDTO();
                coin.setName(rs.getString("name"));
                coin.setQuantity(rs.getBigDecimal("quantity"));

                return coin;
            }
        });
    }

    /* Função para listar cadastro atraves do nome */
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

    /* Função para remover cadastro atraves do id */
    public int remove(int id){
        return jdbcTemplate.update(DELETE,id);
    }




}
