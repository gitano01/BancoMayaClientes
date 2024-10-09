package com.bncmy.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="*")
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan(basePackages="com.*")
@SpringBootApplication
public class BancoMayaClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancoMayaClientesApplication.class, args);
	}





}
