package br.com.itau.password_validator.services.validators.impl;

import br.com.itau.password_validator.services.validators.SenhaValidator;
import br.com.itau.password_validator.services.validators.Validacao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PeloMenosUmCaracterEspecialValidator implements SenhaValidator {

    private final String SPECIAL_CHARACTERS_ALLOWED = ".*[!@#$%^&*()\\-\\+].*";

    @Override
    public Boolean isValid(String senha) {
        log.info("Validando se possui pelo menos um caracter especial!");
        return senha.matches(SPECIAL_CHARACTERS_ALLOWED);
    }

    @Override
    public Validacao getTipoValidacao() {
        return Validacao.PELO_MENOS_UM_CARACTER_ESPECIAL;
    }
}
