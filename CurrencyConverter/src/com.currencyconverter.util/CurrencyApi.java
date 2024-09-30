package com.currencyconverter.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class CurrencyApi {

    private static final String API_KEY = "YOUR_API_KEY"; // Replace with your API key
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

    public static double getExchangeRate(String fromCurrency, String toCurrency) {
        double exchangeRate = 0.0;

        try {
            String urlStr = API_URL + fromCurrency + "/" + toCurrency;
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            // Check if the connection is successful
            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                String output;
                StringBuilder content = new StringBuilder();

                while ((output = in.readLine()) != null) {
                    content.append(output);
                }
                in.close();

                JSONObject json = new JSONObject(content.toString());
                exchangeRate = json.getDouble("conversion_rate");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return exchangeRate;
    }
}
