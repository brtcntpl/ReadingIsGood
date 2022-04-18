package com.getir.readingisgood;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@SpringBootApplication
@RestController
//@ComponentScan(basePackages = {"com.getir.readingisgood.service"})
public class ReadingIsGoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadingIsGoodApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
