package com.cs4471.cspsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CSPSPMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(CSPSPMainApplication.class, args);
	}}
