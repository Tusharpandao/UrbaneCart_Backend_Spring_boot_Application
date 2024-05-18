package com.urbanecart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urbanecart.pojo.Category;
import com.urbanecart.pojo.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByCategory(Category category);

}
