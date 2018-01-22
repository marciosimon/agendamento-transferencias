package br.com.msf.validator;

import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.msf.model.Cliente;

@Component
public class ClienteValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Cliente.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "field.required.cliente.nome");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cpf", "field.required.cliente.cpf");
	}
}
