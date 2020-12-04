/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model.util;

import ec.edu.espol.gui.App;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author dilan
 */
public class VentanaTurnos {
    private static final Stage stage = new Stage();
    private static Scene scene;

    
    public static  Stage getVentanaTurnos() throws IOException{
         scene = new Scene(App.loadFXML("AtencionFXML"));
         stage.setScene(scene);
         return stage;
    }
   
    
    
    
}
