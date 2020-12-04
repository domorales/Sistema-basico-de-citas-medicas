/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.gui.App;
import ec.edu.espol.model.Medico;
import ec.edu.espol.model.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author gabrielaramos
 */
public class RegistroMedicoFXMLController implements Initializable {

    @FXML
    private TextField nombre;
    @FXML
    private TextField apellido;
    @FXML
    private ComboBox cbxS;
    @FXML
    private Text tiempo;
    @FXML
    private AnchorPane video;
    @FXML
    private Label turno1;
    @FXML
    private Label turno3;
    @FXML
    private Label turno2;
    @FXML
    private Label puesto1;
    @FXML
    private Label puesto2;
    @FXML
    private Label puesto3;

    private Alert a;
    private FXMLLoader fxmlloader;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> items = new ArrayList<>();
        items.add("Cardiologo");
        items.add("Pediatra");
        items.add("Traumatologo");
        items.add("Medicina General");
        items.add("Neurologo");
        cbxS.setItems(FXCollections.observableArrayList(items));
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
    private void registrar(MouseEvent event) {
        if (nombre.getText().isEmpty() || apellido.getText().isEmpty() || cbxS.getValue() == null) {
            a = new Alert(Alert.AlertType.INFORMATION, "CAMPOS VACIOS");
            a.show();
        } else {
            Medico medico = new Medico(nombre.getText(), apellido.getText(), cbxS.getValue().toString());
            Map<String, Usuario> medicos = Medico.leer("medicos.ser");
            medicos.put(medico.getNombres(), medico);
            Medico.guardar(medicos, "medicos.ser");
        }
        nombre.clear();
        apellido.clear();
        cbxS.setValue("");
    }

    @FXML
    private void puesto(MouseEvent event) {
        try {
            fxmlloader = App.loadFXMLoad("PuestoFXML");
            App.setRoot(fxmlloader);
        } catch (IOException ex) {
            a = new Alert(Alert.AlertType.INFORMATION, "No se puede mostrar");
            a.show();
        }
    }

}
