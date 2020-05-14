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
public class PassLine extends Game {

    private final Integer[] firstWinCondition = new Integer[]{7, 11};
    private final Integer[] firstLoseCondition = new Integer[]{2, 3, 12};
    private final int secondLoseCondition = 7;
    private static final Logger LOG = Logger.getLogger(FieldBet.class.getName());

    BankValues bankRoll;
    MainValues dieRoll;
    BankCalculations bankCalc;
    Bet bet;

    //In ideal circumstances there would be a separate Game bean with victory conditions etc. That would make more sense. 
    private boolean endOfGame = false;

    public PassLine(BankCalculations bankCalc, MainValues dieRoll, Bet bet) {
        this.bankCalc = bankCalc;
        this.dieRoll = dieRoll;
        this.bet = bet;
    }

    public boolean isEndOfGame() {
        return endOfGame;
    }

    private void setEndOfGame(boolean status) {
        this.endOfGame = status;
    }

    public boolean playPassLineFirst() {
        double payOut = 0;
        bankCalc.bankBalanceBet(bet);
        if (firstWinCondition()) {
            System.out.println("If" + firstWinCondition());
            LOG.log(Level.INFO, "bet " + bet.getBet());
            payOut = calculateWinnings(bet.getBet());
            LOG.log(Level.INFO, "payOut " + payOut);
            bankCalc.adjustBankBalance(payOut);
            setEndOfGame(true);
            return true;
        } else if (firstLoseCondition()) {
            setEndOfGame(true);
            return true;
        }
        dieRoll.setPointScore(dieRoll.getDieOne() + dieRoll.getDieTwo());
        LOG.log(Level.INFO, "setPointScore " + dieRoll.getScorePoint());
        return false;
    }

    public boolean playPassLineSecond() {
        double payOut = 0;
        if (secondWinCondition()) {
            LOG.log(Level.INFO, "second game bet " + bet.getBet());
            payOut = calculateWinnings(bet.getBet());
            LOG.log(Level.INFO, "second game payOut " + payOut);
            bankCalc.adjustBankBalance(payOut);
            setEndOfGame(true);
            return true;
        } else if (secondLoseCondition()) {
            setEndOfGame(true);
            return true;
        }
        return false;
    }

    private double calculateWinnings(double bet) {
        double winnings = (bet * 2);
        return winnings;
    }

    private boolean secondLoseCondition() {
//        int die1 = dieRoll.getDieOne();
//        LOG.log(Level.INFO, "first die " + dieRoll.getDieOne());
//        int die2 = dieRoll.getDieTwo();
//        LOG.log(Level.INFO, "second die " + dieRoll.getDieTwo());
//        int score = die1 + die2;
//        LOG.log(Level.INFO, "second score " + score);
//        LOG.log(Level.INFO, "the point " + dieRoll.getScorePoint());
        if (returnScore() == secondLoseCondition) {
            return true;
        }

        LOG.log(Level.INFO, "END WONORLOST");
        return false;
    }

    private boolean firstWinCondition() {
//        int die1 = dieRoll.getDieOne();
//        LOG.log(Level.INFO, "first die " + dieRoll.getDieOne());
//        int die2 = dieRoll.getDieTwo();
//        LOG.log(Level.INFO, "second die " + dieRoll.getDieTwo());
//        int score = die1 + die2;
//        LOG.log(Level.INFO, "first score " + score);
        for (int check : firstWinCondition) {
            if (returnScore() == check) {
                return true;
            }
        }
        LOG.log(Level.INFO, "first condition " + dieRoll.pointScoreString());
        return false;
    }

    private boolean firstLoseCondition() {
//        int die1 = dieRoll.getDieOne();
//        int die2 = dieRoll.getDieTwo();
//        int score = die1 + die2;
        for (int check : firstLoseCondition) {
            if (returnScore() == check) {
                return true;
            }
        }

        return false;
    }

    private boolean secondWinCondition() {
//        int die1 = dieRoll.getDieOne();
//        int die2 = dieRoll.getDieTwo();
//        int score = die1 + die2;
        if (returnScore() == dieRoll.getScorePoint()) {
            LOG.log(Level.INFO, "Second score " + returnScore());
            LOG.log(Level.INFO, "Second pont condition " + dieRoll.getScorePoint());
            return true;
        }
        LOG.log(Level.INFO, "Second condition " + dieRoll.pointScoreString());

        return false;
    }

    private int returnScore() {
        int score;
        int die1 = dieRoll.getDieOne();
        int die2 = dieRoll.getDieTwo();
        return score = die1 + die2;

    }

//Last Issue, I need to do two things. Incorporate the win/loss variable. But How?
}
