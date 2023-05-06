package com.openid.loginopenid.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openid.loginopenid.dto.CreateUsuarioDTO;
import com.openid.loginopenid.dto.MessageDTO;
import com.openid.loginopenid.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final UsuarioService usuarioService;

	@PostMapping("/create")
	public ResponseEntity<MessageDTO> createUser(@RequestBody CreateUsuarioDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.createUsuario(dto));
	}
	
}
