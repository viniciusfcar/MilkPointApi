package net.milkpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.milkpoint.model.Tanque;

@Repository
public interface TanqueRepository extends JpaRepository<Tanque, Long> {
	
}
