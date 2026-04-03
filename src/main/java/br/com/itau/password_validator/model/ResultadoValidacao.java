package br.com.itau.password_validator.model;

import lombok.Getter;

import java.util.List;

@Getter
public class ResultadoValidacao {
    private Boolean isValid;
    private List<String> errors;

    public ResultadoValidacao(Boolean isValid, List<String> errors) {
        this.isValid = isValid;
        this.errors = errors;
    }
}
