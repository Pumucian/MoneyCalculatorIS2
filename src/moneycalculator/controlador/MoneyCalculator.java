
package moneycalculator.controlador;
import moneycalculator.model.ExchangeRate;
import moneycalculator.model.Currency;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import moneycalculator.vista.MainFrame;


public class MoneyCalculator {
    public static void main(String[] args) throws Exception {
      MoneyCalculator moneyCalculator = new MoneyCalculator();
      MainFrame a = new MainFrame();
      a.setVisible(true);
    }



    public MoneyCalculator() {
        
    }
    
    
    
    public static ExchangeRate getExchangeRate(Currency from, Currency to) throws Exception{
      URL url = new URL("http://api.fixer.io/latest?base=" + from.getCode() + "&symbols=" + to.getCode());
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      InputStreamReader input = new InputStreamReader(connection.getInputStream());
      try (BufferedReader reader = new BufferedReader(input)){
        String line = reader.readLine();
        line = line.substring(line.indexOf(to.getCode())+5, line.indexOf("}"));
        return new ExchangeRate(from, to, new Date(), Double.parseDouble(line));
      }
    }
}