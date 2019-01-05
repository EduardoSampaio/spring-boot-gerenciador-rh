package com.gerenciador.rh.domain;

import static javax.persistence.FetchType.EAGER;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.gerenciador.rh.config.SenhaUtils;

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
	@Column(name = "fotoUrl", nullable = true)
	private String fotoUrl;
	@Column(name = "curriculoUrl", nullable = true)
	private String curriculoUrl;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	@OneToMany(mappedBy = "candidato", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Telefone> telefone;
	@OneToMany(mappedBy = "candidato", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Experiencia> experiencias;
	@ManyToMany(fetch=EAGER)
	@JoinTable(name= "Candidato_vagas",
				joinColumns = @JoinColumn(name="candidato_id"),
				inverseJoinColumns = @JoinColumn(name="vagas_id"))
	private List<Vagas> vagas;
	
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
		this.senha =  SenhaUtils.gerarBCrypt(senha);
		this.pretensaoSalarial = pretensaoSalarial;
		this.fotoUrl = fotoUrl;
		this.curriculoUrl = curriculoUrl;
	}

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


	public String getSobrenome() {
		return sobrenome;
	}


	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Double getPretensaoSalarial() {
		return pretensaoSalarial;
	}


	public void setPretensaoSalarial(Double pretensaoSalarial) {
		this.pretensaoSalarial = pretensaoSalarial;
	}


	public String getFotoUrl() {
		return fotoUrl;
	}


	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}


	public String getCurriculoUrl() {
		return curriculoUrl;
	}


	public void setCurriculoUrl(String curriculoUrl) {
		this.curriculoUrl = curriculoUrl;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}


	public void setExperiencias(List<Experiencia> experiencias) {
		this.experiencias = experiencias;
	}


	public List<Experiencia> getExperiencias() {
		if(experiencias == null) {
			experiencias = new ArrayList<>();
		}
		return experiencias;
	}

	public List<Telefone> getTelefone() {
		if(telefone == null) {
			telefone = new ArrayList<>();
		}
		return telefone;
	}

	public List<Vagas> getVagas() {
		if(vagas == null) {
			vagas = new ArrayList<>();
		}
		return vagas;
	}



	@Override
	public String toString() {
		return "Candidato [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", senha="
				+ senha + ", pretensaoSalarial=" + pretensaoSalarial + ", fotoUrl=" + fotoUrl + ", curriculoUrl="
				+ curriculoUrl + ", endereco=" + endereco + ", telefone=" + telefone + ", experiencias=" + experiencias
				+ "]";
	}	
}
