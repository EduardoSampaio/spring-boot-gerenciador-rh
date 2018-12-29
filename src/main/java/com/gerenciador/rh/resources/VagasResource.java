package com.gerenciador.rh.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gerenciador.rh.domain.Vagas;
import com.gerenciador.rh.dtos.VagasDTO;
import com.gerenciador.rh.service.VagasService;

@RestController
@RequestMapping(value="/api/v1/vagas")
public class VagasResource {
	
	@Autowired
	private VagasService service;
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<VagasDTO> find(@PathVariable Long id){
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<VagasDTO>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody VagasDTO dto){
		Vagas obj = service.insert(dto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody VagasDTO objDto) {
		service.update(objDto);
		return ResponseEntity.noContent().build();
	}
}
