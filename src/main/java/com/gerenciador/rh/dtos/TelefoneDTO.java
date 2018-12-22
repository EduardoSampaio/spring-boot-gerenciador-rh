package com.gerenciador.rh.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class TelefoneDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	@NotEmpty(message = "Por favor preencha o campo cargo")
	@Length(max = 30,message = "O campo residencial deve ter no máximo 30 caracteres")
	private String residencial;
	@NotEmpty(message = "Por favor preencha o campo telefone celular")
	@Length(max = 30,message = "O campo celular deve ter no máximo 30 caracteres")
	private String celular;
	@Length(max = 30,message = "O campo profissional deve ter no máximo 30 caracteres")
	private String profissional;
	
	public TelefoneDTO() {
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

}
