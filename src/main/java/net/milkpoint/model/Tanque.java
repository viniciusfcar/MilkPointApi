package net.milkpoint.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Tanque implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	@Column(nullable = false, length = 100)
	@NotBlank(message = "Nome é uma informação obrigatória.")
	private String nome;
	
	@Column
	private String descricao;
	
	@Column
	private String localizacao;
	
	@Column
	private Long qtdAtual;
	
	@Column
	private Long qtdRestante;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataCriacao;
	
	@Column
	private Long capacidade;

	@ManyToOne
	public Responsavel responsavel;

	@Column
	private Status status = Status.INATIVO;
	
	@OneToMany
	@JoinTable(name="abastecimento")
	private List<Abastecimento> abastecimentos;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
	
	public Long getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Long capacidade) {
		this.capacidade = capacidade;
	}
	
	public Long getQtdAtual() {
		return qtdAtual;
	}

	public void setQtdAtual(Long qtdAtual) {
		this.qtdAtual = qtdAtual;
	}
	
	public Long getQtdRestante() {
		return qtdRestante;
	}

	public void setQtdRestante(Long qtdRestante) {
		this.qtdRestante = qtdRestante;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Abastecimento> getAbastecimentos() {
		return abastecimentos;
	}

	public void setAbastecimentos(List<Abastecimento> abastecimentos) {
		this.abastecimentos = abastecimentos;
	}
	
	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
