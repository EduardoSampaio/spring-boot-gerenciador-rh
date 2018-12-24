package com.gerenciador.rh.service.impl;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(CandidatoServiceImpl.class);
	 
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
		logger.info("Acessando service findall");
		return candidatoRepository.findAll().stream()
				.map(c -> CandidatoDTO.toDTO(c))
				.collect(toList());
	}

	@Override
	public CandidatoDTO findById(Long id) {
		logger.info("Acessando service findById: "  + id);
		Optional<Candidato> obj = candidatoRepository.findById(id);
	
		obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Candidato.class.getName()));
			
		return  CandidatoDTO.toDTO(obj.get());

	}

	@Override
	public Candidato insert(CandidatoDTO dto) {
		logger.info("Acessando service insert: "  + dto.toString());
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
		logger.info("salvando telefones: "  + telefones.toString());
		telefoneRepository.saveAll(telefones);
		
		List<Experiencia> experiencias  = new ArrayList<>();
		for (Experiencia experiencia : candidato.getExperiencias()) {
			experiencia.setCandidato(candidato);
			experiencias.add(experiencia);
		}
		logger.info("salvando experiencias: "  + experiencias.toString());
		experienciaRepository.saveAll(experiencias);
	}


	@Override
	public void update(CandidatoDTO dto) {
		logger.info("salvando telefones: "  + dto.toString());
		findById(dto.getId());		
		Candidato candidato = dto.toEntity(); 
		salvarDependencias(candidato);
		candidatoRepository.save(candidato);	
	}	
}
