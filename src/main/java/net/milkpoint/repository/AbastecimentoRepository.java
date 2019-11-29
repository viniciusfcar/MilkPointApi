package net.milkpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.milkpoint.model.Abastecimento;


@Repository
public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Long>{ 
	
}
