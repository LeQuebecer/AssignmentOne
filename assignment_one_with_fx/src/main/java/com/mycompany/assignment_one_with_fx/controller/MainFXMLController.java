/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Sample Skeleton for 'MainFXML.fxml' Controller Class
 */
package com.mycompany.assignment_one_with_fx.controller;

import com.mycompany.assignment_one_with_fx.MainApp;
import gamblingclasses.Any7;
import gamblingclasses.BankCalculations;
import gamblingclasses.BankValues;
import gamblingclasses.Bet;
import gamblingclasses.FieldBet;
import gamblingclasses.MainCalculations;
import gamblingclasses.MainValues;
import gamblingclasses.PassLine;
import gamblingclasses.Player;
import java.awt.Frame;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.util.converter.NumberStringConverter;
import javax.swing.JOptionPane;

public class MainFXMLController implements Initializable {

    Player player;
    BankValues bankRoll;
    BankCalculations bankCalculations;
    Any7 anySeven;
    FieldBet fieldBet;
    PassLine passLine;
    MainValues mainValues;
    MainCalculations mainCalculations;
    Bet bet;
    private static final Logger LOG = Logger.getLogger(MainFXMLController.class.getName());

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="readName"
    private TextField readName; // Value injected by FXMLLoader

    @FXML // fx:id="readEmail"
    private TextField readEmail; // Value injected by FXMLLoader

    @FXML // fx:id="readBalance"
    private TextField readBalance; // Value injected by FXMLLoader

    @FXML // fx:id="displayName"
    private Label displayName; // Value injected by FXMLLoader

    @FXML // fx:id="displayEmail"
    private Label displayEmail; // Value injected by FXMLLoader

    @FXML // fx:id="displayBalance"
    private Label displayBalance; // Value injected by FXMLLoader

    @FXML // fx:id="openGameOne"
    private Button openGameOne; // Value injected by FXMLLoader

    @FXML // fx:id="gameThree"
    private Button gameThree; // Value injected by FXMLLoader

    @FXML // fx:id="gameTwo"
    private Button gameTwo; // Value injected by FXMLLoader

    @FXML // fx:id="exitButton"
    private Button exitButton; // Value injected by FXMLLoader

    @FXML // fx:id="submit"
    private Button submit; // Value injected by FXMLLoader

    @FXML
    private Label dieOneDisplay;

    @FXML
    private Label dieTwoDisplay;

    @FXML
    private Label dieTotalDisplay;

    @FXML
    private Label diePointDisplay;

    @FXML
    void exitAction(ActionEvent event) {
        Platform.exit(); // JavaFX does not use System.exit(0);   
    }

    @FXML
    void openGameOne(ActionEvent event) {
        //PASS LINE
        //First Wave of Conditions
        if (bankCalculations.canHePlay()) {
            String s = JOptionPane.showInputDialog("Please Enter Your Bet");
            //logger.log(Level.WARNING, "QUESTION SUCCEEDED"); 
            //Transfer S or convert it into a viable variable.
            bet.convertBetS(s);
            while (bet.checkTheBet()) {
                Alert a = new Alert(AlertType.NONE);
                a.setAlertType(AlertType.INFORMATION);
                a.setContentText("Bet exceeds Balance. Please try again.");
                a.showAndWait();
                s = JOptionPane.showInputDialog("Please Enter Your Bet");
                bet.convertBetS(s);
            }
            //This sets both die into MainValues. Then I ought to summon them into the game itself.
            mainCalculations.setDie();
            boolean hasWon = passLine.playPassLineFirst();
            //Setting Die Display - Need to convert to String. How?
            dieOneDisplay.setText(mainValues.getDieOneString());
            dieTwoDisplay.setText(mainValues.getDieTwoString());
            diePointDisplay.setText(mainValues.pointScoreString());
            dieTotalDisplay.setText(mainValues.dieTotal());
            LOG.log(Level.INFO, "first PRIMARY pointValue = " + (mainValues.pointScoreString()));
            if (!passLine.isEndOfGame()) {
                do {
                    Alert a = new Alert(AlertType.NONE);
                    a.setAlertType(AlertType.INFORMATION);
                    a.setContentText("No one has Won. Click Okay to Roll Again");
                    a.showAndWait();
                    mainCalculations.setDie();
                    hasWon = passLine.playPassLineSecond();
                    dieOneDisplay.setText(mainValues.getDieOneString());
                    dieTwoDisplay.setText(mainValues.getDieTwoString());
                    dieTotalDisplay.setText(mainValues.dieTotal());
                    LOG.log(Level.INFO, "SHOULD BE THE SAME AS ABOVE pointValue = " + (mainValues.pointScoreString()));
                } while (!passLine.isEndOfGame());

            }

        } else {
            //Verifies what Bank Balance is AT - if zero, when Player attempts to Play Game, it Kicks him out.
            Alert a = new Alert(AlertType.NONE);
            a.setAlertType(AlertType.CONFIRMATION);
            a.setContentText("You have Zero Dollars left. Goodbye!");
            a.showAndWait();
            Platform.exit();  //  - There needs to be a slight delay before this kicks in. A few seconds, at least, or only on clicking OKAY then it would trigger.
        }
        bankCalculations.canHePlay();
    }

