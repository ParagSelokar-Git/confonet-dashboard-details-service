package com.confonet.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@ComponentScan({"com.confonet.controller","com.confonet.service"})
@EntityScan("com.confonet.entity")
@EnableJpaRepositories("com.confonet.repository")
public class ConfonetDashboardDetailsServiceApplication {

	@Value("${customer.details.url}")
	private String customerServiceUrl;
	
	public static void main(String[] args) {
		SpringApplication.run(ConfonetDashboardDetailsServiceApplication.class, args);
	}
	
	@Bean
	public WebClient webClient() {
		WebClient webClient = WebClient.builder().baseUrl(customerServiceUrl).build();
		return webClient;
		
	}
}
