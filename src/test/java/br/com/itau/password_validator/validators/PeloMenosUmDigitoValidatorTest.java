package br.com.itau.password_validator.validators;

import br.com.itau.password_validator.services.validators.Validacao;
import br.com.itau.password_validator.services.validators.impl.PeloMenosUmDigitoValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PeloMenosUmDigitoValidatorTest {
    @InjectMocks
    private PeloMenosUmDigitoValidator validator;

    @Test
    void deveRetornarTrueQuandoSenhaContemDigito() {
        String senha = "SenhaTeste1";

        Boolean resultado = validator.isValid(senha);

        assertTrue(resultado);
    }

    @Test
    void deveRetornarFalseQuandoSenhaNaoContemDigito() {
        String senha = "SenhaTeste";

        Boolean resultado = validator.isValid(senha);

        assertFalse(resultado);
    }

    @Test
    void deveRetornarTrueParaDiferentesPosicoesDeDigito() {
        assertTrue(validator.isValid("1SenhaTeste"));
        assertTrue(validator.isValid("SenhaTeste1"));
        assertTrue(validator.isValid("Senha1Teste"));
    }

    @Test
    void deveRetornarFalseParaSenhaVazia() {
        String senha = "";

        Boolean resultado = validator.isValid(senha);

        assertFalse(resultado);
    }

    @Test
    void deveRetornarTipoValidacaoCorreto() {
        assertEquals(
                Validacao.PELO_MENOS_UM_NUMERO,
                validator.getTipoValidacao()
        );
    }
}
