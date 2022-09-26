package services;

import java.security.InvalidParameterException;

public class UsaInterestService implements InterestService {

    private double interestRate;

    public UsaInterestService(double interestRate) {
        this.interestRate = interestRate;
    } // interface não pode ter construtor

    @Override
    public double getInterestRate() { // não pode ser padrão pois o método depende do valor da variavel e a interface não pode armazenar estado
        return interestRate;
    }
}
