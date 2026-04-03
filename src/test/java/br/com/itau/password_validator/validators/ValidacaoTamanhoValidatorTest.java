package br.com.itau.password_validator.validators;

import br.com.itau.password_validator.services.validators.Validacao;
import br.com.itau.password_validator.services.validators.impl.ValidacaoTamanhoValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ValidacaoTamanhoValidatorTest {

    @InjectMocks
    private ValidacaoTamanhoValidator validator;

    @Test
    void deveRetornarTrueQuandoSenhaTemTamanhoMinimo() {
        String senha = "123456789"; // 9 caracteres

        Boolean resultado = validator.isValid(senha);

        assertTrue(resultado);
    }

    @Test
    void deveRetornarTrueQuandoSenhaTemMaisQueOTamanhoMinimo() {
        String senha = "12345678910";

        Boolean resultado = validator.isValid(senha);

        assertTrue(resultado);
    }

    @Test
    void deveRetornarFalseQuandoSenhaTemMenosQueOTamanhoMinimo() {
        String senha = "12345678"; // 8 caracteres

        Boolean resultado = validator.isValid(senha);

        assertFalse(resultado);
    }

    @Test
    void deveRetornarFalseQuandoSenhaForVazia() {
        String senha = "";

        Boolean resultado = validator.isValid(senha);

        assertFalse(resultado);
    }

    @Test
    void deveRetornarFalseQuandoSenhaForNull() {
        String senha = null;

        Boolean resultado = validator.isValid(senha);

        assertFalse(resultado);
    }

    @Test
    void deveRetornarTipoValidacaoCorreto() {
        assertEquals(
                Validacao.TAMANHO,
                validator.getTipoValidacao()
        );
    }
}
