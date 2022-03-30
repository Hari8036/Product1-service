package com.edusol.product1.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edusol.product1.model.Product1;
import com.edusol.product1.service.Product1Service;

@RestController
@RequestMapping("/product1")
public class Product1Controller {

	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	Product1Service product1Service;

	@GetMapping("/get-products")
	public Object getProducts() {
		@SuppressWarnings("unchecked")
		List<Product1>products=(List<Product1>)product1Service.getProducts();
		logger.info(products.toString());
		return products;
	}

	@PostMapping("/add-product")
	public Object addProduct(@RequestBody Product1 product1) {
		
		logger.info(product1.toString());
		return product1Service.addProduct(product1);
	}

	@GetMapping("/get-productByName")
	public Object getProductByName(@RequestParam String name) {
		@SuppressWarnings("unchecked")
		List<Product1>products=(List<Product1>)product1Service.getpProductByName(name);
		logger.info(products.toString());
		return products;
	}

	@GetMapping("/get-productById")
	public Object getProductById(@RequestParam int id) {
		Object product1=product1Service.getProductById(id);
		logger.info(product1.toString());
		return product1;
	}

	@GetMapping("/get-productByCategory")
	public Object getProductByCategory(@RequestParam String category) {
		@SuppressWarnings("unchecked")
		List<Product1>products=(List<Product1>)product1Service.getProductByCategory(category);
		logger.info(products.toString());
		return products;
	}

	@GetMapping("/get-productBySubcategory")
	public Object getProductBySubcategory(@RequestParam String subcategory) {
		@SuppressWarnings("unchecked")
		List<Product1>products=(List<Product1>)product1Service.getproductBySubcategory(subcategory);
		logger.info(products.toString());
		return products;
	}

	@GetMapping("/get-productByPrice")
	public Object getProductByPrice(@RequestParam float price) {
		@SuppressWarnings("unchecked")
		List<Product1>products=(List<Product1>)product1Service.getProductByPrice(price);
		logger.info(products.toString());
		return products;

	}

	@GetMapping("/get-productByPriceAndCategory")
	public Object getProductByPriceAndCategory(@RequestParam float price, @RequestParam String category) {
		@SuppressWarnings("unchecked")
		List<Product1>products=(List<Product1>)product1Service.getProductByPriceAndCategory(price, category);
		logger.info(products.toString());
		return products;
	}

	@GetMapping("/get-productByPriceAndSubcategory")
	public Object getProductByPriceAndSubcategory(@RequestParam float price,@RequestParam String subcategory)
	{
		@SuppressWarnings("unchecked")
		List<Product1>products=(List<Product1>)product1Service.getProductByPriceAndSubcategory(price,subcategory);
		logger.info(products.toString());
		return products;
	}
     @GetMapping("/get-ProductByPriceBetween")
	public Object getProductByPriceBetween(@RequestParam float min, @RequestParam float max)
	{
    	 return product1Service.getProductByPriceBetween(min,max);
	}

     @GetMapping("/get-productbyPriceBetweenAndCategory")
     public Object getProductByPriceBetweeAndCategory(@RequestParam float min,float max,@RequestParam String category)
     {
    	 @SuppressWarnings("unchecked")
    	 List<Product1>products=(List<Product1>) product1Service.getProductByPriceBetweeAndCategory(min,max,category);
    	 logger.info(products.toString());
    	 return products;
     }
     @GetMapping("/get-productPriceBetweensubcategory")
     public Object getProductByPriceBetweenAndSubcategory(@RequestParam float min,float max,@RequestParam String subcategory) {
    	 @SuppressWarnings("unchecked")
    	 List<Product1>products=(List<Product1>)product1Service.getProductByPriceBetweenAndSubcategory(min,max,subcategory);
    	 logger.info(products.toString());
    	 return products;
     }
     
     @PutMapping("/update-product")
     public Object updateProduct(@RequestBody Product1 product1)
      {
    	 logger.info("Product details"+product1.toString());
    	 return product1Service.updateProduct(product1);
     }
     @DeleteMapping("/delete-product")
     public Object deleteProduct(@RequestParam int id)
     {
    	 logger.info("Product Id"+id);
    	 return product1Service.deleteProduct(id);
     }
}
