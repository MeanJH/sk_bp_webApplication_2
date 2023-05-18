package com.example.aopexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.aopexam.domain.Product;
import com.example.aopexam.service.ProductService;

@SpringBootApplication
public class AopexamApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AopexamApplication.class, args);
	}
	
	@Autowired
	ProductService productService;
	@Override
	public void run(String... args) throws Exception {
		productService.addProduct(new Product("pen",3000));
		
		Product product = productService.findByProductName("pen");
		
		System.out.println(product);
	}

}
