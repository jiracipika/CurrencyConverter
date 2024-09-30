package com.currencyconverter.servlet;

import com.currencyconverter.util.CurrencyApi;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import org.json.JSONObject;

@WebServlet("/convert")
public class ConverterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String amountStr = request.getParameter("amount");
        String fromCurrency = request.getParameter("from");
        String toCurrency = request.getParameter("to");

        double amount = Double.parseDouble(amountStr);

        double exchangeRate = CurrencyApi.getExchangeRate(fromCurrency, toCurrency);
        double convertedAmount = amount * exchangeRate;

        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("convertedAmount", convertedAmount);
        jsonResponse.put("exchangeRate", exchangeRate);

        response.setContentType("application/json");
        response.getWriter().write(jsonResponse.toString());
    }
}
