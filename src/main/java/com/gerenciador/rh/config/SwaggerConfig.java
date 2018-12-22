package com.gerenciador.rh.config;

import static java.util.Arrays.asList;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.gerenciador.rh.resources"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo())
				.useDefaultResponseMessages(false)
				.globalResponseMessage(GET, asList(m403, m404, m500))
				.globalResponseMessage(POST, asList(m201, m403, m422, m500))
				.globalResponseMessage(PUT, asList(m204put, m403, m404, m422, m500))
				.globalResponseMessage(DELETE, asList(m204del, m403, m404, m500));
	}
	
	private ApiInfo apiInfo() {
		 return new ApiInfo(
		 "API do Gerenciamento de RH",
		 "Esta API é utilizada no gerenciamento de um RH",
		 "Versão 1.0",
		 "https://www.rh-online.com",
		 new Contact("Eduardo Sampaio", "esampaio", "eduardo@gmail.com"),
		 "Permitido uso para estudos",
		 "https://www.rh-online.com",
		 Collections.emptyList() // Vendor Extensions
		);
	}
	
	private final ResponseMessage m201 = simpleMessage(201, "Recurso criado");
	private final ResponseMessage m204put = simpleMessage(204, "Atualização ok");
	private final ResponseMessage m204del = simpleMessage(204, "Deleção ok");
	private final ResponseMessage m403 = simpleMessage(403, "Não autorizado");
	private final ResponseMessage m404 = simpleMessage(404, "Não encontrado");
	private final ResponseMessage m422 = simpleMessage(422, "Erro de validação");
	private final ResponseMessage m500 = simpleMessage(500, "Erro inesperado");
	
	private ResponseMessage simpleMessage(int code, String msg) {
	return new ResponseMessageBuilder().code(code).message(msg).build();
	}
}
