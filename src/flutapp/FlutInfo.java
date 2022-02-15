/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flutapp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author azubi02
 */
public class FlutInfo {

    
    private TextField vornameTF;
    private TextField nachnameTF;
    private TextField emailTF;
    private TextField strasseTF;
    private TextField hausnummerTF;
    private TextField stadtTF;
    private TextField betragTF;
    private TextField plzTF;

    private Button Btn;
    private GridPane gridpane;
    private AnchorPane anchorPane;
    private ObservableList<Daten> personeninfo;
    private TableView<Daten> tab;
    private TableColumn<Daten, String> nrCol;
    private TableColumn<Daten, String> nachnameCol;
    private TableColumn<Daten, String> vornameCol;
    private TableColumn<Daten, String> betragCol;
    private TableColumn<Daten, String> strasseCol;
    private TableColumn<Daten, String> plzCol;
    private TableColumn<Daten, String> emailCol;
    private Button Btnsend;
    

    Date date = new Date();
    Random ran = new Random();
    int upperbound = 100;

    public FlutInfo() throws FileNotFoundException {
    
        personeninfo = FXCollections.observableArrayList();

        initTab();
        initGui();
        initGrid();
        initAnchorPane();
       

    }

    private void initGui() {
        Btn = new Button("Datei auslesen");
        Btnsend = new Button("Email versenden");
        vornameTF = new TextField();
        nachnameTF = new TextField();
        strasseTF = new TextField();
        plzTF = new TextField();
        betragTF = new TextField();
        stadtTF = new TextField();
        hausnummerTF = new TextField();
        emailTF = new TextField();
        

        Btn();
        Btnsend();
        
        

    }

    private void initGrid() throws FileNotFoundException {
        gridpane = new GridPane();
        gridpane.add(Btn, 1, 4);
        
        gridpane.add(Btnsend, 0, 4);
        gridpane.add(vornameTF, 0, 0);
        gridpane.add(nachnameTF, 0, 1);
        gridpane.add(strasseTF, 0, 2);
        gridpane.add(plzTF, 0, 3);
        gridpane.add(betragTF, 1, 0);
        gridpane.add(stadtTF, 1, 1);
        gridpane.add(hausnummerTF, 1, 2);
        gridpane.add(emailTF, 1, 3);

        gridpane.add(tab, 1, 12);
        gridpane.setHgap(3);
        gridpane.setVgap(3);
        gridpane.setPadding(new Insets(15, 10, 15, 10));

    }

    private void initAnchorPane() {
        anchorPane = new AnchorPane();
        AnchorPane.setBottomAnchor(tab, 10.0);
        AnchorPane.setLeftAnchor(tab, 10.0);
        AnchorPane.setRightAnchor(tab, 10.0);
        AnchorPane.setTopAnchor(tab, 200.0);
        anchorPane.getChildren().addAll(tab, gridpane);

    }

    public GridPane getgridpane() {
        return gridpane;
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }
 

