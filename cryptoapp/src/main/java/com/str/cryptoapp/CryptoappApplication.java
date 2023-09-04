package com.str.cryptoapp;

import com.str.cryptoapp.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CryptoappApplication
{
	public static void main(String[] args) {SpringApplication.run(CryptoappApplication.class, args);}
}
