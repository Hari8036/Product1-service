package com.edusol.product1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.edusol.product1.model.Product1;

public interface Product1Repository  extends JpaRepository<Product1, Integer>{
	List<Product1> findByName(String name);
	List<Product1>findByCategory(String category);
	List<Product1> findBySubcategory(String subcategory);
	List<Product1>findByPrice(float price);
	List<Product1>findByPriceAndCategory(float price,String category);
	List<Product1>findByPriceAndSubcategory(float price,String subcategory);
	List<Product1>findByPriceBetween(float min, float max);
	List<Product1>findByPriceBetweenAndCategory(float min,float max,String category);
	List<Product1>findByPriceBetweenAndSubcategory(float min,float max,String subcategory);

}
