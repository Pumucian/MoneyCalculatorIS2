package moneycalculator.vista;


import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import moneycalculator.controlador.MoneyCalculator;
import moneycalculator.model.Currency;
import moneycalculator.model.CurrencyList;
import moneycalculator.model.ExchangeRate;
import moneycalculator.model.Money;

public class MainFrame extends javax.swing.JFrame {
    private final CurrencyList currencyList = new CurrencyList();
    private ExchangeRate exchangeRate;
    private Money money;
    private Double amount;
    DecimalFormat formato = new DecimalFormat("0.00");
    public MainFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Calculador de divisa");
        addItemsCombo();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotónExchangeRate = new javax.swing.JButton();
        MonedaInicial = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        MonedaFinal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        códigos = new javax.swing.JComboBox<>();
        códigos2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BotónExchangeRate.setText("Cambio");
        BotónExchangeRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotónExchangeRateActionPerformed(evt);
            }
        });

        MonedaInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonedaInicialActionPerformed(evt);
            }
        });

        jLabel1.setText("Moneda Inicial");

        MonedaFinal.setEditable(false);
        MonedaFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonedaFinalActionPerformed(evt);
            }
        });

        jLabel2.setText("MonedaFinal");

        códigos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        códigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                códigosActionPerformed(evt);
            }
        });

        códigos2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        códigos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                códigos2ActionPerformed(evt);
            }
        });

        jLabel3.setText("a");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MonedaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(códigos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(códigos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(MonedaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(BotónExchangeRate)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MonedaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MonedaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(códigos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(códigos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotónExchangeRate)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotónExchangeRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotónExchangeRateActionPerformed
        if(MonedaInicial.getText().length()==0) {
            amount = 0.0;
        }else{
            if(Double.parseDouble(MonedaInicial.getText()) < 0){
                JOptionPane.showMessageDialog(null, "Se han colocado números negativos, arreglando el error de sintaxis...", "Advertencia", JOptionPane.WARNING_MESSAGE);
                amount = Double.parseDouble(MonedaInicial.getText())*-1;
                int aux= Integer.parseInt(MonedaInicial.getText())*-1;
                String auxS = String.valueOf(aux);
                MonedaInicial.setText(auxS);
            }else{
                amount = Double.parseDouble(MonedaInicial.getText());
            }
            
        }        
        Currency currency = currencyList.get((String) códigos.getSelectedItem());
        Currency currencyTo= currencyList.get((String) códigos2.getSelectedItem());
        if(currency.equals(currencyTo)){
            JOptionPane.showMessageDialog(null, "Las divisas son las mismas, el procedimiento no se hará", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }else{
            money = new Money(amount, currency);
        
            try {
                exchangeRate= MoneyCalculator.getExchangeRate(currency,currencyTo);
            } catch (Exception ex) {                
            }        
            double cambio = money.getAmount() * exchangeRate.getRate();
            MonedaFinal.setText(formato.format(cambio) + currencyTo.getSymbol());
        }
       
                
    }//GEN-LAST:event_BotónExchangeRateActionPerformed

    private void MonedaInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonedaInicialActionPerformed
    }//GEN-LAST:event_MonedaInicialActionPerformed

    private void MonedaFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonedaFinalActionPerformed
    }//GEN-LAST:event_MonedaFinalActionPerformed

    private void códigos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_códigos2ActionPerformed

    }//GEN-LAST:event_códigos2ActionPerformed

    private void códigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_códigosActionPerformed

    }//GEN-LAST:event_códigosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotónExchangeRate;
    private javax.swing.JTextField MonedaFinal;
    private javax.swing.JTextField MonedaInicial;
    private javax.swing.JComboBox<String> códigos;
    private javax.swing.JComboBox<String> códigos2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

    private void addItemsCombo() {
        códigos.addItem(new Currency("USD","Dolar americano","$").getCode());
        códigos.addItem(new Currency("EUR","Euro","€").getCode());
        códigos.addItem(new Currency("GBP","Libra Esterlina","£").getCode());
        códigos.addItem(new Currency("INR","Rupia India","₹").getCode());
        códigos.addItem(new Currency("AUD","Dolar Australiano","$").getCode());
        códigos.addItem(new Currency("CAD","Dolar Canadiense","$").getCode());
        códigos.addItem(new Currency("SGD","Dolar Singapurense","$").getCode());
        códigos.addItem(new Currency("JPY","Yen Japonés","¥").getCode());
        códigos.addItem(new Currency("CNY","Yuan Renminbi Chino","元").getCode());
        códigos2.addItem(new Currency("EUR","Euro","€").getCode());   
        códigos2.addItem(new Currency("USD","Dolar americano","$").getCode());
        códigos2.addItem(new Currency("GBP","Libra Esterlina","£").getCode());
        códigos2.addItem(new Currency("INR","Rupia India","₹").getCode());
        códigos2.addItem(new Currency("AUD","Dolar Australiano","$").getCode());
        códigos2.addItem(new Currency("CAD","Dolar Canadiense","$").getCode());
        códigos2.addItem(new Currency("SGD","Dolar Singapurense","$").getCode());
        códigos2.addItem(new Currency("JPY","Yen Japonés","¥").getCode());
        códigos2.addItem(new Currency("CNY","Yuan Renminbi Chino","元").getCode());
    }
}
