package br.com.msf.mock;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.msf.model.Agendamento;

public class AgendamentoMock {
	
	private static Agendamento populateBasicInformation() {
		Agendamento agendamento = new Agendamento();
		agendamento.setDataAgendamento(LocalDate.now());
		agendamento.setValor(1F);
		return agendamento;
	}

	public static Agendamento receberAgendamentoMesmoDia() {
		Agendamento agendamento = populateBasicInformation();
		agendamento.setDataTransferencia(LocalDate.now());
		return agendamento;
	}
	
	public static Agendamento receberAgendamentoIntervaloEntreUmEDezDias() {
		Agendamento agendamento = populateBasicInformation();
		agendamento.setDataTransferencia(LocalDate.now().plus(5,ChronoUnit.DAYS));
		return agendamento;
	}

	public static Agendamento receberAgendamentoIntervaloEntreOnzeEVinteDias() {
		Agendamento agendamento = populateBasicInformation();
		agendamento.setDataTransferencia(LocalDate.now().plus(13,ChronoUnit.DAYS));
		return agendamento;
	}

	public static Agendamento receberAgendamentoIntervaloEntreVinteUmETrintaDias() {
		Agendamento agendamento = populateBasicInformation();
		agendamento.setDataTransferencia(LocalDate.now().plus(23,ChronoUnit.DAYS));
		return agendamento;
	}

	public static Agendamento receberAgendamentoIntervaloEntreTrintaUmEQuarenteDias() {
		Agendamento agendamento = populateBasicInformation();
		agendamento.setDataTransferencia(LocalDate.now().plus(38,ChronoUnit.DAYS));
		return agendamento;
	}

	public static Agendamento receberAgendamentoComIntervaloMaiorQuarentaEValorMaiorQueCemMil() {
		Agendamento agendamento = populateBasicInformation();
		agendamento.setDataTransferencia(LocalDate.now().plus(42,ChronoUnit.DAYS));
		agendamento.setValor(Float.parseFloat("110.000"));
		return agendamento;
	}

	public static Agendamento receberAgendamentoIntervaloNegativo() {
		Agendamento agendamento = populateBasicInformation();
		agendamento.setDataTransferencia(LocalDate.now().minus(2,ChronoUnit.DAYS));
		return agendamento;
	}

	public static Agendamento receberAgendamentoIntervaloSemTaxa() {
		Agendamento agendamento = populateBasicInformation();
		agendamento.setDataTransferencia(LocalDate.now().plus(342,ChronoUnit.DAYS));
		return agendamento;
	}
}
