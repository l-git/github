package com.demo.springbootmybatis;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class Application {


	
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    
	@RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!12";
    }
	

}