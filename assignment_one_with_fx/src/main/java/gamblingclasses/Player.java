/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamblingclasses;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author slesperance
 */
public class Player {
    
    private final StringProperty name;
    private final StringProperty emailAddress;

    public Player(final String name, final String emailAddress) {
        this.name = new SimpleStringProperty();
        this.emailAddress = new SimpleStringProperty();
    }
    
    public Player() {
       this("", "");
    }

    public String getName() {
        return name.get();
    }

    public String getEmailAddress() {
        return emailAddress.get();
    }

 
    public void setName(String name) {
        this.name.set(name);
    }
    
    
    public void setEmaillAddress(String emailAddress) {
        this.emailAddress.set(emailAddress);
    }
    
    
    public StringProperty namePropertyType() {
        return name;
    }
    
    
    public StringProperty emailAddressPropertyType() {
        return emailAddress;
    }
    
    //I need to A) Summon Balance (Double) - That's already above - But I want it with a check , B) Verify if Balance isn't Zero (Boolean), C) Adjust Balance
    
   //Adjust Balance
    



    
   //Everything else must be done within the context of the Main. I really don't think I need anything else here.

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", emailAddress=" + emailAddress + '}';
    }
    

    

    
}
