package br.com.itau.password_validator.validators;

import br.com.itau.password_validator.services.validators.Validacao;
import br.com.itau.password_validator.services.validators.impl.PeloMenosUmCaracterMaiusculoValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

public class PeloMenosUmCaracterMaiusculoValidatorTest {
    @InjectMocks
    private PeloMenosUmCaracterMaiusculoValidator validator;

    @Test
    void deveRetornarTrueQuandoSenhaContemMaiuscula() {
        String senha = "senhaTeste123";

        Boolean resultado = validator.isValid(senha);

        assertTrue(resultado);
    }

    @Test
    void deveRetornarFalseQuandoSenhaNaoContemMaiuscula() {
        String senha = "senhateste123";

        Boolean resultado = validator.isValid(senha);

        assertFalse(resultado);
    }

    @Test
    void deveRetornarTrueParaDiferentesPosicoesDeMaiuscula() {
        assertTrue(validator.isValid("Teste123"));   // início
        assertTrue(validator.isValid("teste123A"));  // final
        assertTrue(validator.isValid("tesTe123"));   // meio
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
                Validacao.PELO_MENOS_UM_CARACTER_MAISCULO,
                validator.getTipoValidacao()
        );
    }
}
