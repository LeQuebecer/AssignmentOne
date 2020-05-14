/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Sample Skeleton for 'MainFXML.fxml' Controller Class
 */

package com.mycompany.assignment_one_with_fx.controller;

/**
 * Sample Skeleton for 'AssignmentOne.fxml' Controller Class
 */

import com.mycompany.assignment_one_with_fx.MainApp;
import gamblingclasses.BankValues;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

public class GameWindowFXMLController {
    
    //Create Games
    //Create BankRoll
//    BankValues bankvalues = new BankValues();
//    MainValues dieRoll
//    Any7 gameSeven = new Any7(bankValues);
    //Repeat for two more. 

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="udt"
    private Label udt; // Value injected by FXMLLoader

    @FXML // fx:id="playGame"
    private Button playGame; // Value injected by FXMLLoader

    @FXML // fx:id="exitAction"
    private Button exitAction; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert udt != null : "fx:id=\"udt\" was not injected: check your FXML file 'AssignmentOne.fxml'.";
        assert playGame != null : "fx:id=\"playGame\" was not injected: check your FXML file 'AssignmentOne.fxml'.";
        assert exitAction != null : "fx:id=\"exitAction\" was not injected: check your FXML file 'AssignmentOne.fxml'.";

    }
}
