package com.gerenciador.rh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.rh.domain.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
 
}
