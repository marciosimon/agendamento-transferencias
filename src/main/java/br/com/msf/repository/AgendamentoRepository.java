package br.com.msf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.msf.model.Agendamento;

/**
 * Repositorio de Agendamento
 * 
 * @author Márcio Simon
 */
@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{

}
