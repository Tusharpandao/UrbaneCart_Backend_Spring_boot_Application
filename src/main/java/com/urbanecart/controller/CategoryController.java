package com.urbanecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.urbanecart.pojo.Category;
import com.urbanecart.response.ResponseStructure;
import com.urbanecart.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/categories")
	public ResponseEntity<?> addCategories(@RequestBody List<Category>categories) {
	    List<Category> savedCategories = categoryService.saveCategories(categories);

		if (!savedCategories.isEmpty()) {
			return new ResponseEntity<ResponseStructure<Category>>(
				    new ResponseStructure<Category>("Category added Successfully", savedCategories, HttpStatus.ACCEPTED.value()),
				    HttpStatus.ACCEPTED
				);
		}
		return new ResponseEntity<ResponseStructure<Category>>(
		  new ResponseStructure<Category>("Category not added", savedCategories,HttpStatus.NOT_ACCEPTABLE.value()),
		  HttpStatus.NOT_ACCEPTABLE);

	}
	@GetMapping("/categories")
	public ResponseEntity<?> getAllCategory() {
		
		List<String> categories=categoryService.getAllCategories();
		
		if (categories != null &&!categories.isEmpty()) {
            return new ResponseEntity<ResponseStructure<Category>>
              (new ResponseStructure<Category>("Categories Found Successfully", categories, HttpStatus.OK.value()),HttpStatus.OK);
        }
		return new ResponseEntity<ResponseStructure<Category>>(
				new ResponseStructure<Category>("Categories Not Found", categories, HttpStatus.NOT_FOUND.value()),HttpStatus.NOT_FOUND);
				
		
	}


}
