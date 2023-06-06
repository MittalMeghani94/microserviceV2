package com.demo.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microservice.bean.Limits;
import com.demo.microservice.configuration.Configuration;

@RestController
public class LimitsController {
	
	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public Limits retrivalLimits() {
		return new Limits(configuration.getMinimum(),configuration.getMaximum());
	}
}
