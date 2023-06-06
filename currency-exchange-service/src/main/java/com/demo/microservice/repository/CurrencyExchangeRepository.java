package com.demo.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.microservice.bean.CurrencyExchage;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchage, Long> {
	
	public CurrencyExchage findByFromAndTo(String from, String to);

}
