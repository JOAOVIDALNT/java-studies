public class Main {
    
    public static void main(String[] args) {
        

        // Expressão condicional ternária é um alternativa para if-else que exibe uma condição básica true/false
        // EXEMPLO
        // (condição) ? valor_if_true : valor_if_falso

        // ( 2 > 4 ) ? 50 : 80; --> 80 pois a condição é falsa
        
        // MÉTODO LONGO COM IF-ELSE
        // double price = 34.5;
        // double desconto;
        // if (price < 20) {
        //     desconto = price * 0.1;
        // }
        // else {
        //     desconto = price * 0.05
        // }

        // MÉTODO CURTO COM EXPRESSÃO CONDICIONAL TERNÁRIA
        double price = 34.5;
        double desconto = (price < 20) ? price * 0.1 : price * 0.05;


    }


}
