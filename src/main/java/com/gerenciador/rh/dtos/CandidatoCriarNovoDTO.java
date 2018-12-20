package com.gerenciador.rh.dtos;

import java.io.Serializable;
import java.util.List;

import com.gerenciador.rh.domain.Endereco;
import com.gerenciador.rh.domain.Experiencia;
import com.gerenciador.rh.domain.Telefone;

public class CandidatoCriarNovoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private Double pretensaoSalarial;
	private String fotoUrl;
	private String curriculoUrl;
	private Endereco endereco;
	private List<Telefone> telefone;
	private List<Experiencia> experiencias;
	
	public CandidatoCriarNovoDTO() {
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
	public List<Telefone> getTelefone() {
		return telefone;
	}
	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}
	public List<Experiencia> getExperiencias() {
		return experiencias;
	}
	public void setExperiencias(List<Experiencia> experiencias) {
		this.experiencias = experiencias;
	}

}
