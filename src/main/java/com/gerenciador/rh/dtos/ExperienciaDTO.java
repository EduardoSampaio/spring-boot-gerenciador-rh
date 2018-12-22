package com.gerenciador.rh.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class ExperienciaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotEmpty(message = "Por favor preencha o campo empresa")
	@Length(min = 4,max = 30,message = "O campo empresa deve ter entre 4 e 30 caracteres")
	private String empresa;
	private Boolean atual;
	@NotEmpty(message = "Por favor preencha o campo data inicio")
	private Date inicio;
	private Date fim;
	@NotEmpty(message = "Por favor preencha o campo descricao")
	@Length(min = 30,max = 100,message = "O campo descricao deve ter entre 30 e 100 caracteres")
	private String descricao;
	@NotEmpty(message = "Por favor preencha o campo salario")
	private Double salario;
	@NotEmpty(message = "Por favor preencha o campo cargo")
	@Length(min = 4,max = 30,message = "O campo cargo deve ter entre 4 e 30 caracteres")
	private String cargo;
	
	public ExperienciaDTO() {
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
}
