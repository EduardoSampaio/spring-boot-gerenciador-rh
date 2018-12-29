package com.gerenciador.rh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GerenciadorRhApplication {

	private static final Logger logger = LoggerFactory.getLogger(GerenciadorRhApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(GerenciadorRhApplication.class, args);
		logger.info("Iniciando Aplicação");
	}

}

