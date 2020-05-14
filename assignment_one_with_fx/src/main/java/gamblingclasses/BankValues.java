/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamblingclasses;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author slesperance
 */
public class BankValues {
    //CHANGFE TO INTEGERS
    private final DoubleProperty bankBalance;
    //The bet is an issue. I need it to be passed, I need it to exist.
//    private final DoubleProperty bet;

    public BankValues(final double bankBalance) {
        this.bankBalance = new SimpleDoubleProperty();
    }
    
    public BankValues() {
        this(0);
    }
    
    


    public double getBankBalance() {
        return bankBalance.doubleValue();
    }
    
    //Not very protected - not very elegant - but it works for now. I could stick MOST of this into a private method, and then summon it into the public. 
    public String getBankBalanceString(){
        String string;
        Double bankAmount;
        bankAmount = bankBalance.doubleValue();
        string = bankAmount.toString();
        return string;
    }

//    public double getBet() {
//        return bet.doubleValue();
//    }
    
    
    public void setBankBalance(double bankBalance) {
        this.bankBalance.set(bankBalance);
    }
    
//    public void setBet(double bet) {
//        this.bet.set(bet);
//    }
    
    public DoubleProperty bankBalanceProperty() {
        return bankBalance;
    }
    
    //Need to set this to zero on a regular basis at the end of everything. 
//    public DoubleProperty betProperty() {
//        return bet;
//    }
    
    
    
    
    
}
