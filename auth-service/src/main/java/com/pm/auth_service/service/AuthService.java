package com.pm.auth_service.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pm.auth_service.dto.LoginRequestDTO;
import com.pm.auth_service.util.JwtUtil;

import io.jsonwebtoken.JwtException;

@Service
public class AuthService {

	private final UserService userService;
	private final PasswordEncoder passwordEncoder; 
	private final JwtUtil jwtUtil;

	

	public AuthService(UserService userService, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
		super();
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtUtil;
	}



	public Optional<String> authenticate(LoginRequestDTO loginRequestDTO){
		
		
		Optional<String> token  = userService.findByEmail(loginRequestDTO.getEmail()) // user exist or not
				.filter(u -> passwordEncoder.matches(loginRequestDTO.getPassword(), u.getPassword())) // if chain ends here then token is empty (password valid or not)
				.map(u -> jwtUtil.generateToken(u.getEmail(), u.getRole()))  // if chain proceedes that means the password is matching
				// Generate token
				;
		
		return token;
		
	}
	
	public boolean validateToken(String token) {
		try {
			
			jwtUtil.validateToken(token);
			return true;
			
		} catch(JwtException e)
		{
			return false;
		}
	}
	
	
	
	
	
}
