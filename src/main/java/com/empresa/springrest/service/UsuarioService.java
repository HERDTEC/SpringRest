package com.empresa.springrest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.empresa.springrest.entity.Restaurante;
import com.empresa.springrest.entity.Usuario;
import com.empresa.springrest.repository.UsuarioRepository;

@Service("usuarioService")
public class UsuarioService implements UserDetailsService {
	@Autowired
	@Qualifier("usuarioRepository")
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = usuarioRepository.findByUser(username);
		return new User(user.getUser(),user.getPassword(), 
				user.isStatus(), user.isStatus(), user.isStatus(), user.isStatus(),
				buildGranted(user.getRole()));
	}
	public List<GrantedAuthority>  buildGranted(byte rol){
		String [] roles = {"LECTOR", "USUARIO", "ADMINISTRADOR"};
		List<GrantedAuthority> auth = new ArrayList<>();
		for(int i = 0; i< rol; i++)
		{
			auth.add(new SimpleGrantedAuthority(roles[i]));
		}
		return auth;
	}
	public boolean crear(Usuario user) {
		try {
			usuarioRepository.save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	

}
