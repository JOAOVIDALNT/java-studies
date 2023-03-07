package com.example.intro_spring.controllers;

import com.example.intro_spring.models.Calculator;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

    Calculator calc = new Calculator();
    @GetMapping("/sum/{n1}/{n2}")
    public Double sum(@PathVariable("n1") String numberOne,
                      @PathVariable("n2") String numberTwo) throws Exception{
        return calc.sum(numberOne, numberTwo);
    }

    @GetMapping("/mul/{n1}/{n2}")
    public Double mul(@PathVariable("n1") String numberOne,
                      @PathVariable("n2") String numberTwo) throws Exception {
        return calc.mul(numberOne, numberTwo);
    }

    @GetMapping("/div/{n1}/{n2}")
    public Double div(@PathVariable("n1") String numberOne,
                      @PathVariable("n2") String numberTwo) throws Exception {
        return calc.div(numberOne, numberTwo);
    }

    @GetMapping("/avg/{n1}/{n2}")
    public Double avg(@PathVariable("n1") String numberOne,
                      @PathVariable("n2") String numberTwo) throws Exception {
        return calc.avg(numberOne, numberTwo);
    }

    @GetMapping("/sqrt/{n1}")
    public Double sqrt(@PathVariable("n1") String number) throws Exception{
        return calc.sqrt(number);
    }




}
