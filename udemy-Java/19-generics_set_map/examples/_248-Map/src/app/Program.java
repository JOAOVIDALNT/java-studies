package app;

import java.util.Map;
import java.util.TreeMap;

public class Program {
    public static void main(String[] args) {

        Map<String, String> cookies = new TreeMap<>();

        cookies.put("username","Maria");
        cookies.put("email","Maria@gmail.com");
        cookies.put("phone","969696969");

        cookies.remove("email");
        cookies.put("phone", "977777777"); // não aceita repetição, então sobrepõe

        System.out.println("Contains 'phone' key: " + cookies.containsKey("phone")); // true
        System.out.println("Phone number: " + cookies.get("phone")); // exibe o valor de phone
        System.out.println("Email: " + cookies.get("email")); // retorna null pois o elemento não existe
        System.out.println("Size: " + cookies.size());

        System.out.println("COOKIES");
        for (String key : cookies.keySet()) {
            System.out.println(key + ": " + cookies.get(key));
        }


    }
}
