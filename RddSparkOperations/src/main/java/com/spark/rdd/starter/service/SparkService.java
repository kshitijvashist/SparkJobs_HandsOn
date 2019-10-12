package com.spark.rdd.starter.service;

import java.io.Serializable;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkException;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import org.springframework.stereotype.Service;

@Service
public class SparkService implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String fetchFilteredOutput() {
		Broadcast<String> broadcast=null;
		try
		{
		// TODO Auto-generated method stub
		SparkConf  conf=new SparkConf();
		conf.setAppName("Spark Filter");
		conf.setMaster("local");
		JavaSparkContext ctx=new JavaSparkContext(conf);
		
		
		broadcast=ctx.broadcast("BroadCast Read Only Shared variable");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		finally
		{
			
		}
		
		
		return broadcast.getValue();
	}

}
