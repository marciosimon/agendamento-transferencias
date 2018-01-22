package br.com.msf.util;

import java.time.LocalDate;

import br.com.msf.exception.CalculoTaxaAgendamentoException;

public class CalculoTaxaAgendamento {

	/**
	 * Metodo que efetua calculo de taxa de agendamento.
	 * 
	 * @param dataAgendamento
	 * 	Data de agendamento
	 * @param dataTransferencia
	 * 	Data de transferencia
	 * @param valor
	 * 	Valor a ser transferido
	 * @return
	 * 	Valor da taxa
	 * @throws CalculoTaxaAgendamentoException 
	 */
	public static float calcularTaxaTransferencia(LocalDate dataAgendamento, LocalDate dataTransferencia, float valor) throws CalculoTaxaAgendamentoException {
		float valorTaxa = 0;
		
		int diasEntreDataAgendamentoEDataTransferencia = DateUtil.quantidadeDiasEntreDatas(dataAgendamento, dataTransferencia);

		if (diasEntreDataAgendamentoEDataTransferencia == 0) {
			// Transferências no mesmo dia do agendamento tem uma taxa de $3 mais 3% do valor a ser transferido
			valorTaxa = 3 + (3 * Float.parseFloat("0.03"));
		}
		else if (diasEntreDataAgendamentoEDataTransferencia > 0 && diasEntreDataAgendamentoEDataTransferencia <= 10) {
			// Transferências até 10 dias da data de agendamento possuem uma taxa de $12
			// multiplicado pela quantidade de dias da data de agendamento até a data de transferência.
			valorTaxa = (12 * diasEntreDataAgendamentoEDataTransferencia);
		}
		else if (diasEntreDataAgendamentoEDataTransferencia > 10 && diasEntreDataAgendamentoEDataTransferencia <= 20) {
			// Acima de 10 até 20 dias da data de agendamento
			valorTaxa = 8;
		}
		else if (diasEntreDataAgendamentoEDataTransferencia > 20 && diasEntreDataAgendamentoEDataTransferencia <= 30) {
			// Acima de 20 até 30 dias da data de agendamento
			valorTaxa = 6;
		}
		else if (diasEntreDataAgendamentoEDataTransferencia > 30 && diasEntreDataAgendamentoEDataTransferencia <= 40) {
			// Acima de 30 até 40 dias da data de agendamento
			valorTaxa = 4;
		}
		else if (diasEntreDataAgendamentoEDataTransferencia > 40 && valor > 100.000) {
			// Acima de 40 dias da data de agendamento e valor superior a 100.000 2%
			valorTaxa = 2;
		}
		else {
			throw new CalculoTaxaAgendamentoException();
		}

		return valorTaxa;
	}
}