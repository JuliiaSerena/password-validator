package br.com.itau.password_validator.services.validators.impl;

import br.com.itau.password_validator.services.validators.SenhaValidator;
import br.com.itau.password_validator.services.validators.Validacao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PeloMenosUmCaracterMinusculoValidator implements SenhaValidator {

    String HAS_AT_LEAST_ONE_CHARACTER_LOWERCASE = ".*[a-z].*";

    @Override
    public Boolean isValid(String senha) {
        log.info("Validando pelo menos um caracter minusculo!");
        return senha.matches(HAS_AT_LEAST_ONE_CHARACTER_LOWERCASE);
    }

    @Override
    public Validacao getTipoValidacao() {
        return Validacao.PELO_MENOS_UM_CARACTER_MINUSCULO;
    }
}
