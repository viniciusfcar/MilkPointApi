package net.milkpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.milkpoint.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{ 
	
		//public Usuario findByEmail(String email);
	
}
