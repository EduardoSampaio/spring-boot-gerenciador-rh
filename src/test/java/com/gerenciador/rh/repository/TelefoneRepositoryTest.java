package com.gerenciador.rh.repository;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.gerenciador.rh.domain.Telefone;
import com.gerenciador.rh.repositories.TelefoneRepository;

public class TelefoneRepositoryTest {

	private TelefoneRepository repository;
	
	@Before
	public void setup() {
		repository = Mockito.mock(TelefoneRepository.class);
	}
	
	@Test
	public void test_salvar() {
		Telefone telefone = new Telefone(1L, "3333-3333", "4444-4444", "9999-9999");
		

//		repository.save(telefone);
//		
//		
//		verify(telefone);//FIXME
		
	}
}
