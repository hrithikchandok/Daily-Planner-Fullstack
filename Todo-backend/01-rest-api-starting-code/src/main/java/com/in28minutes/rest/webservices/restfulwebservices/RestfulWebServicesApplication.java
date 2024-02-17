package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RestfulWebServicesApplication {

	
	
//	   cross orgigin request are declined in spring boot
//	 we have to allow all request from localhost/300 to make things work from react side xcac
	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}
     @Bean
     public WebMvcConfigurer corConfigurer() {
    	  return new WebMvcConfigurer() {
    		     
    		  public void addCorsMappings(CorsRegistry registry) {
    			       registry.addMapping("/**")
    			       .allowedMethods("*")
    			       .allowedOrigins("http://localhost:3000/");
    		  }
    	  };
     }
}
