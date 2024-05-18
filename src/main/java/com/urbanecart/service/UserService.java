package com.urbanecart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.urbanecart.pojo.User;
import com.urbanecart.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User useradd(User user) {
		
		return userRepository.save(user);
	}

	public User findUser(User user) {
		
		
		return userRepository.findByEmail(user.getEmail());
	}


}
