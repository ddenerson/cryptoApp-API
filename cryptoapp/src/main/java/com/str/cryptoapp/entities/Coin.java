package com.str.cryptoapp.entities;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
public class Coin {

    private int id;
    private String name;
    private Timestamp datetime;
    private BigDecimal price;
    private BigDecimal quantity;
}
