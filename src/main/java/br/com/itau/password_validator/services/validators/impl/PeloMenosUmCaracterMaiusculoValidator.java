package br.com.itau.password_validator.services.validators.impl;

import br.com.itau.password_validator.services.validators.SenhaValidator;
import br.com.itau.password_validator.services.validators.Validacao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PeloMenosUmCaracterMaiusculoValidator implements SenhaValidator {

    private final String HAS_AT_LEAST_ONE_CHARACTER_UPPERCASE = ".*[A-Z].*";

    @Override
    public Boolean isValid(String senha) {
        log.info("Validando pelo menos um caracter maisculo!");
        return senha.matches(HAS_AT_LEAST_ONE_CHARACTER_UPPERCASE);
    }

    @Override
    public Validacao getTipoValidacao() {
        return Validacao.PELO_MENOS_UM_CARACTER_MAISCULO;
    }
}
