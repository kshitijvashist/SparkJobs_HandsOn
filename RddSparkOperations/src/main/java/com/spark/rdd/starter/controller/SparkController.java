package com.spark.rdd.starter.controller;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spark.rdd.starter.service.SparkService;

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
