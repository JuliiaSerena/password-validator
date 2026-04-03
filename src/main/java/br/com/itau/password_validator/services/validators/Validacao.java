package br.com.itau.password_validator.services.validators;

import lombok.Getter;

@Getter
public enum Validacao {
    PELO_MENOS_UM_CARACTER_MINUSCULO("Senha deve conter pelo menos um caracter minusculo"),
    PELO_MENOS_UM_CARACTER_MAISCULO("Senha deve conter pelo menos um caracter maisculo"),
    PELO_MENOS_UM_NUMERO("Senha deve conter pelo menos um número"),
    PELO_MENOS_UM_CARACTER_ESPECIAL("Senha deve conter pelo menos um dos caracteres especiais: !@#$%^&*()-+"),
    CARACTER_REPETIDO("Senha não deve conter caracteres repetidos"),
    TAMANHO("Senha não pode ser vazia ou menor que 9 caracteres");

    Validacao(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }

    String mensagemErro;
}
