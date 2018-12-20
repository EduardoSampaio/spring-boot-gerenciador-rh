package com.gerenciador.rh.service;

import java.util.List;

import com.gerenciador.rh.domain.Candidato;
import com.gerenciador.rh.dtos.CandidatoCriarNovoDTO;
import com.gerenciador.rh.dtos.CandidatoDTO;

public interface CandidatoService {

	Candidato insert(CandidatoCriarNovoDTO obj);
	Candidato update(CandidatoDTO obj);
	void delete(Long id);
	CandidatoDTO findById(Long id);
	List<CandidatoDTO> findAll();
}
