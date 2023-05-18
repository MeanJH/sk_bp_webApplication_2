package com.example.aopexam.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.aopexam.domain.Product;

@Repository
public class ProdcutDaoImpl implements ProductDao {
	private Map<String,Product> storage = new HashMap<>();

	@Override
	public void addProduct(Product product) {
		System.out.println("dao addProduct run!!");
		storage.put(product.getName(), product);
	}

	@Override
	public Product findProduct(String name) {
		System.out.println("dao findProduct run!!");
//		if(1==1)
//			throw new RuntimeException();
		return storage.get(name);
	}

}
