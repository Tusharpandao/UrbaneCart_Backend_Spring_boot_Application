package com.urbanecart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urbanecart.pojo.Category;
import com.urbanecart.pojo.Product;
import com.urbanecart.repository.CategoryRepository;
import com.urbanecart.repository.ProductRepository;

@Service
public class ProductService {


	@Autowired
	private ProductRepository productRepository ;
	@Autowired
	private CategoryRepository categoryRepository;
	
	 
	
	  public List<Product> saveProducts(List<Product> products) {
		    List<Product> savedProducts = new ArrayList<>();
		    
		    for (Product request : products) {
		    	 Product product = new Product();
			        // Set product attributes
			        product.setId(request.getId());
			        product.setTitle(request.getTitle());
			        product.setDescription(request.getDescription());
			        product.setPrice(request.getPrice());
			        product.setDiscountPercentage(request.getDiscountPercentage());
			        product.setRating(request.getRating());
			        product.setStock(request.getStock());
			        product.setBrand(request.getBrand());
			        product.setThumbnail(request.getThumbnail());
			        product.setImages(request.getImages());
		        
		        // Set category
		        Category category = categoryRepository.findByName(request.getCategory().getName());
		        if (category == null) {
		            // Category does not exist, create a new one and save it
		            category = new Category();
		            category.setName(request.getCategory().getName());
		            category = categoryRepository.save(category);
		        }
		        product.setCategory(category);

		        savedProducts.add(product);
		    }
		    
		    // Save all products
		    savedProducts = productRepository.saveAll(savedProducts);
		    
		    return savedProducts;
		}

		public Product addProduct(Product product) {
			 Product toBesaveProduct = new Product();
		        // Set product attributes
			 toBesaveProduct.setId(product.getId());
			 toBesaveProduct.setTitle(product.getTitle());
			 toBesaveProduct.setDescription(product.getDescription());
			 toBesaveProduct.setPrice(product.getPrice());
			 toBesaveProduct.setDiscountPercentage(product.getDiscountPercentage());
			 toBesaveProduct.setRating(product.getRating());
			 toBesaveProduct.setStock(product.getStock());
			 toBesaveProduct.setBrand(product.getBrand());
			 toBesaveProduct.setThumbnail(product.getThumbnail());
			 toBesaveProduct.setImages(product.getImages());
	        
	        // Set category
	        Category category = categoryRepository.findByName(product.getCategory().getName());
	        if (category == null) {
	            // Category does not exist, create a new one and save it
	            category = new Category();
	            category.setName(product.getCategory().getName());
	            category = categoryRepository.save(category);
	        }
	        toBesaveProduct.setCategory(category);
			//save the product and return that product to the controller
			return productRepository.save(toBesaveProduct);
		}

	  
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
//	 public Product getProductById(int id) {
//	        return productRepository.findById(id)
//	                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + id));
//	    }

	public List<Product> getProductByCategory(String categoryName) {
	
		Category category=new Category(categoryName);
		
		List<Product> products=productRepository.findByCategory(category);
		
		return products;
	}


	
}
