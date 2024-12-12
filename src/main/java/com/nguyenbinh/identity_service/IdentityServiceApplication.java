package com.nguyenbinh.identity_service;

import com.nguyenbinh.identity_service.dto.request.UserCreationRequest;
import com.nguyenbinh.identity_service.repository.UserRepository;
import com.nguyenbinh.identity_service.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IdentityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdentityServiceApplication.class, args);
			
	}
}
