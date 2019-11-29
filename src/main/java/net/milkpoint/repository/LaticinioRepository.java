package net.milkpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.milkpoint.model.Laticinio;


@Repository
public interface LaticinioRepository extends JpaRepository<Laticinio, Long>{ }
