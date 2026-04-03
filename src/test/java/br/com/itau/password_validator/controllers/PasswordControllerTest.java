package br.com.itau.password_validator.controllers;

import br.com.itau.password_validator.model.Password;
import br.com.itau.password_validator.services.PasswordValidatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PasswordControllerTest {

    @Mock
    PasswordValidatorService service;

    @InjectMocks
    PasswordController controller;

    @Test
    void serviceEstaSendoChamadoCorretamente() {
        Password password = new Password("senha123");

        controller.validate(password);

        verify(service, times(1)).isValid(password.password());
    }
}
