package com.pm.auth_service.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pm.auth_service.model.User;
import com.pm.auth_service.repository.IUserRepository;

@Service
public class UserService {

	private final IUserRepository userRepo;
	
	public UserService(IUserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public Optional<User> findByEmail(String email){
		
		return userRepo.findByEmail(email);
		
	}
	
	
	
}
