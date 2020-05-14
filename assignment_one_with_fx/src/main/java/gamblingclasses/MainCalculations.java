/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamblingclasses;

import java.util.Random;

/**
 * Die are rolled, and finally set.
 * @author slesperance
 */
public class MainCalculations {
    
    //Sole goal is to generate the die roll that are then set directly into the MainValues in FXML Controller.
    //I need to generate and DISCARD this, rather than creating multiple copies
    //This ALSO has to be passed a consistent copy of the MainValues, or at least, specifically, whichever variant 
    
    private MainValues mainValues;
    
    public MainCalculations(MainValues mainValues){
        this.mainValues = mainValues;
        
    }
    
    public void setDie(){
        mainValues.setDieOne(rollDieOne());
        mainValues.setDieTwo(rollDieTwo());
    }
    
    //Rolling the Die, but keeping it private should, I deally mean, people can't futz around with it by setting the values.
    private int rollDieOne() {
        int num;
        Random rand1 = new Random();
        num = rand1.nextInt(7);
        return num;
    }
    
        private int rollDieTwo() {
        int num;
        Random rand2 = new Random();
        num = rand2.nextInt(7);
        return num;
    }
        
        public void setPointScore(){
            
        }
    
}
