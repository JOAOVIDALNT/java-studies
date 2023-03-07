package com.example.intro_spring.models;

public class Calculator {

    public Calculator() {
    }

    public Double sum(String numberOne, String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    public Double mul(String numberOne, String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }

        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    public Double div(String numberOne, String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }

        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    public Double avg(String numberOne, String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }

        return convertToDouble(numberOne) + convertToDouble(numberTwo) / 2;
    }

    public Double sqrt(String number) throws Exception {
        if (!isNumeric(number)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }

        return Math.sqrt(convertToDouble(number));
    }


    private boolean isNumeric(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",",".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    private Double convertToDouble(String strNumber) {
        if(strNumber == null) return 0D;
        String number = strNumber.replaceAll(",",".");
        // PARA QUE FUNCIONE TANTO 10,50 QUANTO 10.50
        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }
}
