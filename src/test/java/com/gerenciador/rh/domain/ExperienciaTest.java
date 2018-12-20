package com.gerenciador.rh.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;

public class ExperienciaTest {

	private Experiencia experiencia;
	
	@Test
	public void test_construtor() {
		experiencia = new Experiencia(1L,"Empresa",true,Calendar.getInstance().getTime(),
				Calendar.getInstance().getTime(),"descricao",3.000,"Analista");
		
		assertNotNull(experiencia);
		assertEquals(experiencia.getId(),new Long(1));
		assertTrue(experiencia.getAtual());
		assertEquals(experiencia.getCargo(),"Analista");
		assertEquals(experiencia.getEmpresa(),"Empresa");
//		assertEquals(experiencia.getInicio());//FIXME
//		assertEquals(experiencia.getFim());
		assertEquals(experiencia.getSalario(),new Double(3.000));
		assertEquals(experiencia.getDescricao(),"descricao");
	}
	
	@Test
	public void test_construtor_vazio() {
		experiencia = new Experiencia();
		
		assertNotNull(experiencia);
		assertNull(experiencia.getId());
		assertFalse(experiencia.getAtual());
		assertNull(experiencia.getCargo());
		assertNull(experiencia.getEmpresa());
		assertNull(experiencia.getInicio());
		assertNull(experiencia.getFim());
		assertNull(experiencia.getSalario());
		assertNull(experiencia.getCandidato());
		assertNull(experiencia.getDescricao());
	}
}
