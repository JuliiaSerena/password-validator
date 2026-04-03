package br.com.itau.password_validator.services.validators.impl;

import br.com.itau.password_validator.services.validators.SenhaValidator;
import br.com.itau.password_validator.services.validators.Validacao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Slf4j
@Component
public class ValidaCaracterRepetidoValidator implements SenhaValidator {

    @Override
    public Boolean isValid(String senha) {
        log.info("Validando caracter repetido!");

        char[] characters = senha.toCharArray();
        HashSet<Character> usedCharacters = new HashSet<>();

        for (char character : characters) {
            if (!usedCharacters.contains(character)) {
                usedCharacters.add(character);
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public Validacao getTipoValidacao() {
        return Validacao.CARACTER_REPETIDO;
    }
}