    private void Btn() {
        Btn.setOnAction(l -> {
            try {
                FileReading();
                FlutMail.nachname=(nachnameTF.getText());
               
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FlutInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    private void Btnsend() {
        Btnsend.setOnAction(x -> {
             createPDF.nachname = nachnameTF.getText();
             createPDF.betrag = betragTF.getText();
             createPDF.datum = date.toString();
             createPDF.rechnungsnr = ran.nextInt(upperbound);
             createPDF.vorname = vornameTF.getText();
             createPDF.hausnummer = hausnummerTF.getText();
             createPDF.plz = plzTF.getText();
             createPDF.stadt = stadtTF.getText();
             createPDF.strasse = strasseTF.getText();
             createPDF.email = emailTF.getText();
            try {
                
                FlutMail.email(emailTF.getText());
                System.out.println("Email erfolgreich gesendet");
                
            } catch (Exception ex) {
                Logger.getLogger(FlutInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    private void initnachnameCol() {
        nachnameCol = new TableColumn<>();
        nachnameCol.setText("Nachname");
        nachnameCol.setCellValueFactory(new PropertyValueFactory<>("nachname"));

        nachnameCol.setMinWidth(100);
        nachnameCol.prefWidthProperty().bind(tab.widthProperty().divide(4));
    }

    private void initstadtCol() {
        nachnameCol = new TableColumn<>();
        nachnameCol.setText("Stadt");
        nachnameCol.setCellValueFactory(new PropertyValueFactory<>("stadt"));

        nachnameCol.setMinWidth(100);
        nachnameCol.prefWidthProperty().bind(tab.widthProperty().divide(4));
    }

    private void initplzCol() {
        plzCol = new TableColumn<>();
        plzCol.setText("Postleitzahl");
        plzCol.setCellValueFactory(new PropertyValueFactory<>("plz"));

        plzCol.setMinWidth(100);
        plzCol.prefWidthProperty().bind(tab.widthProperty().divide(4));
    }

    private void initbetragCol() {
        betragCol = new TableColumn<>();
        betragCol.setText("Betrag");
        betragCol.setCellValueFactory(new PropertyValueFactory<>("betrag"));

        nachnameCol.setMinWidth(100);
        nachnameCol.prefWidthProperty().bind(tab.widthProperty().divide(4));
    }

    private void initstrasseCol() {
        strasseCol = new TableColumn<>();
        strasseCol.setText("Straße");
        strasseCol.setCellValueFactory(new PropertyValueFactory<>("strasse"));

        strasseCol.setMinWidth(100);
        strasseCol.prefWidthProperty().bind(tab.widthProperty().divide(4));
    }

    private void initnrCol() {
        nrCol = new TableColumn<>();
        nrCol.setText("Nr.");
        nrCol.setCellValueFactory(new PropertyValueFactory<>("hausnummer"));

        nrCol.setMinWidth(100);
        nrCol.prefWidthProperty().bind(tab.widthProperty().divide(4));
    }

    private void initvornameCol() {
        vornameCol = new TableColumn<>();
        vornameCol.setText("Vorname");
        vornameCol.setCellValueFactory(new PropertyValueFactory<>("vorname"));

        vornameCol.setMinWidth(100);
        vornameCol.prefWidthProperty().bind(tab.widthProperty().divide(4));

    }

    private void initemailCol() {
        emailCol = new TableColumn<>();
        emailCol.setText("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        emailCol.setMinWidth(100);
        emailCol.prefWidthProperty().bind(tab.widthProperty().divide(4));
    }

    private void initTab() {

        tab = new TableView<>();
        initvornameCol();
        initnachnameCol();
        initstrasseCol();
        initnrCol();
        initemailCol();
        initbetragCol();
        initstadtCol();
        initplzCol();

        tab.getColumns().addAll(vornameCol, nachnameCol, strasseCol, nrCol, emailCol, betragCol);
        tab.setItems(personeninfo);

    }

    private void FileReading() throws FileNotFoundException {
        String path = "/home/azubi02/NetBeansProjects/FlutApp/daten.txt";
        FileReader fr = new FileReader(path);
       
        {
            BufferedReader reader = new BufferedReader(fr);
            String textFromFile;
            try {
                while ((textFromFile = reader.readLine()) != null) {
                    String[] teil = textFromFile.split("#");

                    String vorname = teil[0];
                    String nachname = teil[1];
                    String strasse = teil[2];
                    String hausnummer = teil[3];
                    String plz = teil[4];
                    String stadt = teil[5];
                    String email = teil[6];
                    String betrag = teil[7];

                    vornameTF.setText(vorname);
                    nachnameTF.setText(nachname);
                    strasseTF.setText(strasse);
                    hausnummerTF.setText(hausnummer);
                    plzTF.setText(plz);
                    emailTF.setText(email);
                    stadtTF.setText(stadt);
                    betragTF.setText(betrag);

                    Daten inhalt = new Daten();

                    inhalt.setNachname(nachname);
                    inhalt.setVorname(vorname);
                    inhalt.setStrasse(strasse);
                    inhalt.setHausnummer(hausnummer);
                    inhalt.setPlz(plz);
                    inhalt.setEmail(email);
                    inhalt.setStadt(stadt);
                    inhalt.setBetrag(betrag);
                    personeninfo.add(inhalt);

                }
            } catch (IOException ex) {
                Logger.getLogger(FlutInfo.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

    
}        


