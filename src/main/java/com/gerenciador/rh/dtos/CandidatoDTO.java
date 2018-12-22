package com.gerenciador.rh.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class CandidatoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotEmpty(message = "Por favor preencha o campo nome")
	@Length(min = 4,max = 30,message = "O campo nome deve ter entre 4 e 30 caracteres")
	private String nome;
	@NotEmpty(message = "Por favor preencha o campo sobrenome")
	@Length(min = 4,max = 30,message = "O campo sobrenome deve ter entre 4 e 30 caracteres")
	private String sobrenome;
	@NotEmpty(message = "Por favor preencha o campo email")
	@Length(min = 4,max = 30,message = "O campo email deve ter entre 4 e 30 caracteres")
	private String email;	
	@NotEmpty(message = "Por favor preencha o campo senha")
	@Length(min = 4,max = 30,message = "O campo senha deve ter entre 4 e 30 caracteres")
	private String senha;
	//@NotEmpty(message = "Por favor preencha o campo pretensao salarial")
	private Double pretensaoSalarial;
	private String fotoUrl;
	private String curriculoUrl;
	private EnderecoDTO endereco;
	private List<TelefoneDTO> telefones;
	private List<ExperienciaDTO> experiencias;
	
	public CandidatoDTO() {
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

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public List<TelefoneDTO> getTelefones() {
		if(telefones == null) {
			telefones = new ArrayList<>();
		}
		return telefones;
	}

	public List<ExperienciaDTO> getExperiencias() {
		if(experiencias == null) {
			experiencias = new ArrayList<>();
		}
		return experiencias;
	}	

}
