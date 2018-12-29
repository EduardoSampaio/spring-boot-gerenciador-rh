package com.gerenciador.rh.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.gerenciador.rh.domain.Vagas;

public class VagasDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotEmpty(message = "Por favor preencha o campo titulo")
	@Length(max = 30,message = "O campo titulo deve ter no máximo 30 caracteres")
	private String titulo;
	@NotEmpty(message = "Por favor preencha o campo descricao")
	@Length(max = 30,message = "O campo descricao deve ter no máximo 30 caracteres")
	private String descricao;
	@NotEmpty(message = "Por favor preencha o campo localidade")
	@Length(max = 30,message = "O campo localidade deve ter no máximo 30 caracteres")
	private String localidade;
	private Double salario;
	
	public VagasDTO() {
	}
	
	public VagasDTO(Long id, String titulo, String localidade,String descricao, Double salario) {
		this.id = id;
		this.titulo = titulo;
		this.localidade = localidade;
		this.salario = salario;
		this.descricao = descricao;
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
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	@Override
	public String toString() {
		return "VagasDTO [id=" + id + ", titulo=" + titulo + ", localidade=" + localidade + ", salario=" + salario
				+ "]";
	}
	
	public Vagas toEntity() {
		return new Vagas(id, titulo, localidade,descricao, salario);
	}
	
	public static VagasDTO toDTO(Vagas vagas) {
		return new VagasDTO(vagas.getId(), vagas.getTitulo(), vagas.getLocalidade(),vagas.getDescricao(), vagas.getSalario());
	}
}
