package com.example.appchamadosjava.exceptions;

import com.example.appchamadosjava.exceptions.ticketExeptions.InvalidNameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@ControllerAdvice(basePackages = "com.example.appchamadosjava.controllers")
public class CustomControllerAdvice {


    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageExceptionHandler> argumentsNotValid(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        StringBuilder sb = new StringBuilder("Os campos seguintes não podem ser nulos: ");
        for(FieldError fieldError : fieldErrors) {
            sb.append(" | ");
            sb.append(fieldError.getField());
        }

        MessageExceptionHandler error = new MessageExceptionHandler(
                new Date(), HttpStatus.BAD_REQUEST.value(), sb.toString());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }




    @ResponseBody
    @ExceptionHandler(InvalidNameException.class)
    public ResponseEntity<MessageExceptionHandler> invalidName(InvalidNameException invalidNameException) {
        MessageExceptionHandler error = new MessageExceptionHandler(
                new Date(), HttpStatus.BAD_REQUEST.value(), "Nome inválido");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
