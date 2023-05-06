package com.openid.loginopenid.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.openid.loginopenid.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Optional<Usuario> findByUsername(String username);

}
