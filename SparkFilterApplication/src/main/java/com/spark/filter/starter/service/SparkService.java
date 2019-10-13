package com.spark.filter.starter.service;

import java.io.Serializable;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.springframework.stereotype.Service;

@Service
public class SparkService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String fetchFilteredOutput() {
		// TODO Auto-generated method stub
		String output="";
		SparkConf  conf=new SparkConf();
		conf.setAppName("Spark Filter");
		conf.setMaster("local");
		
		JavaSparkContext sc=new JavaSparkContext(conf);
		JavaRDD<String> lines=sc.textFile("C:\\Users\\23ksh\\Desktop\\myfile.txt");
		
		JavaRDD<String> filteredLines=lines.filter(new Function<String, Boolean>() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Boolean call(String lineCapture) throws Exception {
				// TODO Auto-generated method stub
				return lineCapture.contains("kshitij");
			}
		});
		
		for(String line:filteredLines.collect())
		{
			output=output+line+"\n";
		}
		sc.close();
		return output;
	}

}
