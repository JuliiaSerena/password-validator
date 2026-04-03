package br.com.itau.password_validator.validators;

import br.com.itau.password_validator.services.validators.Validacao;
import br.com.itau.password_validator.services.validators.impl.PeloMenosUmCaracterMinusculoValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PeloMenosUmCaracterMinusculoValidatorTest {

    @InjectMocks
    private PeloMenosUmCaracterMinusculoValidator validator;

    @Test
    void deveRetornarTrueQuandoSenhaContemMinuscula() {
        String senha = "SENHA123a";

        Boolean resultado = validator.isValid(senha);

        assertTrue(resultado);
    }

    @Test
    void deveRetornarFalseQuandoSenhaNaoContemMinuscula() {
        String senha = "SENHA123";

        Boolean resultado = validator.isValid(senha);

        assertFalse(resultado);
    }

    @Test
    void deveRetornarTrueParaDiferentesPosicoesDeMinuscula() {
        assertTrue(validator.isValid("aSENHA123"));
        assertTrue(validator.isValid("SENHA123a"));
        assertTrue(validator.isValid("SENHa123"));
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
                Validacao.PELO_MENOS_UM_CARACTER_MINUSCULO,
                validator.getTipoValidacao()
        );
    }
}
