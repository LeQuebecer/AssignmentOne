/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamblingclasses;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author slesperance
 */
public class FieldBet extends Game {

    private final Integer[] winOneTimes = new Integer[]{3, 4, 9, 10, 11};
    private final int winTwoTimes = 2;
    private final int winThreeTimes = 12;
    private final int vcOne = 1;
    private final int vcTwo = 2;
    private final int vcThree = 3;
    private static final Logger LOG = Logger.getLogger(FieldBet.class.getName());
    BankCalculations bankCalc;
    MainValues dieRoll;
    Bet bet;

    //Default Constructor 
    public FieldBet(BankCalculations bankCalc, MainValues dieRoll, Bet bet) {
        this.bankCalc = bankCalc;
        this.dieRoll = dieRoll;
        this.bet = bet;

    }

    //Next Step - The Bet and the Game
    public void playFieldBet() {
        LOG.log(Level.INFO, "START PLAYFIELDBET");
        double winnings = 0;
        int multiplier = 0;
        double bankBalance;
        double betDouble = 0;
        LOG.log(Level.INFO, "bankCalc = " + (bankCalc == null));
        //Its ALWAYS THIS THAT CAUSES THE PROBLEM. But I've set myself up that no matter what, if I try to find it references, it WILL create a new object and screw me.
        
        bankCalc.bankBalanceBet(bet);
        
        if (wonOrLost()) {
            multiplier = selectMultiplier();
            winnings = calculateWinnings(bet.getBet(), multiplier);
            bankCalc.adjustBankBalance(winnings);
        }
        LOG.log(Level.INFO, "END PLAYFIELDBET");

    }

    private int selectMultiplier() {
        LOG.log(Level.INFO, "START MULTIPLIER");
        int multiplier = 0;
        int die1 = dieRoll.getDieOne();
        int die2 = dieRoll.getDieTwo();
        int score = die1 + die2;

        if (score == winTwoTimes) {
            multiplier = vcTwo;
        } else if (score == winThreeTimes) {
            multiplier = vcThree;
        } else if (winOnce()) {
            multiplier = vcOne;
        } else {
            multiplier = 0;
        }

        LOG.log(Level.INFO, "END MULTIPLIER");
        return multiplier;
    }

    private boolean winOnce() {
        LOG.log(Level.INFO, "START WINONCE");
        int die1 = dieRoll.getDieOne();
        int die2 = dieRoll.getDieTwo();
        int score = die1 + die2;
        for (int i = 0; i < winOneTimes.length; i++) {
            int check = winOneTimes[i];
            if (check == score) {
                return true;
            }
        }
        LOG.log(Level.INFO, "END WINONCE");
        return false;
    }

    private double calculateWinnings(double bet, int multiplier) {
         LOG.log(Level.INFO, "START CALCULATEWINNINGS");
        double newMultiplier = multiplier;
        double winnings = 0;
        if (newMultiplier > 0) {
            winnings = (bet * multiplier) + bet;
        }
        LOG.log(Level.INFO, "END CALCULATEWINNINGS");
        return winnings;
    }

    private boolean wonOrLost() {
        LOG.log(Level.INFO, "START WONORLOST");
        int die1 = dieRoll.getDieOne();
        int die2 = dieRoll.getDieTwo();
        int score = die1 + die2;

        if (winOnce()) {
            return true;
        } else if (score == winTwoTimes) {
            return true;
        } else if (score == winThreeTimes) {
            return true;
        }
        LOG.log(Level.INFO, "END WONORLOST");
        return false;
    }

//END OF THE LINE    
}
