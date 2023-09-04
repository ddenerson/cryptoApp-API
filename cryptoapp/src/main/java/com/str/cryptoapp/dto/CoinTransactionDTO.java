package com.str.cryptoapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CoinTransactionDTO {

    private String name;
    private BigDecimal quantity;
}
