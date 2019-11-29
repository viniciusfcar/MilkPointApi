package net.milkpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.milkpoint.model.Responsavel;


@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long>{ }
