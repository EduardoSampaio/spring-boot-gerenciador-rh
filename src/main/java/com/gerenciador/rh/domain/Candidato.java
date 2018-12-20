package com.gerenciador.rh.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Candidatos",indexes= { @Index(columnList="email",unique=true,name="IX_CANDIDATO_EMAIL")})
public class Candidato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nome", length = 30, nullable = false)
	private String nome;
	@Column(name = "sobrenome", length = 30, nullable = false)
	private String sobrenome;
	@Column(name = "email", length = 30, nullable = false)
	private String email;
	@Column(name = "senha", length = 40, nullable = false)
	private String senha;
	@Column(name = "pretensaoSalarial", scale = 2, precision = 5, nullable = false)
	private Double pretensaoSalarial;
	@Column(name = "fotoUrl", nullable = false)
	private String fotoUrl;
	@Column(name = "curriculoUrl", nullable = false)
	private String curriculoUrl;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "endereco_id")
	@MapsId
	private Endereco endereco;
	@OneToMany(mappedBy = "candidato", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Telefone> telefone;
	@OneToMany(mappedBy = "candidato", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Experiencia> experiencias;
	
	
	public Candidato() {
	}
	
	
	/***
	 * 
	 * @param id
	 * @param nome
	 * @param sobrenome
	 * @param email
	 * @param senha
	 * @param pretensaoSalarial
	 * @param fotoUrl
	 * @param curriculoUrl
	 */
	public Candidato(Long id, String nome, String sobrenome, String email, String senha, Double pretensaoSalarial,
			String fotoUrl, String curriculoUrl) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.pretensaoSalarial = pretensaoSalarial;
		this.fotoUrl = fotoUrl;
		this.curriculoUrl = curriculoUrl;
	}



	public String getCurriculoUrl() {
		return curriculoUrl;
	}

	public String getEmail() {
		return email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public List<Experiencia> getExperiencias() {
		if(experiencias == null) {
			experiencias = new ArrayList<>();
		}
		return experiencias;
	}

	public String getFotoUrl() {
		return fotoUrl;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Double getPretensaoSalarial() {
		return pretensaoSalarial;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public List<Telefone> getTelefone() {
		if(telefone == null) {
			telefone = new ArrayList<>();
		}
		return telefone;
	}

	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public void setCurriculoUrl(String curriculoUrl) {
		this.curriculoUrl = curriculoUrl;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPretensaoSalarial(Double pretensaoSalarial) {
		this.pretensaoSalarial = pretensaoSalarial;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
}
