package com.pm.auth_service.dto;



public class LoginResponseDTO {

	private final String token; // Cannot accidently override the token

	public LoginResponseDTO(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}
	
	
	
}
