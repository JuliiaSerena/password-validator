package br.com.itau.password_validator.services.validators.impl;

import br.com.itau.password_validator.services.validators.SenhaValidator;
import br.com.itau.password_validator.services.validators.Validacao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PeloMenosUmDigitoValidator implements SenhaValidator {

    private final String HAS_AT_LEAST_ONE_DIGIT = ".*[0-9].*";

    @Override
    public Boolean isValid(String senha) {
        log.info("Validando pelo menos um digito numerico!");
        return senha.matches(HAS_AT_LEAST_ONE_DIGIT);
    }

    @Override
    public Validacao getTipoValidacao() {
        return Validacao.PELO_MENOS_UM_NUMERO;
    }
}
