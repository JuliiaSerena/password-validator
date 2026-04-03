package br.com.itau.password_validator.controllers;

import br.com.itau.password_validator.model.Password;
import br.com.itau.password_validator.model.ResultadoValidacao;
import br.com.itau.password_validator.services.PasswordValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/password")
public class PasswordController {

    @Autowired private PasswordValidatorService service;

    @PostMapping("/validate")
    public ResponseEntity<ResultadoValidacao> validate(@RequestBody Password password) {
        return ResponseEntity.ok(service.isValid(password.password()));
    }
}