    @FXML
    void openGameThree(ActionEvent event) {
        //ANY SEVEN
        //Special Conditions must be set for this one, a large scale If/Else to indicate whether a victory has been won or not. 
        //Last thought - Is there anyway I can bury more and more of this elsewhere? That would be very nice.
        //logger.log(Level.WARNING, "START");
        if (bankCalculations.canHePlay()) {
            //logger.log(Level.WARNING, "CAN HE PLAY SUCCEEDED");
            //Entry of the bet begins HERE.
            String s = JOptionPane.showInputDialog("Please Enter Your Bet");
            //logger.log(Level.WARNING, "QUESTION SUCCEEDED"); 
            //Transfer S or convert it into a viable variable.
            bet.convertBetS(s); // Verify bet values
            while (bet.checkTheBet()) {
                //I wonder if this could be it's own method.
                LOG.log(Level.INFO, "BEGIN BET CHECK FXML");
                Alert a = new Alert(AlertType.NONE);
                a.setAlertType(AlertType.INFORMATION);
                a.setContentText("Bet exceeds Balance or is negative. Please Try Again.");
                a.showAndWait();
                s = JOptionPane.showInputDialog("Please Enter Your Bet");
                bet.convertBetS(s);
            }
            //This sets both die into MainValues. Then I ought to summon them into the game itself.
            mainCalculations.setDie();

            anySeven.playAny7();

            dieOneDisplay.setText(mainValues.getDieOneString());
            dieTwoDisplay.setText(mainValues.getDieTwoString());
            dieTotalDisplay.setText(mainValues.dieTotal());

        } else {
            //Verifies what Bank Balance is AT - if zero, when Player attempts to Play Game, it Kicks him out.
            Alert a = new Alert(AlertType.NONE);
            a.setAlertType(AlertType.CONFIRMATION);
            a.setContentText("You have Zero Dollars left. Goodbye!");
            a.showAndWait();
            Platform.exit();  //  - There needs to be a slight delay before this kicks in. A few seconds, at least, or only on clicking OKAY then it would trigger.
        }
        bankCalculations.canHePlay();
    }

    @FXML
    void openGameTwo(ActionEvent event) {
        //FIELD BET

        if (bankCalculations.canHePlay()) {
            String s = JOptionPane.showInputDialog("Please Enter Your Bet");
            bet.convertBetS(s);
            while (bet.checkTheBet()) {
                Alert a = new Alert(AlertType.NONE);
                a.setAlertType(AlertType.INFORMATION);
                a.setContentText("Bet exceeds Balance. Please try again.");
                a.showAndWait();
                s = JOptionPane.showInputDialog("Please Enter Your Bet");
                bet.convertBetS(s);
            }
            fieldBet.playFieldBet();
            //logger.log(Level.WARNING, "QUESTION SUCCEEDED"); 
            //Transfer S or convert it into a viable variable.
            bet.convertBetS(s);
            mainCalculations.setDie();
            //Setting Die Display - Need to convert to String. How?
            dieOneDisplay.setText(mainValues.getDieOneString());
            dieTwoDisplay.setText(mainValues.getDieTwoString());
            dieTotalDisplay.setText(mainValues.dieTotal());
        } else {
            //Verifies what Bank Balance is AT - if zero, when Player attempts to Play Game, it Kicks him out.
            Alert a = new Alert(AlertType.NONE);
            a.setAlertType(AlertType.CONFIRMATION);
            a.setContentText("You have Zero Dollars left. Goodbye!");
            a.showAndWait();
            Platform.exit();  //  - There needs to be a slight delay before this kicks in. A few seconds, at least, or only on clicking OKAY then it would trigger.
        }
        bankCalculations.canHePlay();
    }

