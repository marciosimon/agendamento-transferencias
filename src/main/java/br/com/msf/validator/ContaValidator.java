package br.com.msf.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.msf.model.Conta;

@Component
public class ContaValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Conta.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numero", "field.required.conta.numero");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cliente", "field.required.conta.cliente");
	}
}
