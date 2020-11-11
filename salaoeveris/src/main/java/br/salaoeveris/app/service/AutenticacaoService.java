package br.salaoeveris.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.salaoeveris.app.model.Usuario;
import br.salaoeveris.app.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Optional<Usuario> usuario=repository.findByEmail(username);
	
		if( usuario.isPresent()) {
			return usuario.get();
		}
		throw new UsernameNotFoundException("Dados Inválidos");
	}
	
	
}
