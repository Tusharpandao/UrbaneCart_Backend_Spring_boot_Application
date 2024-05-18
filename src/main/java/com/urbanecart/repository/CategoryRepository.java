package com.urbanecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urbanecart.pojo.Category;

public interface CategoryRepository extends JpaRepository<Category,String> {
	
	Category findByName(String name);

}
