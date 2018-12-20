package com.gerenciador.rh.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class CandidatoTest {


	private Candidato candidato;
	
	@Test
	public void test_construtor() {
		candidato = new Candidato(1L,"nome","sobrenome", "email@email.com", "1234", 3.000, "foto", "curriculo");
		
		assertNotNull(candidato);
		assertEquals(candidato.getId(),new Long(1));
		assertEquals(candidato.getNome(),"nome");
		assertEquals(candidato.getSobrenome(),"sobrenome");
		assertEquals(candidato.getEmail(),"email@email.com");
		assertEquals(candidato.getSenha(),"1234");
		assertEquals(candidato.getPretensaoSalarial(),new Double(3.000));
		assertEquals(candidato.getFotoUrl(),"foto");
		assertEquals(candidato.getCurriculoUrl(),"curriculo");

	}
	
	@Test
	public void test_construtor_vazio() {
		candidato = new Candidato();
		
		assertNotNull(candidato);
		assertNull(candidato.getId());
		assertNull(candidato.getSobrenome());
		assertNull(candidato.getNome());
		assertNull(candidato.getEmail());
		assertNull(candidato.getSenha());
		assertNull(candidato.getEndereco());
		assertNull(candidato.getFotoUrl());
		assertNull(candidato.getCurriculoUrl());
		assertNull(candidato.getPretensaoSalarial());
	}
	
}

