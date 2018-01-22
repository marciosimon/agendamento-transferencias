package br.com.msf.service;

import java.util.List;

import br.com.msf.model.Conta;

/**
 * Servico de Conta
 * 
 * @author Márcio Simon
 */
public interface ContaService {

	public Conta pesquisaPorId(Long id);

	public List<Conta> listar();

	public void salvar(Conta conta);
	
	public void deletar(Conta conta);	
	
}
