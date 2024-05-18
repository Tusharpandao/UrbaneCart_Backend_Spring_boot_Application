package com.urbanecart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.urbanecart.pojo.User;
import com.urbanecart.response.ResponseStructure;
import com.urbanecart.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		
		User pojo=userService.useradd(user);
		if (pojo !=null) {
			
			return  new ResponseEntity<ResponseStructure<User>>
			(new ResponseStructure<User>("user added", pojo, HttpStatus.OK.value()),HttpStatus.OK);
		}
		return  new ResponseEntity<ResponseStructure<User>>
		(new ResponseStructure<User>("user not added", pojo, HttpStatus.BAD_REQUEST.value()),HttpStatus.BAD_REQUEST);
		
	}
	
	

}
