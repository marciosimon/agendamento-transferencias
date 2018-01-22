package br.com.msf.exception;

public class CalculoTaxaAgendamentoException extends Exception {

	private static final long serialVersionUID = -1882585965083645174L;

	public CalculoTaxaAgendamentoException() {
		super("Não há nenhuma taxa baseada nos parâmetros informados.");
	}

}
