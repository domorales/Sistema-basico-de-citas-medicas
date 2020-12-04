/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.gui.App;
import ec.edu.espol.model.Puesto;
import ec.edu.espol.model.Turno;
import java.io.IOException;
import java.net.URL;
import java.util.Queue;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author dilan
 */
public class RecetarFXMLController implements Initializable {

    @FXML
    private Label turno;
    @FXML
    private Label medico;
    @FXML
    private Label paciente;

    private Queue<Puesto> puestos = Puesto.leer("puestos.ser");
    private Puesto p;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        p = (Puesto) puestos.poll();
        p.getTurnos().sort((Turno t1, Turno t2)
                -> t1.getPaciente().getSintoma().getPrioridad() - t2.getPaciente().getSintoma().getPrioridad());
        paciente.setText(p.getTurnos().getFirst().getPaciente().getNombres() + " " + p.getTurnos().getFirst().getPaciente().getApellidos());
        medico.setText(p.getTurnos().getFirst().getPuesto().getMedico().getNombres());
        turno.setText(p.getTurnos().getFirst().getCodigo());
        
    }

    @FXML
    private void registrar(MouseEvent event) {      
        try {
            p.getTurnos().removeFirst();
            puestos.offer(p);
            Puesto.guardar(puestos, "puestos.ser");
            FXMLLoader fxmlloader1 = App.loadFXMLoad("PrincipalFXML");
            App.setRoot(fxmlloader1);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
