package com.gerenciador.rh.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class EnderecoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	@NotEmpty(message = "Por favor preencha o campo logradouro")
	@Length(max = 50,message = "O campo logradouro deve ter no máximo 50 caracteres")
	private String logradouro;
	@NotEmpty(message = "Por favor preencha o campo numero")
	@Length(max = 5,message = "O campo logradouro deve ter no máximo 5 caracteres")
	private String numero;
	@NotEmpty(message = "Por favor preencha o campo cep")
	@Length(max = 15,message = "O campo cep deve ter no máximo 15 caracteres")
	private String cep;
	@NotEmpty(message = "Por favor preencha o campo bairro")
	@Length(max = 30,message = "O campo bairro deve ter no máximo 30 caracteres")
	private String bairro;
	@NotEmpty(message = "Por favor preencha o campo cidade")
	@Length(max = 30,message = "O campo cidade deve ter no máximo 30 caracteres")
	private String cidade;
	@NotEmpty(message = "Por favor preencha o campo uf")
	@Length(max = 30,message = "O campo uf deve ter no máximo 30 caracteres")
	private String uf;
	
	public EnderecoDTO() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}

}
