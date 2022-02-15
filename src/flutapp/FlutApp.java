/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package flutapp;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FlutApp extends Application {
    
    public static void main(String[] args) throws IOException, Exception {

        launch(args);

    }
 //   Dokument und Seite hinzufügen
   

    
    @Override
    public void start(Stage stage) throws Exception {

        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("Menü");

        tabPane.getTabs().add(tab1);
        AnchorPane anchorpane = new FlutInfo().getAnchorPane();
        tab1.setContent(anchorpane);

        VBox vBox = new VBox(tabPane);
        Scene scene = new Scene(vBox);

        stage.setScene(scene);
        stage.setTitle("FlutApp");
        stage.show();
    

       
        
    }
}

