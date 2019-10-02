package com.spark.filter.starter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spark.filter.starter.service.SparkService;

@RestController
public class SparkController {
	
	@Autowired
	private SparkService service;
	
	@GetMapping
	public String getSParkFilter()
	{
		return service.fetchFilteredOutput();
	}

}
