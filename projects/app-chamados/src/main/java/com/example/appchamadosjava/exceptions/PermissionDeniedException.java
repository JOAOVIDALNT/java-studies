package com.example.appchamadosjava.exceptions;

public class PermissionDeniedException extends RuntimeException {
    public PermissionDeniedException(String ex) {
        super(ex);
    }
}
