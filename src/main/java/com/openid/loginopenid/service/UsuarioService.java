package com.openid.loginopenid.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.openid.loginopenid.dto.CreateUsuarioDTO;
import com.openid.loginopenid.dto.MessageDTO;
import com.openid.loginopenid.entity.Rol;
import com.openid.loginopenid.entity.Usuario;
import com.openid.loginopenid.enums.RolName;
import com.openid.loginopenid.repository.RolRespository;
import com.openid.loginopenid.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	@Autowired
	private final UsuarioRepository usuarioRepository;
	
	@Autowired
	private final RolRespository rolRespository;
	
	@Autowired
	private final PasswordEncoder passwordEncoder;
	
	public MessageDTO createUsuario(CreateUsuarioDTO dto) {
		
		Usuario usuario = Usuario.builder()
				.username(dto.username())
				.email(dto.email())
				.nombre("Juan")
				.apellido1("galan")
				.activo("S")
				.password(passwordEncoder.encode(dto.password()))
				.build();
		
		Set<Rol> roles = new HashSet<Rol>();
		dto.roles().forEach(r -> {
			Rol rol = rolRespository.findByRole(RolName.valueOf(r)).orElseThrow(() -> new RuntimeException("Rol no encontrado"));
			roles.add(rol);
		});
		
		usuario.setRoles(roles);
		usuarioRepository.save(usuario);
		return new MessageDTO("user " + usuario.getUsername() + " saved");
	}
	
}
