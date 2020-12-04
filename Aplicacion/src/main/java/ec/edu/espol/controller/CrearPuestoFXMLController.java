/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.gui.App;
import ec.edu.espol.model.Medico;
import ec.edu.espol.model.Puesto;
import ec.edu.espol.model.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Queue;
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
 * @author gabrielaramos
 */
public class CrearPuestoFXMLController implements Initializable {

    @FXML
    private ComboBox cbxM;
    private Alert a;
    private FXMLLoader fxmlloader;

    private Map<String, Usuario> medicos = Medico.leer("medicos.ser");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbxM.setItems(FXCollections.observableArrayList(Medico.nombresMedicos()));
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
    private void crearPuesto(MouseEvent event) {
        String nombre = cbxM.getValue().toString();
        if (nombre == null) {
            a = new Alert(Alert.AlertType.INFORMATION, "MEDICO NO SELECCIONADO");
            a.show();
        } else {
            Medico medico = (Medico) medicos.get(nombre);
            Puesto p = new Puesto(Puesto.obtenerCod("puestos.ser"), medico);
            medico.setPuesto(p.getCodigo());
            Queue<Puesto> puestos = Puesto.leer("puestos.ser");
            puestos.offer(p);
            Puesto.guardar(puestos, "puestos.ser");
            Medico.guardar(medicos, "medicos.ser");
            cbxM.getItems().clear();
            cbxM.setItems(FXCollections.observableArrayList(Medico.nombresMedicos()));
        }
        
    }

}
