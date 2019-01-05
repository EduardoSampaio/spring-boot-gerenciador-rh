package com.gerenciador.rh.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class VagasTest {

	private Vagas vagas;
	
	@Before
	public void setup() {
		vagas = new Vagas(1L, "teste vagas", "localidade", "descricao", 3.500);
	}
	
	@Test
	public void test_constructor(){
		assertEquals(vagas.getId(), new Long(1));
		assertEquals(vagas.getTitulo(), "teste vagas");
		assertEquals(vagas.getLocalidade(), "localidade");
		assertEquals(vagas.getDescricao(), "descricao");
		assertEquals(vagas.getSalario(),new Double(3.500));
	}
	
	@Test
	public void test_equals_mesma_instancia(){
		Vagas vagas2 = vagas;
		assertEquals(vagas, vagas2);
	}
	
	@Test
	public void test_equals_diferente_instancia(){
		Vagas vagas2 = new Vagas();
		vagas2.setId(1L);
		assertEquals(vagas, vagas2);
	}
	
	@Test
	public void test_equals_diferente_id(){
		Vagas vagas2 = new Vagas();
		vagas2.setId(2L);
		assertNotEquals(vagas, vagas2);
	}
	
}
