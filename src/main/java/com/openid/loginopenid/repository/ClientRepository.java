package com.openid.loginopenid.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.openid.loginopenid.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	
	Optional<Client> findByClientId(String clientId);

}
