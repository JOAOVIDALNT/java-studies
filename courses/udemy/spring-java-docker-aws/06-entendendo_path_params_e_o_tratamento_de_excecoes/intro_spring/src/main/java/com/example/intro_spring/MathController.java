package com.example.intro_spring;

import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedOperationException("Please set a numeric value!");
        }

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
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
