package br.com.msf.service;

import java.util.List;

import br.com.msf.exception.CalculoTaxaAgendamentoException;
import br.com.msf.model.Agendamento;

/**
 * Servico de Agendamento
 * 
 * @author Márcio Simon
 */
public interface AgendamentoService {
	
	public Agendamento pesquisaPorId(Long id);

	public List<Agendamento> listar();

	public void salvar(Agendamento agendamento) throws CalculoTaxaAgendamentoException;
	
	public void deletar(Agendamento agendamento);

}