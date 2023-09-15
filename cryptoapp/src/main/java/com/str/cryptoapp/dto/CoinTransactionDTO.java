package com.str.cryptoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class CoinTransactionDTO {

    private String name;
    private BigDecimal quantity;
}
