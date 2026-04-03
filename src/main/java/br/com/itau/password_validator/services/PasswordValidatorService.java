package br.com.itau.password_validator.services;

import br.com.itau.password_validator.model.ResultadoValidacao;
import br.com.itau.password_validator.services.validators.SenhaValidator;
import br.com.itau.password_validator.services.validators.Validacao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PasswordValidatorService {

    private List<SenhaValidator> validatorList;

    public PasswordValidatorService(List<SenhaValidator> validatorList) {
        this.validatorList = validatorList;
    }

    public ResultadoValidacao isValid(String password) {
        log.info("Validando se possui caracteres repetidos");
        ArrayList<String> errors = new ArrayList<>();

        for (SenhaValidator senhaValidator : validatorList) {
            Boolean resultado = senhaValidator.isValid(password);
            if (resultado == false) {
                Validacao tipoValidacao = senhaValidator.getTipoValidacao();
                errors.add(tipoValidacao.getMensagemErro());
            }
        }

        if (!errors.isEmpty()) {
            log.warn("Senha inválida!");
            return new ResultadoValidacao(false, errors);
        }

        log.warn("Senha válida!");
        return new ResultadoValidacao(true, new ArrayList<>(0));
    }
}
