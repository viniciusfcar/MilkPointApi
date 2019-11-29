package net.milkpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.milkpoint.model.Log;


@Repository
public interface LogRepository extends JpaRepository<Log, Long>{ 
	
}
