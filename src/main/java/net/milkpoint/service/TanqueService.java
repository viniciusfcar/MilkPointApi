package net.milkpoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.milkpoint.model.Tanque;
import net.milkpoint.repository.TanqueRepository;


@Service
public class TanqueService {
	
	@Autowired
	private TanqueRepository repository;

	public Tanque save(Tanque Tanque) {
		return repository.saveAndFlush(Tanque);
	}

	public List<Tanque> findAll() {
		return repository.findAll();
	}
	
	public Tanque findOne(Long id) {
		return repository.getOne(id);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}


}
