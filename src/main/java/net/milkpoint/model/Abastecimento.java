package net.milkpoint.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Abastecimento implements Serializable{
	public enum Tipo {
	    DEPOSITO,
	    RETIRADA
	}
	private Status status = Status.PENDENTE;
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	@Column
	private Produtor produtor;
	
	@Column
	private Responsavel responsavel;
	
	@Column
	private Laticinio laticinio;
	
	@Column
	private Tanque tanque;
	
	@Column
	private Date data;
	
	@Column
	private Tipo tipo;
	
	@Column
	private Long quantidade;

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

	public void setData(Date data) {
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
	
	public Tipo getTipo() {
		return tipo;
	}
	
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

}
