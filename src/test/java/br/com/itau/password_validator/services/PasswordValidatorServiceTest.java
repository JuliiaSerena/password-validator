package br.com.itau.password_validator.services;

import br.com.itau.password_validator.model.ResultadoValidacao;
import br.com.itau.password_validator.services.validators.SenhaValidator;
import br.com.itau.password_validator.services.validators.Validacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PasswordValidatorServiceTest {
    private PasswordValidatorService service;

    @Mock
    private SenhaValidator validator1;

    @Mock
    private SenhaValidator validator2;

    @BeforeEach
    void setUp() {
        service = new PasswordValidatorService(List.of(validator1, validator2));
    }

    @Test
    void deveRetornarValidoQuandoTodosValidatorsPassarem() {
        String senha = "SenhaValida123!";

        when(validator1.isValid(senha)).thenReturn(true);
        when(validator2.isValid(senha)).thenReturn(true);

        ResultadoValidacao resultado = service.isValid(senha);

        assertTrue(resultado.getIsValid());
        assertTrue(resultado.getErrors().isEmpty());

        verify(validator1).isValid(senha);
        verify(validator2).isValid(senha);
    }

    @Test
    void deveRetornarInvalidoQuandoUmValidatorFalhar() {
        String senha = "senha";

        when(validator1.isValid(senha)).thenReturn(true);

        when(validator2.isValid(senha)).thenReturn(false);
        when(validator2.getTipoValidacao()).thenReturn(Validacao.TAMANHO);

        ResultadoValidacao resultado = service.isValid(senha);

        assertFalse(resultado.getIsValid());
        assertEquals(1, resultado.getErrors().size());
        String primeiraMensagemErro = resultado.getErrors().get(0);

        assertEquals(
                Validacao.TAMANHO.getMensagemErro(),
                primeiraMensagemErro
        );

        verify(validator2).getTipoValidacao();
    }

    @Test
    void deveRetornarMultiplosErrosQuandoMaisDeUmValidatorFalhar() {
        String senha = "123";

        when(validator1.isValid(senha)).thenReturn(false);
        when(validator1.getTipoValidacao()).thenReturn(Validacao.TAMANHO);

        when(validator2.isValid(senha)).thenReturn(false);
        when(validator2.getTipoValidacao()).thenReturn(Validacao.PELO_MENOS_UM_CARACTER_MAISCULO);

        ResultadoValidacao resultado = service.isValid(senha);

        assertFalse(resultado.getIsValid());
        assertEquals(2, resultado.getErrors().size());
    }
}
