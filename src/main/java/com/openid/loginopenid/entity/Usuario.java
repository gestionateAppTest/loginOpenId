package com.openid.loginopenid.entity;

import java.sql.Date;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario implements UserDetails{

	private static final long serialVersionUID = -5693287489870243295L;
	
	@Id
	@Column(name = "usuario_id")
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "creacion")
	private String creacion;
	
	@Column(name = "f_creacion")
	private Date f_creacion;
	
	@Column(name = "modificacion")
	private String modificacion;
	
	@Column(name = "f_modificacion")
	private Date f_modificacion;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido1")
	private String apellido1;
	
	@Column(name = "apellido2")
	private String apellido2;
	
	@Column(name = "activo")
	private String activo;
	
	@Column(name = "f_baja")
	private Date f_baja;
	
	@Column(name = "f_ult_inicio_sesion")
	private Date f_ult_inicio_sesion;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private Set<Rol> roles;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return boleanoActivo();
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return boleanoActivo();
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return boleanoActivo();
	}
	
	@Override
	public boolean isEnabled() {
		return boleanoActivo();
	}
	
	private boolean boleanoActivo() {
		if(activo != null && activo.equals('N')) {
			return false;
		}else {
			return true;
		}
	}
	
}
