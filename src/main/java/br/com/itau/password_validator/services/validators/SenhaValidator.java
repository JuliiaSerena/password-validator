package br.com.itau.password_validator.services.validators;

public interface SenhaValidator {
    Boolean isValid(String senha);
    Validacao getTipoValidacao();
}
