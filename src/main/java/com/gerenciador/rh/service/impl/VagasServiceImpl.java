package com.gerenciador.rh.service.impl;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.gerenciador.rh.domain.Vagas;
import com.gerenciador.rh.dtos.VagasDTO;
import com.gerenciador.rh.repositories.VagasRepository;
import com.gerenciador.rh.service.VagasService;
import com.gerenciador.rh.service.exceptions.ObjectNotFoundException;

@Service
public class VagasServiceImpl implements VagasService {

	@Autowired
	private VagasRepository repository;
	
	@Override
	public Vagas insert(VagasDTO dto) {
		dto.setId(null);
		Vagas obj = dto.toEntity();
		obj = repository.save(obj);
		return obj;
	}

	@Override
	public void update(VagasDTO dto) {
		Vagas obj = dto.toEntity();
		repository.save(obj);	
	}

	@Override
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);	
	}

	@Override
	public VagasDTO findById(Long id) {
		Optional<Vagas> obj = repository.findById(id);
		
		obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Vagas.class.getName()));
		
		return VagasDTO.toDTO(obj.get());
	}

	@Cacheable("exemploCache")
	@Override
	public List<VagasDTO> findAll() {
		return repository
				.findAll()
				.stream()
				.map(v -> VagasDTO.toDTO(v))
				.collect(toList());
	}

}
