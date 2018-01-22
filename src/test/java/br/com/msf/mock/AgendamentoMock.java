package br.com.msf.mock;

import java.time.LocalDate;

import br.com.msf.model.Agendamento;

public class AgendamentoMock {

	public static Agendamento receberAgendamentoMesmoDia() {
		Agendamento agendamento = new Agendamento();
		agendamento.setDataAgendamento(LocalDate.now());
		agendamento.setDataTransferencia(LocalDate.now());
		agendamento.setValor(1);
		return agendamento;
	}
}
