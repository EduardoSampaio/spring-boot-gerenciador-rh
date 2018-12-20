package com.gerenciador.rh.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class EnderecoTest {

	private Endereco endereco;
	
	@Test
	public void test_construtor() {
		endereco = new Endereco(1L, "Minha Rua", "10", "22222-222", "Meu Bairo", "Rio de janeiro", "RJ");
		
		assertNotNull(endereco);
		assertEquals(endereco.getId(), new Long(1L));
		assertEquals(endereco.getLogradouro(), "Minha Rua");
		assertEquals(endereco.getNumero(), "10");
		assertEquals(endereco.getCep(), "22222-222");
		assertEquals(endereco.getBairro(),"Meu Bairo");
		assertEquals(endereco.getCidade(),"Rio de janeiro");
		assertEquals(endereco.getUf(),"RJ");
	}
	
	@Test
	public void test_construtor_vazio() {
		endereco = new Endereco();
		
		assertNotNull(endereco);
		assertNull(endereco.getId());
		assertNull(endereco.getLogradouro());
		assertNull(endereco.getNumero());
		assertNull(endereco.getCep());
		assertNull(endereco.getBairro());
		assertNull(endereco.getCidade());
		assertNull(endereco.getUf());
	}
}
