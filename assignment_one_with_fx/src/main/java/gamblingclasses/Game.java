/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamblingclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author slesperance
 */
public class Game {
    private static final int lose = -1;
    private static final int win = 1;

    public int getLose() {
        return lose;
    }

    public int getWin() {
        return win;
    }
    
    
    //Somehow I need to return more than just this. I need it in a property format.
    //And I need to run it somehow simultaneously?
    //I don't want to create TWO methods, when ONE will do, but I need to return TWO separate values. 
    //Maybe this is fine. Really, all I need to do is do something like dieOne.setproperty().equals.rolldie();
    
    //Die Rolling Method
    public int rollDie(){
        Random rand = new Random();
        //Two variables in case I wish to display the actual die on the screen.
        int firstRoll, secondRoll;
       
        
        firstRoll = rand.nextInt(7);
        secondRoll = rand.nextInt(7);
        
        int total = secondRoll + firstRoll;
        return total;
        
    }
    
    // Just returns the total amount in the bank left.
    private double earnings (double bank, double earnings){
        double newBank = bank + earnings;
        return newBank;
    }
    
    
    //Verify if Bank Balance is ABOVE Zero
    //Should this be here? Might need a Bank Class in matter of fact, some of these things DO NOT belong here probably.
    
    private boolean letHimPlay (double bankBalance){
        if (bankBalance > 0){
            return true;
        }else{
            return false;
        }
    }

    
    
}
