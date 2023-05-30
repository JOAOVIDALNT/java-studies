package com.example.appchamadosjava.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String email) {
        super(String.format("Usuário com o email: '%s' não encontrado", email));
    }
}
