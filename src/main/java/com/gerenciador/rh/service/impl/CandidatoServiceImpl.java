package com.gerenciador.rh.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.gerenciador.rh.domain.Candidato;
import com.gerenciador.rh.dtos.CandidatoCriarNovoDTO;
import com.gerenciador.rh.dtos.CandidatoDTO;
import com.gerenciador.rh.repositories.CandidatoRepository;
import com.gerenciador.rh.service.CandidatoService;

@Service
public class CandidatoServiceImpl  implements CandidatoService {
	
	@Autowired
	private CandidatoRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
		
	}
	@Override
	public Candidato insert(CandidatoCriarNovoDTO obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Candidato update(CandidatoDTO obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);	
	}

	@Override
	public CandidatoDTO findById(Long id) {
		Optional<Candidato> obj = repository.findById(id);
		
		//TODO EXCEPTION
	
		return modelMapper.map(obj, CandidatoDTO.class);

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CandidatoDTO> findAll() {
		List<CandidatoDTO> list = new ArrayList<>();
		return modelMapper.map(repository.findAll(), list.getClass());
	}

}
