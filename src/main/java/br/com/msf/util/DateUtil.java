package br.com.msf.util;

import java.time.LocalDate;
import java.time.Period;

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
	public static int quantidadeDiasEntreDatas(LocalDate dataInicial, LocalDate dataFinal) {
		Period period = Period.between(dataInicial, dataFinal);
		return period.getDays();
	}
	
}
