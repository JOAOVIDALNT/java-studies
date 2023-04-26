package org.example;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FaqService {
    static String webService = "http://localhost:8080/api/v1/tickets/";

    static int successCode = 200;

    public static Faq getFaqById(Long id) throws Exception {
        String finalUrl = webService + id;

        try {
            URL url = new URL(finalUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            if(connection.getResponseCode() != successCode) {
                throw new RuntimeException("Error: " + connection.getResponseMessage());
            }

            BufferedReader response = new BufferedReader(new InputStreamReader((connection.getInputStream())));
            String jsonToString = Util.jsonToStringConvert(response);

            Gson gson = new Gson();
            Faq faq = gson.fromJson(jsonToString, Faq.class);

            return faq;
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }


}
