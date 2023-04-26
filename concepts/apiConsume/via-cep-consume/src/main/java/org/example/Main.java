package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.print("Digite o seu CEP: ");
        String cep = new Scanner(System.in).nextLine();

        Address address = CepService.searchAddressBy(cep);

        System.out.println("Logradouro: " + address.getLogradouro());
        System.out.println("Bairro: " + address.getBairro());
        System.out.println("Localidade: " + address.getLocalidade());
    }
}