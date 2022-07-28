package application;

import entities.Grade;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Grade gr = new Grade();


        System.out.print("Nome: ");
        gr.name = sc.nextLine();

        System.out.print("Primeiro semestre: ");
        gr.primeiro = sc.nextDouble();

        System.out.print("Segundo semestre: ");
        gr.segundo = sc.nextDouble();

        System.out.print("Terceiro semestre: ");
        gr.terceiro = sc.nextDouble();


        System.out.println("FINAL GRADE: " + gr.finalGrade());


        if (gr.finalGrade() < 60.0) {
//            System.out.println("FINAL GRADE: " + gr.finalGrade());
            System.out.println("FAILED");
            System.out.println("MISSING POINTS: " + gr.missPoints());
        } else {
//            System.out.println("FINAL GRADE: " + gr.finalGrade());
            System.out.println("PASS");
        }



        sc.close();
    }
}
