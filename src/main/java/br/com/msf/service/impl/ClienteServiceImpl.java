package br.com.msf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.msf.model.Cliente;
import br.com.msf.repository.ClienteRepository;
import br.com.msf.service.ClienteService;

/**
 * Implementacao do servico de Cliente
 * 
 * @author Márcio Simon
 */
@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public Cliente pesquisaPorId(Long id) {
		return clienteRepository.findOne(id);
	}

	@Override
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	@Override
	public void salvar(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	@Override
	public void deletar(Cliente cliente) {
		clienteRepository.delete(cliente);
	}
}