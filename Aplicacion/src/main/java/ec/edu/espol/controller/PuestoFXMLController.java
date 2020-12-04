/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.gui.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author dilan
 */
public class PuestoFXMLController implements Initializable {

    private Alert a;
    private FXMLLoader fxmlloader;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void regresar(MouseEvent event) {
        try {
            fxmlloader = App.loadFXMLoad("PrincipalFXML");
            App.setRoot(fxmlloader);
        } catch (IOException ex) {
            a = new Alert(Alert.AlertType.INFORMATION, "ERROR");
            a.show();
        }
    }

    @FXML
    private void registroP(MouseEvent event) {
        try {
            fxmlloader = App.loadFXMLoad("VentanaFXML");
            App.setRoot(fxmlloader);
        } catch (IOException ex) {
            a = new Alert(Alert.AlertType.INFORMATION, "No se puede mostrar");
            a.show();
        }
    }

    @FXML
    private void registroM(MouseEvent event) {
        try {
            fxmlloader = App.loadFXMLoad("RegistroMedicoFXML");
            App.setRoot(fxmlloader);
        } catch (IOException ex) {
            a = new Alert(Alert.AlertType.INFORMATION, "No se puede mostrar");
            a.show();
        }
    }

    @FXML
    private void crearPuesto(MouseEvent event) {
        try {
            fxmlloader = App.loadFXMLoad("CrearPuestoFXML");
            App.setRoot(fxmlloader);
        } catch (IOException ex) {
            a = new Alert(Alert.AlertType.INFORMATION, "No se puede mostrar");
            a.show();
        }

    }

    @FXML
    private void eliminarPuesto(MouseEvent event) {
        try {
            fxmlloader = App.loadFXMLoad("EliminarPuestoFXML");
            App.setRoot(fxmlloader);
        } catch (IOException ex) {
            a = new Alert(Alert.AlertType.INFORMATION, "No se puede mostrar");
            a.show();
        }

    }

}
