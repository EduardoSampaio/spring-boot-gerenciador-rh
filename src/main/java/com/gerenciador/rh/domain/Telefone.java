package com.gerenciador.rh.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Telefones")
public class Telefone implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "residencial",length = 15,nullable = true)
	private String residencial;
	@Column(name = "celular",length = 15,nullable = false)
	private String celular;
	@Column(name = "profissional",length = 15,nullable = true)
	private String profissional;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name= "candidato_id")
	private Candidato candidato;
	
	public Telefone() {
	}

	public Telefone(Long id, String residencial, String celular, String profissional) {
		this.id = id;
		this.residencial = residencial;
		this.celular = celular;
		this.profissional = profissional;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResidencial() {
		return residencial;
	}

	public void setResidencial(String residencial) {
		this.residencial = residencial;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getProfissional() {
		return profissional;
	}

	public void setProfissional(String profissional) {
		this.profissional = profissional;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
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
		Telefone other = (Telefone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", residencial=" + residencial + ", celular=" + celular + ", profissional="
				+ profissional + "]";
	}
	
	
}
