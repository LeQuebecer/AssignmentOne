/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamblingclasses;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * - Primary goal of this is to conduct the major bank calculations I need. 
 * @author slesperance
 */
public class BankCalculations {
    //Why does final give me such a headache? 
    private BankValues bankvalues;
    private Bet bet;
    
    //Do I need other values? Nyet.
    //The win or lose conditions can be summoned up from each individual game. 
    private static final Logger LOG = Logger.getLogger(BankCalculations.class.getName());
    
    
    public BankCalculations(BankValues bankvalues){
        this.bankvalues = bankvalues;
    }
    
    public BankCalculations (Bet bet) {
        this.bet = bet;
    }
    //I need to calculate based on two things - really, just one. Whether they won, or they lost. That's one method.
    public void adjustBankBalance(double bet){
        double bankBalance;
        bankBalance = bankvalues.getBankBalance() + bet;
        LOG.log(Level.INFO, "bet = " + bet);
        LOG.log(Level.INFO, "bankbalance before " + bankvalues.getBankBalanceString());
        bankvalues.setBankBalance(bankBalance);
        LOG.log(Level.INFO, "bankbalance before " + bankvalues.getBankBalanceString());
    }
    
    public void bankBalanceBet (Bet bet) {
      double balanceLessBet = bankvalues.getBankBalance() - bet.getBet();
      bankvalues.setBankBalance(balanceLessBet);
    }
    
    public void checkBankBalance(){
        bankvalues.getBankBalance();
    }
    
    
    //Second Method - Can he play. Boolean, provided bank balance is above zero.
    //Note - I need to deploy this at an ideal situation. I also need a variable in the FXML that will trigger an automatic END the moment 
    public boolean canHePlay(){
        return bankvalues.getBankBalance() > 0;
    }
}
