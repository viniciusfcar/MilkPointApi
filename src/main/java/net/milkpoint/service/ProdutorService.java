package net.milkpoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.milkpoint.model.Produtor;
import net.milkpoint.repository.ProdutorRepository;

@Service
public class ProdutorService {
	
	@Autowired
	private ProdutorRepository repository;
	
	public Produtor save(Produtor produtor) {
        return repository.saveAndFlush(produtor);
    }

	public List<Produtor> findAll(){
		return repository.findAll();
	}
	
	public Produtor findOne(Long id) {
        return repository.getOne(id);
    }
     
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
