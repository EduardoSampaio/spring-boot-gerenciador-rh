package com.gerenciador.rh.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.gerenciador.rh.domain.Candidato;
import com.gerenciador.rh.dtos.CandidatoDTO;
import com.gerenciador.rh.repositories.CandidatoRepository;
import com.gerenciador.rh.service.CandidatoService;
import com.gerenciador.rh.service.exceptions.ObjectNotFoundException;

@Service
public class CandidatoServiceImpl  implements CandidatoService {
	
	@Autowired
	private CandidatoRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);	
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<CandidatoDTO> findAll() {
		List<CandidatoDTO> list = new ArrayList<>();
		return modelMapper.map(repository.findAll(), list.getClass());
	}

	@Override
	public CandidatoDTO findById(Long id) {
		Optional<Candidato> obj = repository.findById(id);
	
		obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Candidato.class.getName()));
			
		return modelMapper.map(obj, CandidatoDTO.class);

	}

	@Override
	public Candidato insert(CandidatoDTO obj) {
		obj.setId(null);
		Candidato cadidato = modelMapper.map(obj, Candidato.class);
		return repository.save(cadidato);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
		
	}

	@Override
	public void update(CandidatoDTO obj) {
		//TODO
	}
}
