package com.spicy.kitchen;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@ComponentScan
@EnableFeignClients
@SpringBootApplication
@EnableSwagger2
@EnableCircuitBreaker
@EnableDiscoveryClient
public class MyRestaurant {

	public static void main(String[] args) {
		SpringApplication.run(MyRestaurant.class, args);
	}
	
	@Bean 
	  public Docket swaggerConfiguration() {
	  
	  return new Docket(DocumentationType.SWAGGER_2)
			  .select()
			  .paths(PathSelectors.any())
			  .apis(RequestHandlerSelectors.basePackage("com.spicy.kitchen")) 
			  .build().apiInfo(apiDetails());

}
	private ApiInfo apiDetails() {
		// TODO Auto-generated method stub
		
		return new ApiInfo("Spicy Kitchen Restaurant api", 
				
					"Swagger api documentation for MyRestaurant",					
					"2.0.0",					
					"Free to use",					
					new springfox.documentation.service.Contact("Restaurant", "http://restaurant.io", "spicykitchen@gmail.com"),					
					"API license", 
					"http://restaurant.io",					
					Collections.emptyList());
	}
	
	
}
