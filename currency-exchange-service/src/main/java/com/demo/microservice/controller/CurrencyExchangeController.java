package com.demo.microservice.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microservice.bean.CurrencyExchage;
import com.demo.microservice.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository repo;
	
	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyExchage retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		//CurrencyExchage currencyExchage =  new CurrencyExchage(1L,from,to,BigDecimal.valueOf(50));
		logger.info("retrivalExchangeValue called with {} {}",from,to);
		
		CurrencyExchage currencyExchage = repo.findByFromAndTo(from, to);
		if(currencyExchage==null)
		{
			throw new RuntimeException("unable to find");
		}
		currencyExchage.setEnvironment(environment.getProperty("local.server.port"));	
		return currencyExchage;
	}
}
