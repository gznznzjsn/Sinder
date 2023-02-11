package com.solvd.laba.sinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SinderApplication.class, args);
	}

}
