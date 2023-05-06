package com.openid.loginopenid.dto;

import java.util.List;

public record CreateUsuarioDTO (
	
	String username,
	String password,
	String email,
	List<String> roles) {}
