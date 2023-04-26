package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o id para encontrar o nome e problema: ");
        Long id = sc.nextLong();

        Faq faq = FaqService.getFaqById(id);

        System.out.println("Nome do funcionário: "+ faq.getName());
        System.out.println("Descrição do problema: "+ faq.getDescription());

        sc.close();
    }
}