/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamblingclasses;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Do the same Process for Player, because its the exact same thing. 
 * @author slesperance
 */
public class MainValues {
// Alright, so my new plan is to keep these values here. I will then CREATE, in Game, methods that will SET the property of the stuff here.
//Then, in the methods elsewhere 
    
    private final IntegerProperty dieOne;
    private final IntegerProperty dieTwo;
    private final IntegerProperty pointScore;
    private static final Logger LOG = Logger.getLogger(Any7.class.getName());
    
    //Right now the Die are Empty - until I functionally generate them fromsomewhere else. 
    //So what do I do? I think its the same as BankValues via BankCalculations

    public MainValues(final int dieOne, final int dieTwo, final int pointScore) {
        this.dieOne = new SimpleIntegerProperty(0);
        this.dieTwo = new SimpleIntegerProperty(0);
        this.pointScore = new SimpleIntegerProperty(0);
        
    }
    
    public MainValues() {
        this(0,0,0);
    }

    public IntegerProperty dieOneProperty() {
        return this.dieOne;
    }

    public IntegerProperty dieTwoProperty() {
        return this.dieTwo;
    }
    public IntegerProperty scorePointProperty(){
        return this.pointScore;
    }
    
    
    public void setDieOne(int dieOne){
        this.dieOne.set(dieOne);
    }
    
    public void setDieTwo(int dieTwo) {
        this.dieTwo.set(dieTwo);
    }
    
    public void setPointScore(int pointScore){
        this.pointScore.set(pointScore);
    }
    
    public int getDieOne() {
        return dieOne.intValue();
    }
    
    public int getDieTwo() {
        return dieTwo.intValue();
    }
    
    public int getScorePoint(){
        return pointScore.intValue();
    }
    
    public void clearDie() {
        this.setDieOne(0);
        this.setDieTwo(0);
        this.setPointScore(0);
    }
    
    public String getDieOneString(){
        String string;
        Integer die;
        die = dieOne.intValue();
        string = die.toString();
        return string;
    }
    
        public String getDieTwoString(){
        String string;
        Integer die;
        die = dieTwo.intValue();
        string = die.toString();
        return string;
    }
        
        public String dieTotal() {
            String string;
            Integer total;
            total = dieTwo.intValue() + dieOne.intValue();
            string = total.toString();
            return string;
            
        }
        
        public String pointScoreString(){
            String string;
            Integer pointScore;
            pointScore = dieTwo.intValue() + dieOne.intValue();
            string = pointScore.toString();
            return string;
        }
    
    
    
    
    
    


    
}
