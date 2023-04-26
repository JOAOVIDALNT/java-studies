package org.example;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CepService {
    static String webService = "http://viacep.com.br/ws/";
    static int successCode = 200;

    public static Address searchAddressBy(String cep) throws Exception {
        String callUrl = webService + cep + "/json";

        try {
            URL url = new URL(callUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            if(connection.getResponseCode() != successCode) {
                throw new RuntimeException("Error: " + connection.getResponseCode());
            }


            BufferedReader response = new BufferedReader(new InputStreamReader((connection.getInputStream())));
            String jsonToString = Util.jsonToStringConvert(response);

            Gson gson = new Gson(); // lib do google: atribui o nome de um atributo da classe automaticamente à um atríbuto do json de mesmo nome (precisa ser idêntico)
            Address address = gson.fromJson(jsonToString, Address.class);

            return address;
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }
}
