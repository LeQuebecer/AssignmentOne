/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamblingclasses;

import java.util.Random;

/**
 *
 * @author slesperance
 */
public class GameCalculations {
    //Based on several uncertainties, I need to determine the best way to proceed.
    //Right now, it seems I have THREE courses of action. One class PER game (borrows from pre-existing work).
    //One super class to encompass ALL games.
    //Prferable multiple classes, each only ACTIVATED in so far as it is needed. 
    //The point I need to remember (might as well leave these instructions here) is that each class must now  interact with its values class.

    //so I need a DiceRoll class - it has a singular job, which is to generate a random number from 1-6 and then fit it in. Might be I need to set it so it does it automatically for both.
    //Lets do that here.
    private MainValues mainvalues;

    
    //This calculates my Die Roll. I don't think I need anything else from here - unless Mr. Fogel stipulates it would be a good idea to centralize things. 
    public void rollDie() {
        Random rand = new Random();
        //CHANGE TO INTS
        int dieOne, dieTwo;
        //Note - Another option is to make the die rolls an individual, private method and then lock them up somewhere else. Might mean they cant acess the roll and adjust it. Which would be nice.
        dieOne = rand.nextInt(7); 
        dieTwo = rand.nextInt(7);

        mainvalues.setDieOne(dieOne);
        mainvalues.setDieTwo(dieTwo);

    }
    
    

}
