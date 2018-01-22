package br.com.msf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.msf.model.Conta;

/**
 * Repositorio de Conta
 * 
 * @author Márcio Simon
 */
@Repository
public interface ContaRepository  extends JpaRepository<Conta, Long>{

}
