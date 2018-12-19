package com.gerenciador.rh.service;

import java.util.List;

import com.gerenciador.rh.domain.Candidato;

public interface CandidatoService {

	Candidato insert(Candidato obj);
	Candidato update(Candidato obj);
	void delete(Long id);
	Candidato findById(Long id);
	List<Candidato> findAll();
}
