package com.gerenciador.rh.service.impl;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.rh.domain.Candidato;
import com.gerenciador.rh.domain.Experiencia;
import com.gerenciador.rh.domain.Telefone;
import com.gerenciador.rh.dtos.CandidatoDTO;
import com.gerenciador.rh.repositories.CandidatoRepository;
import com.gerenciador.rh.repositories.ExperienciaRepository;
import com.gerenciador.rh.repositories.TelefoneRepository;
import com.gerenciador.rh.service.CandidatoService;
import com.gerenciador.rh.service.exceptions.ObjectNotFoundException;

@Service
public class CandidatoServiceImpl  implements CandidatoService {
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@Autowired
	private ExperienciaRepository experienciaRepository;

	@Autowired
	private TelefoneRepository telefoneRepository;
	
	@Override
	public void delete(Long id) {
		findById(id);
		candidatoRepository.deleteById(id);	
	}
	@Override
	public List<CandidatoDTO> findAll() {
		return candidatoRepository.findAll().stream()
				.map(c -> CandidatoDTO.toDTO(c))
				.collect(toList());
	}

	@Override
	public CandidatoDTO findById(Long id) {
		Optional<Candidato> obj = candidatoRepository.findById(id);
	
		obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Candidato.class.getName()));
			
		return  CandidatoDTO.toDTO(obj.get());

	}

	@Override
	public Candidato insert(CandidatoDTO dto) {
		dto.setId(null);
		Candidato candidato = dto.toEntity(); 
		candidato = candidatoRepository.save(candidato);
	
		salvarDependencias(candidato);
		
		return candidato;
	}

	private void salvarDependencias(Candidato candidato) {
		List<Telefone> telefones = new ArrayList<>();
		for (Telefone telefone : candidato.getTelefone()) {
			telefone.setCandidato(candidato);
			telefones.add(telefone);
		}
		telefoneRepository.saveAll(telefones);
		
		List<Experiencia> experiencias  = new ArrayList<>();
		for (Experiencia experiencia : candidato.getExperiencias()) {
			experiencia.setCandidato(candidato);
			experiencias.add(experiencia);
		}
		experienciaRepository.saveAll(experiencias);
	}


	@Override
	public void update(CandidatoDTO dto) {
		findById(dto.getId());		
		Candidato candidato = dto.toEntity(); 
		salvarDependencias(candidato);
		candidatoRepository.save(candidato);	
	}	
}
