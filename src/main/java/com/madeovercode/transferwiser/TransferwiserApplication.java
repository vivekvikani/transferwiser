package com.madeovercode.transferwiser;

import com.madeovercode.transferwiser.rest.config.RestConfigProps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RestConfigProps.class)
public class TransferwiserApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransferwiserApplication.class, args);
	}

}