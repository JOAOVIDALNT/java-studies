package com.example.appchamadosjava.exceptions.handler2;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;
import java.util.List;

//@ControllerAdvice(basePackages = "com.example.appchamadosjava.controllers")
public class TicketControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TicketNotFoundException2.class)
    public ErrorDTO handleTicketNotFound(TicketNotFoundException2 ticketNotFoundException) {
        ErrorDTO errorDTO = new ErrorDTO();

        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        errorDTO.setMessage("Chamado não encontrado");
        errorDTO.setTimestamp(new Date());

        return errorDTO;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDTO handleNotValidExceptions(MethodArgumentNotValidException ex) {
        ErrorDTO errorDTO = new ErrorDTO();

        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());

        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        StringBuilder sb = new StringBuilder("Valor inválido para o(s) campo(s):");
        for(FieldError fieldError : fieldErrors) {
            sb.append(" ");
            sb.append(fieldError.getField());
        }
        errorDTO.setMessage(sb.toString());

        errorDTO.setTimestamp(new Date());

        return errorDTO;
    }
}
