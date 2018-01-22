package br.com.msf.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Classe utilitaria para calculo de datas
 * 
 * @author Márcio Simon
 */
public class DateUtil {

	/**
	 * Calculo intervalo de dias entre duas datas
	 * @param dataInicial
	 * 	Data inicial
	 * @param dataFinal
	 * 	Data final
	 * @return
	 * 	Quantidade dias
	 */
	public static long quantidadeDiasEntreDatas(LocalDate dataInicial, LocalDate dataFinal) {
        return ChronoUnit.DAYS.between(dataInicial, dataFinal);
	}
	
	public static void main(String[] args) {
		LocalDate dataInicial = LocalDate.of(2018, 12, 21);
		LocalDate dataFinal = LocalDate.of(2020, 01, 20);
		long quantidadeDiasEntreDatas = DateUtil.quantidadeDiasEntreDatas(dataInicial, dataFinal);
		System.out.println("quantidadeDiasEntreDatas: " + quantidadeDiasEntreDatas);
	}
	
}
