package com.openid.loginopenid.entity;

import org.springframework.security.core.GrantedAuthority;

import com.openid.loginopenid.enums.RolName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rol")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rol implements GrantedAuthority{

	private static final long serialVersionUID = 7755329980646409286L;

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "nombre")
	private RolName role;

	@Override
	public String getAuthority() {
		return role.name();
	}
	
	
}
