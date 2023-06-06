package com.demo.microservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
	//@Retry(name = "sample-api" , fallbackMethod = "hardcodedResponse")
	//@CircuitBreaker(name = "default" , fallbackMethod = "hardcodedResponse")
	//@RateLimiter(name = "default")
	@Bulkhead(name = "default")
	public String sampleApi() {
		
		logger.info("sample Api request recieved");
		//ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-api", String.class);
		//return response.getBody();
		return "sample-api";
	}
	
	public String hardcodedResponse(Exception ex) {
		return "fallback-response";
	}
}
