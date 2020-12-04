/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model.util;

import java.time.LocalDateTime;
import javafx.application.Platform;
import javafx.scene.text.Text;


/**
 *
 * @author dilan
 */
public class Reloj extends Thread{
    private boolean estado;
    private Text tiempo;

    public Reloj(Text tiempo) {
        this.estado = true;
        this.tiempo = tiempo;
    }

    @Override
    public void run() {
        while (estado) {
                Platform.runLater(() -> {
                    LocalDateTime locaDate = LocalDateTime.now();
                    int hours = locaDate.getHour();
                    int minutes = locaDate.getMinute();
                    int seconds = locaDate.getSecond();
                    tiempo.setText(hours + ":" + minutes + ":" + seconds);
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }

    }
    
    public void stopHilo(){
        this.estado = false;
    }
    
    
}
