package com.openid.loginopenid.dto;

import java.util.Set;

import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateClientDTO {

	private String id;
	private String clientId;
	private String clientSecret;
	private Set<ClientAuthenticationMethod> authenticacionMethods;
	private Set<AuthorizationGrantType> authorizationGrantTypes;
	private Set<String> redirectsUris;
	private Set<String> scopes;
	private boolean requireProofKey;
	
}
