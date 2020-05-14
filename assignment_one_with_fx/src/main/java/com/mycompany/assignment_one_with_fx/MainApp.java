/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment_one_with_fx;

import com.mycompany.assignment_one_with_fx.controller.MainFXMLController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 *
 * @author slesperance
 */
public class MainApp extends Application {
    
    @Override
    public void start(Stage primaryStage) {
try {
   FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainFXML.fxml")); 
   Parent root = loader.load();
   MainFXMLController controller = loader.getController();
   Scene scene = new Scene(root);
   primaryStage.setTitle("Casino Demo");
   primaryStage.setScene(scene);
   primaryStage.show();
} catch (IOException | IllegalStateException ex) {
   Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
   // See code samples for displaying an Alert box if an exception is thrown
}


    

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
