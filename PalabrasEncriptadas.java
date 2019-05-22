/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palabras.encriptadas;

import java.util.Base64;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class PalabrasEncriptadas extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Label palabra = new Label();    
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        
        Scene scene = new Scene(grid, 300, 250);
        
        palabra.setText("PALABRA");
        grid.add(palabra,0,1);
        
        TextField caja = new TextField();
        grid.add(caja,1,1);
        
        Button encriptar = new Button("ENCRIPTAR");
        grid.add(encriptar,1,2);
        
        Button desencriptar = new Button("DESENCRIPTAR");
        grid.add(desencriptar,1,3);
        
        encriptar.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            byte[] palabra = caja.getText().getBytes();
            String palabraEncriptada = Base64.getEncoder().encodeToString(palabra);
            caja.setText(palabraEncriptada);
            }  
        });
        
        desencriptar.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] palabra2 = decoder.decode(caja.getText());
            String palabraDesencriptada = new String(palabra2);
            caja.setText(palabraDesencriptada);
            }  
        });
        
        primaryStage.setTitle("PALABRAS ENCRIPTADAS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }  
}
