package br.com.itau.password_validator.validators;


import br.com.itau.password_validator.services.validators.impl.PeloMenosUmCaracterEspecialValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PeloMenosUmCaracterEspecialValidatorTest {

    @InjectMocks
    private PeloMenosUmCaracterEspecialValidator validator;

    @Test
    void deveRetornarTrueQuandoSenhaContemCaracterEspecial() {
        String senha = "Senha123!";

        Boolean resultado = validator.isValid(senha);

        assertTrue(resultado);
    }

    @Test
    void deveRetornarFalseQuandoSenhaNaoContemCaracterEspecial() {
        String senha = "Senha123";

        Boolean resultado = validator.isValid(senha);

        assertFalse(resultado);
    }

    @Test
    void deveRetornarTrueParaDiferentesCaracteresEspeciais() {
        assertTrue(validator.isValid("Teste@123"));
        assertTrue(validator.isValid("Teste#123"));
        assertTrue(validator.isValid("Teste$123"));
        assertTrue(validator.isValid("Teste%123"));
        assertTrue(validator.isValid("Teste&123"));
        assertTrue(validator.isValid("Teste*123"));
        assertTrue(validator.isValid("Teste-123"));
        assertTrue(validator.isValid("Teste+123"));
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
                br.com.itau.password_validator.services.validators.Validacao.PELO_MENOS_UM_CARACTER_ESPECIAL,
                validator.getTipoValidacao()
        );
    }
}
