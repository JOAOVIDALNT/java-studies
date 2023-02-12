package app;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        String[] lines = new String[] {"salve", "suave?", "tranks"};
        String path = "c:\\projects\\java\\java-studies\\udemy-Java\\17-trabalhando_com_arquivos\\writer.txt";

//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) { // não recria o arquivos, apenas adiciona
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
