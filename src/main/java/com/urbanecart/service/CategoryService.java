package com.urbanecart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urbanecart.pojo.Category;
import com.urbanecart.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> saveCategories(List<Category> categories) {
	    return categoryRepository.saveAll(categories);
	}

	public List<String> getAllCategories() {
		
		List<Category> allList = categoryRepository.findAll();
		//set only category name for send to the controller
		List<String> categoryList = new ArrayList<>();
		if (allList != null && !allList.isEmpty()) {
			
			for (Category category : allList) {
			    categoryList.add(category.getName());
			}
		}
		return categoryList;
	}


}
