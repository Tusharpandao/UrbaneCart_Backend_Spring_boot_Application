package com.urbanecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.urbanecart.pojo.Product;
import com.urbanecart.response.ResponseStructure;
import com.urbanecart.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping("/product")
	public ResponseEntity<?> addProduct(@RequestBody Product product){
	  Product pojo=productService.addProduct(product);
	 if(pojo != null) {
		 return new ResponseEntity<ResponseStructure<Product>>
		  (new ResponseStructure<Product>("Product Added  Successfully", pojo, HttpStatus.OK.value()),HttpStatus.OK);
	 }
	 return new ResponseEntity<ResponseStructure<Product>>
	  (new ResponseStructure<Product>("Product Added  Successfully", pojo, HttpStatus.NOT_ACCEPTABLE.value()),HttpStatus.NOT_ACCEPTABLE);
	}


	@GetMapping("/products")
	public ResponseEntity<?> getAllProduct(){
		
		List<Product> products=productService.getAllProducts();
		
		if (!products.isEmpty()) {
			return new ResponseEntity<ResponseStructure<Product>>
			  (new ResponseStructure<Product>("Products Found Successfully", products, HttpStatus.OK.value()),HttpStatus.OK);
		}
		return new ResponseEntity<ResponseStructure<Product>>
		  (new ResponseStructure<Product>("Products not Found", products, HttpStatus.NOT_FOUND.value()),HttpStatus.NOT_FOUND);

	}
	
	@PostMapping("/products")
	public ResponseEntity<?> addProducts(@RequestBody List<Product> productRequests) {
	    List<Product> savedProducts = productService.saveProducts(productRequests);
	    if (!savedProducts.isEmpty()) {
			return new ResponseEntity<ResponseStructure<Product>>
			  (new ResponseStructure<Product>("Products Added  Successfully", savedProducts, HttpStatus.OK.value()),HttpStatus.OK);
		}
		return new ResponseEntity<ResponseStructure<Product>>
		  (new ResponseStructure<Product>("Products Added  Successfully", savedProducts, HttpStatus.NOT_ACCEPTABLE.value()),HttpStatus.NOT_ACCEPTABLE);

	}
	
	@GetMapping("/products/category/{categoryName}")
	public ResponseEntity<?> getProductByCategory(@PathVariable String categoryName){
		
		List<Product> products=productService.getProductByCategory(categoryName);
		if (products != null && !products.isEmpty()) {
			return new ResponseEntity<ResponseStructure<Product>>
			  (new ResponseStructure<Product>("Products found Successfully", products, HttpStatus.OK.value()),HttpStatus.OK);
		}
		return new ResponseEntity<ResponseStructure<Product>>
		  (new ResponseStructure<Product>("Products not found Successfully", products, HttpStatus.NOT_FOUND.value()),HttpStatus.NOT_FOUND);

	}
	
	
	
}









