package com.example.productionwebservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.productionwebservice.mapper.ProductReviewMapping;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.productionwebservice")
@EnableJpaRepositories(basePackages = "com.example.productionwebservice.repositories")
public class ProductionwebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductionwebserviceApplication.class, args);
	}

	@Bean
     public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new ProductReviewMapping());
        return modelMapper;
    }
}
