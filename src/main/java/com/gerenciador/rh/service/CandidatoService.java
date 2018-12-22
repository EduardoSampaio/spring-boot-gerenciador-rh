package com.gerenciador.rh.service;

import java.util.List;

import com.gerenciador.rh.domain.Candidato;
import com.gerenciador.rh.dtos.CandidatoDTO;

public interface CandidatoService {

	Candidato insert(CandidatoDTO obj);
	void update(CandidatoDTO obj);
	void delete(Long id);
	CandidatoDTO findById(Long id);
	List<CandidatoDTO> findAll();
}
