/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamblingclasses;

import static java.lang.Double.parseDouble;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * Bet Class exists to separate things properly. I'm unsure if this is the best
 * method/application.
 *
 * @author slesperance
 */
public class Bet {
    //Created a separate Bet class. This object needs to be created very often, and then disposed of. Like plastic water bottles.

    private DoubleProperty bet;
    BankValues bankRoll;
    private static final Logger LOG = Logger.getLogger(Bet.class.getName());

    public Bet(double bet) {
        this.bet = new SimpleDoubleProperty();

    }
    
    public Bet(BankValues bankRoll, double bet){
        this.bankRoll = bankRoll;
        this.bet = new SimpleDoubleProperty();

    }


    public double convertBetS(String stringBet) {
        //I need to convert from STRING to DOUBLE
        double numberBet = 0.0;
        numberBet = parseDouble(stringBet);
        setBet(numberBet);
        return numberBet;
    }

    public boolean checkTheBet() {
        LOG.log(Level.INFO, "STARTED BET CHECK");
        double theBet = this.bet.doubleValue();
        LOG.log(Level.INFO, "GOT BET VALUE");
        if(theBet > bankRoll.getBankBalance() || theBet < 0){
            return true;
        }
        return false;

    }

    public Bet() {
        this(0);
    }

    public double getBet() {
        return bet.doubleValue();
    }

    //It is set to zero, so once summoned, it will reinitialize the bet to nothing
    public void setBet(double bet) {

        this.bet.set(bet);

    }

    public DoubleProperty betProperty() {
        return bet;
    }

}
