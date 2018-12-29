package com.gerenciador.rh.service;

import java.util.List;

import com.gerenciador.rh.domain.Vagas;
import com.gerenciador.rh.dtos.VagasDTO;


public interface VagasService {

	Vagas insert(VagasDTO obj);
	void update(VagasDTO obj);
	void delete(Long id);
	VagasDTO findById(Long id);
	List<VagasDTO> findAll();
}
