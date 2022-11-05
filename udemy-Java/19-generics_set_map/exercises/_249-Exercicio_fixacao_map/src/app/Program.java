package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Program {

    public static void main(String[] args) {

        Map<String, Integer> votes = new LinkedHashMap<>();

        String path = "C:\\projects\\java\\java-studies\\udemy-Java\\19-generics_set_map\\exercises\\_249-Exercicio_fixacao_map\\votes.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();

            while(line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                Integer voteCount = Integer.parseInt(fields[1]);

                if (votes.containsKey(name)) {
                    int votesSoFar = votes.get(name);
                    votes.put(name, voteCount + votesSoFar);
                } else {
                    votes.put(name, voteCount);
                }

                line = br.readLine();
            }
            for (String key : votes.keySet()) {
                System.out.println(key + ": " + votes.get(key));
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
