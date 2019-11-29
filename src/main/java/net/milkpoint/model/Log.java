package net.milkpoint.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Log implements Serializable{

	public enum Tipo {
		Cadstro,
		Alteracão,
		Remoção,
	}
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	@Column
	private Status status;
	
	@Column
	private Tanque tanque;
	
	@Column
	private Produtor produtor;
	
	@Column
	private Laticinio laticinio;
	
	@Column
	private Responsavel responsavel;
	
	@Column
	private Abastecimento abastecimento;
	
	@Column
	private Long quantidade;
		
	@Column
	private Date data;
	
	@Column
	private Tipo tipo;
	
	@Column
	private String log;
	
	public Log(Tipo tipo, Responsavel responsavel, Tanque tanque, 
			Abastecimento abastecimento, Produtor produtor, Laticinio laticinio, 
			Long quantidade, Status status, Date data, String log) {
	
		this.tipo = tipo;
		this.responsavel = responsavel;
		this.tanque = tanque;
		this.abastecimento = abastecimento;
		this.produtor = produtor;
		this.laticinio = laticinio;
		this.quantidade = quantidade;
		this.status = status;
		this.data = data;
		this.log = log;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produtor getProdutor() {
		return produtor;
	}

	public void setProdutor(Produtor produtor) {
		this.produtor = produtor;
	}
	
	public Laticinio getLaticinio() {
		return laticinio;
	}

	public void setLaticinio(Laticinio laticinio) {
		this.laticinio = laticinio;
	}
	
	public Responsavel getResponsavel() {
		return responsavel;
	}
	
	public void setResponsavel(Responsavel responsavel) {
		this.responsavel= responsavel;
	}
	
	public Tanque getTanque() {
		return tanque;
	}
	
	public void setTanque(Tanque tanque) {
		this.tanque = tanque;
	}
	
	public Date getData() {
		return data;
	}

	public void setdata(Date data) {
		this.data = data;
	}

	public Long getQauntidade() {
		return quantidade;
	}

	public void setQauntidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Status getStatus() {
		return status;
	}

	public Status setStatus(Status status) {
		this.status = status;
		return this.status;
	}

}
