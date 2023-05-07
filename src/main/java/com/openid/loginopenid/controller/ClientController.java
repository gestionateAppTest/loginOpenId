package com.openid.loginopenid.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openid.loginopenid.dto.CreateClientDTO;
import com.openid.loginopenid.dto.MessageDTO;
import com.openid.loginopenid.service.ClientService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("client")
@RequiredArgsConstructor
@Slf4j
public class ClientController {

	
	private final ClientService clientService;
	
	@PostMapping("/create")
	public ResponseEntity<MessageDTO> create(@RequestBody CreateClientDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.create(dto));
	}
	
}
