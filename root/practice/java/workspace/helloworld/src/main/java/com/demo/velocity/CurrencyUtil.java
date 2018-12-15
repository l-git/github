package com.demo.velocity;

import java.util.Map;
import java.util.HashMap;

public class CurrencyUtil {
    private static Map<String, Double> rates = new HashMap<String, Double>();

    public double getCurrencyRate(String symbol){
        return rates.get(symbol);
    }
    public void setCurrencyRate(String symbol, double currencyRate){
        rates.put(symbol, currencyRate);
    }

    public double convertCurrency(String symbol, long value){
        return value * getCurrencyRate(symbol);
    }
}