package com.openid.loginopenid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;

import com.openid.loginopenid.dto.CreateClientDTO;
import com.openid.loginopenid.dto.MessageDTO;
import com.openid.loginopenid.entity.Client;
import com.openid.loginopenid.repository.ClientRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientService implements RegisteredClientRepository{

	@Autowired
	private final ClientRepository clientRepository;
	
	@Autowired
	private final PasswordEncoder passwordEncoder;
	
	
	@Override
	public void save(RegisteredClient registeredClient) {
		
	}
	
	public MessageDTO create(CreateClientDTO dto) {
		Client client = clientFromDto(dto);
		clientRepository.save(client);
		return new MessageDTO("client " + client.getClientId() + " saved");
	}

	@Override
	public RegisteredClient findById(String id) {
		Client client = clientRepository.findByClientId(id).orElseThrow(() -> new RuntimeException("client not found"));
		return Client.toRegisteredClient(client);
	}

	@Override
	public RegisteredClient findByClientId(String clientId) {
		Client client = clientRepository.findByClientId(clientId).orElseThrow(() -> new RuntimeException("client not found"));
		return Client.toRegisteredClient(client);
	}
	
	private Client clientFromDto(CreateClientDTO dto) {
		Client client = Client.builder()
				.clientId(dto.getClientId())
				.clientSecret(passwordEncoder.encode(dto.getClientSecret()))
				.authenticacionMethods(dto.getAuthenticacionMethods())
				.authorizationGrantTypes(dto.getAuthorizationGrantTypes())
				.redirectsUris(dto.getRedirectsUris())
				.scopes(dto.getScopes())
				.requireProofKey(dto.isRequireProofKey())
				.build();

		return client;
	}

	
	
}
