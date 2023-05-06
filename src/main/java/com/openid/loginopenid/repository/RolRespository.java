package com.openid.loginopenid.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.openid.loginopenid.entity.Rol;
import com.openid.loginopenid.enums.RolName;

public interface RolRespository extends JpaRepository<Rol, Long>{

	Optional<Rol> findByRole(RolName rolname);
	
}
