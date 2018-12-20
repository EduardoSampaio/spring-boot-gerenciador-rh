package com.gerenciador.rh.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Experiencias")
public class Experiencia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "empresa", length = 30, nullable = false)
	private String empresa;
	@Column(name = "atual",nullable = false)
	private Boolean atual = Boolean.FALSE;
	@Temporal(TemporalType.DATE)
	@Column(name = "inicio",nullable = false)
	private Date inicio;
	@Temporal(TemporalType.DATE)
	@Column(name = "fim",nullable = true)
	private Date fim;
	@Column(name = "descricao", length = 30, nullable = false)
	private String descricao;
	@Column(name = "salario", scale=2,precision = 5, nullable = false)
	private Double salario;
	@Column(name = "cargo", length = 30, nullable = false)
	private String cargo;
	@ManyToOne(fetch = FetchType.EAGER)
	private Candidato candidato;
	
	public Experiencia() {}

	public Experiencia(Long id, String empresa, Boolean atual, Date inicio, Date fim, String descricao, Double salario,
			String cargo) {
		this.id = id;
		this.empresa = empresa;
		this.atual = atual;
		this.inicio = inicio;
		this.fim = fim;
		this.descricao = descricao;
		this.salario = salario;
		this.cargo = cargo;
	}
	
	public Experiencia(Long id, String empresa, Boolean atual, Date inicio, String descricao, Double salario,
			String cargo) {
		this.id = id;
		this.empresa = empresa;
		this.atual = atual;
		this.inicio = inicio;
		this.descricao = descricao;
		this.salario = salario;
		this.cargo = cargo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Boolean getAtual() {
		return atual;
	}

	public void setAtual(Boolean atual) {
		this.atual = atual;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Experiencia other = (Experiencia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	@Override
	public String toString() {
		return "Experiencia [id=" + id + ", empresa=" + empresa + ", atual=" + atual + ", inicio=" + inicio + ", fim="
				+ fim + ", descricao=" + descricao + ", salario=" + salario + ", cargo=" + cargo + "]";
	}
	
	
	
	
}
