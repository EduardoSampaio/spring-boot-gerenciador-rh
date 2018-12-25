package com.gerenciador.rh.domain;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name= "Vagas")
public class Vagas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;
	@Column(name = "titulo", length = 30, nullable = false)
	private String titulo;
	@Column(name = "localidade", length = 30, nullable = false)
	private String localidade;
	@Column(name = "salario", scale = 5, precision = 2, nullable = false)
	private Double salario;
	@ManyToMany(mappedBy="vagas",fetch = EAGER)
	private List<Candidato> candidatos;

	public Vagas() {
	}

	public Vagas(Long id, String titulo, String localidade, Double salario) {
		this.id = id;
		this.titulo = titulo;
		this.localidade = localidade;
		this.salario = salario;
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
		Vagas other = (Vagas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vagas [id=" + id + ", titulo=" + titulo + ", localidade=" + localidade + ", salario=" + salario + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public List<Candidato> getCandidatos() {
		if(candidatos == null) {
			candidatos = new ArrayList<>();
		}
		return candidatos;
	}
}
