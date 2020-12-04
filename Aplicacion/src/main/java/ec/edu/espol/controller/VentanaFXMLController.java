/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.gui.App;
import ec.edu.espol.model.Paciente;
import ec.edu.espol.model.Puesto;
import ec.edu.espol.model.Sintoma;
import ec.edu.espol.model.Turno;
import ec.edu.espol.model.Usuario;
import ec.edu.espol.model.util.VentanaTurnos;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author dilan
 */
public class VentanaFXMLController implements Initializable {

    @FXML
    private TextField nombre;
    @FXML
    private TextField apellido;
    @FXML
    private TextField edad;
    @FXML
    private ComboBox cbxG;
    @FXML
    private ComboBox cbxS;
    private FXMLLoader fxmlloader;
    private final Queue<Puesto> puestos = Puesto.leer("puestos.ser");
    private final Map<String, Sintoma> sintomas = Sintoma.leer("sintomas.ser");
    private final LinkedList<Turno> turnos = Turno.leer("turnos.ser");
    private Alert a;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        turnos.sort((Turno t1, Turno t2)
                -> t2.getPaciente().getSintoma().getPrioridad() - t1.getPaciente().getSintoma().getPrioridad());
        ArrayList<String> items = new ArrayList<>();
        edad.setTextFormatter(new TextFormatter<>(change -> (change.getControlNewText().matches("(-?([0-9]*+[.])?[0-9]*)")) ? change : null));
        items.add("M");
        items.add("F");
        cbxG.setItems(FXCollections.observableArrayList(items));
        items.clear();
        items.add("Fiebre");
        items.add("Desmayo");
        items.add("Resfriado");
        items.add("Congestión nasal");
        items.add("Dolor de estómago");
        items.add("Dolor de cabeza");
        items.add("Dolor de pecho");
        items.add("Escalofrío");
        items.add("tos");
        items.add("Infarto");
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
    private void puesto(MouseEvent event) {
        try {
            fxmlloader = App.loadFXMLoad("PuestoFXML");
            App.setRoot(fxmlloader);
            PuestoFXMLController controlador = fxmlloader.getController();

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
            RegistroMedicoFXMLController controlador = fxmlloader.getController();

        } catch (IOException ex) {
            a = new Alert(Alert.AlertType.INFORMATION, "No se puede mostrar");
            a.show();
        }

    }

    @FXML
    private void registrar(MouseEvent event) throws InterruptedException {
        Puesto p = puestos.poll();
        if (nombre.getText().isEmpty() || cbxG.getValue() == null || apellido.getText().isEmpty()
                || edad.getText().isEmpty() || cbxS.getValue() == null) {
            a = new Alert(Alert.AlertType.INFORMATION, "CAMPOS VACIOS");
            a.show();
        } else {
            Paciente paciente = new Paciente(nombre.getText(), apellido.getText(), Integer.parseInt(edad.getText()), cbxG.getValue().toString().charAt(0), sintomas.get(cbxS.getValue().toString()));
            int tamaño = p.getTurnos().size();
            char inicial1 = p.getMedico().getNombres().charAt(0);
            char inicial2 = p.getMedico().getApellidos().charAt(0);
            String codTurno = inicial1 + "" + inicial2 + tamaño;
            Turno turno = new Turno(codTurno, p, paciente);
            p.getTurnos().add(turno);
            turnos.add(turno);
            Turno.guardar(turnos, "turnos.ser");
            Map<String, Usuario> pacientes = Paciente.leer("pacientes.ser");
            pacientes.put(paciente.getNombres(), paciente);
            Paciente.guardar(pacientes, "pacientes.ser");
            puestos.offer(p);
            Puesto.guardar(puestos, "puestos.ser");
            a = new Alert(Alert.AlertType.CONFIRMATION, paciente.getNombres()+" SE LE ASIGNA EL TURNO: "+ codTurno);
            a.show();
            try {
                VentanaTurnos.getVentanaTurnos().show();
            } catch (IOException ex) {
                a = new Alert(Alert.AlertType.INFORMATION, "No se puede mostrar");
                a.show();
            }

        }

    }

}
