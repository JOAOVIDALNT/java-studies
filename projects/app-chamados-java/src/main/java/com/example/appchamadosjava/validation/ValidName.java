package com.example.appchamadosjava.validation;

import com.example.appchamadosjava.exceptions.ticketExeptions.InvalidNameException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidName {

    public void nameValidation(String name) {
        String regex = "^[[ ]|\\p{L}*]+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(name);
        boolean matchFound = m.find();
        if(!matchFound) {
            throw new InvalidNameException();
        }
    }
}