    /**
     *
     * @param event
     */
    @FXML
    protected void submitAction(ActionEvent event) {
        //This will be my FIRST big test. On SUBMIT, I must UPDATE things, set other variables, and move things forward. 
        displayName.setText(player.getName());
        readName.setEditable(false);
        displayEmail.setText(player.getEmailAddress());
        readEmail.setEditable(false);
        displayBalance.setText(bankRoll.getBankBalanceString());
        readBalance.setEditable(false);

    }

    public MainFXMLController() {
        super();
        bankRoll = new BankValues();
        bankCalculations = new BankCalculations(bankRoll);
        mainValues = new MainValues();
        mainCalculations = new MainCalculations(mainValues);
        LOG.log(Level.INFO, "STARTED");
        bet = new Bet(bankRoll, 0);
        LOG.log(Level.INFO, "ENDED");
        player = new Player();
        anySeven = new Any7(bankCalculations, mainValues, bet);
        fieldBet = new FieldBet(bankCalculations, mainValues, bet);
        passLine = new PassLine(bankCalculations, mainValues, bet);

    }

//    @FXML // This method is called by the FXMLLoader when initialization is complete
//    void initialize() {
//        //When I tried to replace the assert THAT caused a huge issue.
//        //Yet I still need to replace them regardless, because that's how he does it. 
//        
//        
//        
//          Bindings.bindBidirectional(readName.textProperty(), player.namePropertyType());
//      //  Bindings.bindBidirectional(planCombo.valueProperty() ispCalcBean.planTypeProperty());
////        assert readName != null : "fx:id=\"readName\" was not injected: check your FXML file 'MainFXML.fxml'.";
////        assert readEmail != null : "fx:id=\"readEmail\" was not injected: check your FXML file 'MainFXML.fxml'.";
////        assert readBalance != null : "fx:id=\"readBalance\" was not injected: check your FXML file 'MainFXML.fxml'.";
////        assert displayName != null : "fx:id=\"displayName\" was not injected: check your FXML file 'MainFXML.fxml'.";
////        assert displayEmail != null : "fx:id=\"displayEmail\" was not injected: check your FXML file 'MainFXML.fxml'.";
////        assert displayBalance != null : "fx:id=\"displayBalance\" was not injected: check your FXML file 'MainFXML.fxml'.";
////        assert openGameOne != null : "fx:id=\"openGameOne\" was not injected: check your FXML file 'MainFXML.fxml'.";
////        assert gameThree != null : "fx:id=\"gameThree\" was not injected: check your FXML file 'MainFXML.fxml'.";
////        assert gameTwo != null : "fx:id=\"gameTwo\" was not injected: check your FXML file 'MainFXML.fxml'.";
////        assert exitButton != null : "fx:id=\"exitButton\" was not injected: check your FXML file 'MainFXML.fxml'.";
////        assert submit != null : "fx:id=\"submit\" was not injected: check your FXML file 'MainFXML.fxml'.";
//
//    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Bindings.bindBidirectional(readName.textProperty(), player.namePropertyType());
        Bindings.bindBidirectional(readEmail.textProperty(), player.emailAddressPropertyType());
        Bindings.bindBidirectional(readBalance.textProperty(), bankRoll.bankBalanceProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(dieOneDisplay.textProperty(), mainValues.dieOneProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(dieTwoDisplay.textProperty(), mainValues.dieTwoProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(displayBalance.textProperty(), bankRoll.bankBalanceProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(diePointDisplay.textProperty(), mainValues.scorePointProperty(), new NumberStringConverter());
    }
    
    //Play Any 7
}
