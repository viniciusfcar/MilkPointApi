package net.milkpoint.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.milkpoint.model.Abastecimento;
import net.milkpoint.model.Log;
import net.milkpoint.model.Responsavel;
import net.milkpoint.model.Status;
import net.milkpoint.repository.AbastecimentoRepository;
import net.milkpoint.repository.LogRepository;

@Service
public class AbastecimentoService {
	
	@Autowired
	private AbastecimentoRepository repository;
	private LogRepository logger;
	
	public Abastecimento save(Abastecimento abastecimento) {
		Log.Tipo tipo;
		if(abastecimento.getId() == null) {
			tipo = Log.Tipo.Cadstro;
		} else {
			tipo = Log.Tipo.Alteracão;
		}
		abastecimento = repository.saveAndFlush(abastecimento);
		log(tipo, abastecimento);
		return abastecimento;
    }
	
	public List<Abastecimento> findAll(){
		return repository.findAll();
	}
	
	public Abastecimento findOne(Long id) {
        return repository.getOne(id);
    }
	
    public void delete(Long id) {
        //repository.deleteById(id);
    	Abastecimento abastecimento = repository.getOne(id);
    	abastecimento.setStatus(Status.DELETADO);
    	log(Log.Tipo.Remoção, abastecimento);
    	repository.saveAndFlush(abastecimento).getStatus();
    }
    
    public void setStatus(Long id, Status status, Responsavel responsavel) {
    	Abastecimento abastecimento = repository.getOne(id);
    	abastecimento.setStatus(status);
    	abastecimento.setResponsavel(responsavel);
    	log(Log.Tipo.Alteracão, abastecimento);
    	repository.saveAndFlush(abastecimento).getStatus();
    }
    
	public Abastecimento deposito(Abastecimento deposito) {
		if(deposito.getQauntidade()<0) {
			deposito.setQauntidade(deposito.getQauntidade()*-1);
		}
		return repository.saveAndFlush(deposito);
	}
	
	public Abastecimento retirada(Abastecimento retirada) {
		if(retirada.getQauntidade()>0) {
			retirada.setQauntidade(retirada.getQauntidade()*-1);
		}
		return repository.saveAndFlush(retirada);
	}
	
	private void log (Log.Tipo tipo, Abastecimento abastecimento) {
		Log log = new Log(tipo, abastecimento.getResponsavel(), abastecimento.getTanque(), 
				abastecimento, abastecimento.getProdutor(), abastecimento.getLaticinio(), 
				abastecimento.getQauntidade(), abastecimento.getStatus(), new Date(), ""+abastecimento.getTipo());
		logger.saveAndFlush(log);
	}

}
