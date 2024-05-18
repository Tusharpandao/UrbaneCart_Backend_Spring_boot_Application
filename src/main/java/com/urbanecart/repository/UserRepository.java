package com.urbanecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urbanecart.pojo.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmail(String email);

}
