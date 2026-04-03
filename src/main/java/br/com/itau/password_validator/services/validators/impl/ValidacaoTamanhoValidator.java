package br.com.itau.password_validator.services.validators.impl;

import br.com.itau.password_validator.services.validators.SenhaValidator;
import br.com.itau.password_validator.services.validators.Validacao;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ValidacaoTamanhoValidator implements SenhaValidator {

    private static final int MINIMUM_LENGTH_ALLOWED = 9;

    @Override
    public Boolean isValid(String senha) {
        log.info("Validando tamanho minimo e máximo da senha!");
        return !StringUtils.isEmpty(senha) && senha.length() >= MINIMUM_LENGTH_ALLOWED;
    }

    @Override
    public Validacao getTipoValidacao() {
        return Validacao.TAMANHO;
    }
}
