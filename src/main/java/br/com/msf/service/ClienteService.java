package br.com.msf.service;

import java.util.List;

import br.com.msf.model.Cliente;

/**
 * Servico de Cliente
 * 
 * @author Márcio Simon
 */
public interface ClienteService {

	public Cliente pesquisaPorId(Long id);

	public List<Cliente> listar();

	public void salvar(Cliente cliente);
	
	public void deletar(Cliente cliente);	
	
}

