/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.gui.App;
import ec.edu.espol.model.Puesto;
import ec.edu.espol.model.util.VentanaTurnos;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author dilan
 */
public class EliminarPuestoFXMLController implements Initializable {

    @FXML
    private ComboBox cbxM;

    private FXMLLoader fxmlloader;
    private Alert a;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbxM.setItems(FXCollections.observableArrayList(Puesto.codigosPuesto("puestos.ser")));
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
    private void regresarP(MouseEvent event) {
        try {
            fxmlloader = App.loadFXMLoad("PuestoFXML");
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
    private void eliminarPuesto(MouseEvent event) throws IOException {
        int codigo = Integer.parseInt(cbxM.getValue().toString());
        Puesto.eliminar(codigo, "puestos.ser");
        cbxM.getItems().clear();
        cbxM.setItems(FXCollections.observableArrayList(Puesto.codigosPuesto("puestos.ser")));
        VentanaTurnos.getVentanaTurnos().show();
    }

}
