package br.com.itau.password_validator.validators;

import br.com.itau.password_validator.services.validators.Validacao;
import br.com.itau.password_validator.services.validators.impl.ValidaCaracterRepetidoValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ValidaCaracterRepetidoValidatorTest {
    @InjectMocks
    private ValidaCaracterRepetidoValidator validator;

    @Test
    void deveRetornarTrueQuandoNaoHaCaracterRepetido() {
        String senha = "Abc123!@";

        Boolean resultado = validator.isValid(senha);

        assertTrue(resultado);
    }

    @Test
    void deveRetornarFalseQuandoHaCaracterRepetido() {
        String senha = "Abc123!!";

        Boolean resultado = validator.isValid(senha);

        assertFalse(resultado);
    }

    @Test
    void deveRetornarFalseQuandoHaCaracterRepetidoLetra() {
        String senha = "Abca123!";

        Boolean resultado = validator.isValid(senha);

        assertTrue(resultado);
    }

    @Test
    void deveRetornarFalseQuandoHaCaracterRepetidoNumero() {
        String senha = "Abc1123!";

        Boolean resultado = validator.isValid(senha);

        assertFalse(resultado);
    }

    @Test
    void deveRetornarTrueParaSenhaComUmUnicoCaracter() {
        String senha = "a";

        Boolean resultado = validator.isValid(senha);

        assertTrue(resultado);
    }

    @Test
    void deveRetornarTrueParaSenhaVazia() {
        String senha = "";

        Boolean resultado = validator.isValid(senha);

        assertTrue(resultado);
    }

    @Test
    void deveRetornarTipoValidacaoCorreto() {
        assertEquals(
                Validacao.CARACTER_REPETIDO,
                validator.getTipoValidacao()
        );
    }
}
