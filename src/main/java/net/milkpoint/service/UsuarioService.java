package net.milkpoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.milkpoint.model.Usuario;
import net.milkpoint.repository.UsuarioRepository;


@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario save(Usuario usuario) {
		return repository.saveAndFlush(usuario);
	}

	public List<Usuario> findAll() {
		return repository.findAll();
	}
	
	public Usuario findOne(Long id) {
		return repository.getOne(id);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	/*
	public Usuario findEmail(String email ) {
		return repository.findByEmail(email);
	}*/

}
