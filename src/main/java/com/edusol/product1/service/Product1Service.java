package com.edusol.product1.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edusol.product1.model.Product1;
import com.edusol.product1.repository.Product1Repository;
import com.google.gson.JsonObject;

@Service
public class Product1Service {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	Product1Repository product1Repository;

	public Object getProducts() {

		return product1Repository.findAll();
	}

	public Object addProduct(Product1 product1) {
		logger.info(product1.toString());
		product1Repository.save(product1);
		logger.info("Product Added sucessfully");
		return new ResponseEntity<>("Product Added Sucssfully", HttpStatus.CREATED);
	}

	public Object getpProductByName(String name) {

		return product1Repository.findByName(name);
	}

	public Object getProductById(int id) {

		return product1Repository.findById(id);
	}

	public Object getProductByCategory(String category) {
		return product1Repository.findByCategory(category);

	}

	public Object getproductBySubcategory(String subcategory) {

		return product1Repository.findBySubcategory(subcategory);
	}

	public Object getProductByPrice(float price) {

		return product1Repository.findByPrice(price);
	}

	public Object getProductByPriceAndCategory(float price, String category) {

		return product1Repository.findByPriceAndCategory(price, category);
	}

	public Object getProductByPriceAndSubcategory(float price, String subcategory) {

		return product1Repository.findByPriceAndSubcategory(price, subcategory);
	}

	public Object getProductByPriceBetween(float min, float max) {

		return product1Repository.findByPriceBetween(min, max);
	}

	public Object getProductByPriceBetweeAndCategory(float min, float max, String category) {

		return product1Repository.findByPriceBetweenAndCategory(min, max, category);
	}

	public Object getProductByPriceBetweenAndSubcategory(float min, float max, String subcategory) {

		return product1Repository.findByPriceBetweenAndSubcategory(min, max, subcategory);
	}

	public Object updateProduct(Product1 product1) {
		JsonObject response=new JsonObject();
		System.out.println("Request Product1" + product1);
		int id = product1.getId();
		try {
			Product1 prod = product1Repository.getOne(id);
			System.out.println("Old Product" + prod);
			prod.setPrice(product1.getPrice());
			System.out.println("New Product" + prod);
			product1Repository.save(prod);
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.addProperty("statusCode",404);
			response.addProperty("statusMessage",e.getMessage());
			return new ResponseEntity<>(response.toString(),HttpStatus.NOT_FOUND);
		}
		logger.info("Product updated Sucessfully");
		return new ResponseEntity<>("Product updated Sucessfully",HttpStatus.OK);
	}

	public Object deleteProduct(int id) {
		try {
		product1Repository.deleteById(id);
		}catch(Exception e)
		{
			logger.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		logger.info("Product deleted sucessfully");
		return new ResponseEntity<>("Product deleted Sucessfully",HttpStatus.OK);
	}
}
