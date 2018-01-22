package br.com.msf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.msf.exception.CalculoTaxaAgendamentoException;
import br.com.msf.model.Agendamento;
import br.com.msf.repository.AgendamentoRepository;
import br.com.msf.service.AgendamentoService;
import br.com.msf.util.CalculoTaxaAgendamento;

/**
 * Implementacao do servico de Agendamento
 * 
 * @author Márcio Simon
 */
@Service
public class AgendamentoServiceImpl implements AgendamentoService {

	@Autowired
	AgendamentoRepository agendamentoRepository;

	@Override
	public Agendamento pesquisaPorId(Long id) {
		return agendamentoRepository.findOne(id);
	}

	@Override
	public List<Agendamento> listar() {
		return agendamentoRepository.findAll();
	}

	@Override
	public void salvar(Agendamento agendamento) throws CalculoTaxaAgendamentoException {
		// calculo taxa transferencia
		float taxaTransferencia = CalculoTaxaAgendamento.calcularTaxaTransferencia(agendamento.getDataAgendamento(), agendamento.getDataTransferencia(), agendamento.getValor());
		agendamento.setTaxa(taxaTransferencia);
		
		agendamentoRepository.save(agendamento);
	}

	@Override
	public void deletar(Agendamento agendamento) {
		agendamentoRepository.delete(agendamento);
	}
}