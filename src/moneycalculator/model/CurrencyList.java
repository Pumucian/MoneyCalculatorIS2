
package moneycalculator.model;

import java.util.HashMap;
import java.util.Map;

public class CurrencyList {
    private final Map<String, Currency> currencies = new HashMap<>();

    public CurrencyList() {
        add(new Currency("USD","Dolar americano","$"));
        add(new Currency("EUR","Euro","€"));
        add(new Currency("GBP","Libra Esterlina","£"));
        add(new Currency("INR","Rupia India","₹"));
        add(new Currency("AUD","Dolar Australiano","$"));
        add(new Currency("CAD","Dolar Canadiense","$"));
        add(new Currency("SGD","Dolar Singapurense","$"));
        add(new Currency("JPY","Yen Japonés","¥"));
        add(new Currency("CNY","Yuan Renminbi Chino","元"));        
    }

    private void add(Currency currency) {
        currencies.put(currency.getCode(), currency);
    }
    
    public Currency get(String code) {
        return currencies.get(code.toUpperCase());
    }
}