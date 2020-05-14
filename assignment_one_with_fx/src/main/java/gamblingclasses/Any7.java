/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamblingclasses;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author slesperance
 */
public class Any7 extends Game {

    private final int win = 7;
    private final int winMulti = 4;
    //Create class variable for Bankroll
    BankValues bankRoll;
    MainValues dieRoll;
    BankCalculations bankCalc;
    Bet bet;
    private static final Logger LOG = Logger.getLogger(Any7.class.getName());
    
    

    public Any7(BankCalculations bankCalc, MainValues dieRoll, Bet bet) {
        //Reference passed to BankRoll.
        this.bet = bet;
        this.dieRoll = dieRoll;        
        this.bankCalc = bankCalc;
    }
    

    public void playAny7() {
        //Studying his stuff, this should do ABSOLUTELY NOTHING.
        //Call Private Methods, otherwise I can play with anything else.
        //Evacuate this

        double winnings = 0;
        int multiplier = 0;
        double bankBalance;
        
        LOG.log(Level.INFO, "bankCalc = " + (bankCalc == null));
        //Its ALWAYS THIS THAT CAUSES THE PROBLEM. But I've set myself up that no matter what, if I try to find it references, it WILL create a new object and screw me.
        bankCalc.bankBalanceBet(bet);
        

       if(wonOrLost()){
          multiplier = selectMultiplier(wonOrLost());
       }


        winnings = calculateWinnings(bet.getBet(), multiplier);
        bankCalc.adjustBankBalance(winnings);
    }

    private int selectMultiplier(boolean result) {
        int multiplier = 0;

        if (result) {
            multiplier = winMulti;
        } else {
            multiplier = super.getLose();
        }

        return multiplier;
    }

    private double calculateWinnings(double bet, int multiplier) {
        
        double newMultiplier = multiplier;
        double winnings = 0;
        if (newMultiplier > 0) {
            winnings = (bet * multiplier) + bet;
        }
        return winnings;
    }

    //I've established the reference in the constructor. It knows where it has to go. 
    private boolean wonOrLost() {
        int die1 = dieRoll.getDieOne();
        int die2 = dieRoll.getDieTwo();
        int score = die1 + die2;
        
        if(score == 7){
            return true;
        }
        
        
        return false;
    }

}
