package com.example.appchamadosjava.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidName {

    public boolean nameValidation(String name) {
        String regex = "^[[ ]|\\p{L}*]+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(name);
        boolean matchFound = m.find();
        if(!matchFound) {
            return false;
        } else {
            return true;
        }
    }
}
