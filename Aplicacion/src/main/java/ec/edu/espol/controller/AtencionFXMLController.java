/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controller;

import ec.edu.espol.model.util.Video;
import ec.edu.espol.model.Puesto;
import ec.edu.espol.model.listas.CircularDoublyLinkedList;
import ec.edu.espol.model.util.Reloj;
import ec.edu.espol.model.Turno;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Queue;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * FXML Controller class
 *
 * @author gabrielaramos
 */
public class AtencionFXMLController implements Initializable {

    @FXML
    private Text tiempo;
    @FXML
    private AnchorPane video;
    @FXML
    private MediaView ventanaVideo;
    @FXML
    private VBox vBoxTurno;
    @FXML
    private VBox vBoxPuesto;
    
    private Reloj reloj;
    private final CircularDoublyLinkedList<String> videos = Video.leer("videos.txt");
    private final Iterator it = videos.iterator();
    private Queue<Puesto> puestos = Puesto.leer("puestos.ser");
    private Label turno;
    private Label puesto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        reloj = new Reloj(tiempo);
        reloj.start();
        reproducirVideos(it);
        vBoxTurno.getChildren().clear();
        vBoxPuesto.getChildren().clear();
        while(!puestos.isEmpty()){
            Puesto p = (Puesto) puestos.poll();
            p.getTurnos().sort((Turno t1, Turno t2)
                -> t1.getPaciente().getSintoma().getPrioridad() - t2.getPaciente().getSintoma().getPrioridad());
            if(p.getTurnos().size()!=0){
            turno = new Label(p.getTurnos().getFirst().getCodigo());
            turno.setStyle("-fx-background-color: SandyBrown");
            turno.setTextAlignment(TextAlignment.CENTER);
            turno.setMinSize(129, 40);
            vBoxTurno.getChildren().add(turno);
            puesto = new Label(String.valueOf(p.getCodigo()));
            puesto.setStyle("-fx-background-color: LightSalmon");
            puesto.setTextAlignment(TextAlignment.CENTER);
            puesto.setMinSize(129, 40);
            vBoxPuesto.getChildren().add(puesto); 
            }
        }
    }
    
     public void reproducirVideos(Iterator it) {
        String url = it.next().toString();
        Media media = new Media(Paths.get(url).toUri().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setAutoPlay(true);
        player.setVolume(0);
        player.setOnEndOfMedia(() -> {
            reproducirVideos(it);
        });
        ventanaVideo.setMediaPlayer(player);  
    }
    
    public Reloj reloj(){   
        return reloj;
    }
}
