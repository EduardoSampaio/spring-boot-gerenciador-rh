package com.gerenciador.rh.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class TelefoneTest {

	private Telefone telefone;
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void test_construtor() {
		telefone = new Telefone(null, "3333-3333", "9999-8888", "5555-5555");
		
		assertNull(telefone.getId());
		assertEquals(telefone.getCelular(), "9999-8888");
		assertEquals(telefone.getResidencial(), "3333-3333");
		assertEquals(telefone.getProfissional(), "5555-5555");
	}
	
	@Test
	public void test_equals_mesma_instancia() {
		telefone = new Telefone(-1L, "3333-3333", "9999-8888", "5555-5555");
		
		Telefone telefone2 = telefone;
		assertEquals(telefone, telefone2);
	}
	
	@Test
	public void test_equals_diferente_instancia() {
		telefone = new Telefone(-1L, "3333-3333", "9999-8888", "5555-5555");
		
		Telefone telefone2 = new Telefone(-1L, "3333-3333", "9999-8888", "5555-5555");
		assertEquals(telefone, telefone2);
	}
	
	@Test
	public void test_equals_id_diferente() {
		telefone = new Telefone(-1L, "3333-3333", "9999-8888", "5555-5555");
		
		Telefone telefone2 = new Telefone(-2L, "3333-3333", "9999-8888", "5555-5555");
		assertNotEquals(telefone, telefone2);
	}
}
