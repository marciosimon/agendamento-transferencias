package br.com.msf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.msf.model.Conta;
import br.com.msf.repository.ContaRepository;
import br.com.msf.service.ContaService;

/**
 * Implementacao do servico de Conta
 * 
 * @author Márcio Simon
 */
@Service
public class ContaServiceImpl implements ContaService {

	@Autowired
	ContaRepository contaRepository;

	@Override
	public Conta pesquisaPorId(Long id) {
		return contaRepository.findOne(id);
	}

	@Override
	public List<Conta> listar() {
		return contaRepository.findAll();
	}

	@Override
	public void salvar(Conta conta) {
		contaRepository.save(conta);
	}

	@Override
	public void deletar(Conta conta) {
		contaRepository.delete(conta);
	}
}
