package com.gerenciador.rh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.rh.domain.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

}
