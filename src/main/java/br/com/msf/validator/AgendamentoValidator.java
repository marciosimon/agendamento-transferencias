package br.com.msf.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.msf.model.Agendamento;

@Component
public class AgendamentoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Agendamento.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contaOrigem", "field.required.agendamento.contaOrigem");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contaDestino", "field.required.agendamento.contaDestino");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "valor", "field.required.agendamento.valor");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataTransferencia", "field.required.agendamento.dataTransferencia");
	}
}