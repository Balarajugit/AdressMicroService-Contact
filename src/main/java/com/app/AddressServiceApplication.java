package com.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class AddressServiceApplication {
	
	@Value("${contact.service.url}")
	private String contactServiceUrl;

	public static void main(String[] args) {
		SpringApplication.run(AddressServiceApplication.class, args);
	}
	
	@Bean
	public WebClient webClient () {
		WebClient webClient =WebClient.builder()
				.baseUrl(contactServiceUrl).build();
		
		return webClient;
	}

}
