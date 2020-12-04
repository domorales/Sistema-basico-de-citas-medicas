package ec.edu.espol.model.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ec.edu.espol.model.listas.CircularDoublyLinkedList;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author gabrielaramos 
 */
public class Video {
    private String nombre;

    public Video(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
  
 public static CircularDoublyLinkedList<String> leer(String ruta){
        CircularDoublyLinkedList<String> videos = new CircularDoublyLinkedList<>();
        try (FileReader fr = new FileReader(ruta);
            BufferedReader bf = new BufferedReader(fr)) {
            String path;
            while ((path = bf.readLine())!=null){
                videos.addLast(path);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return videos;
    
    }
 
      @Override
    public String toString() {
        return "Video{" + "nombre=" + nombre + '}';
    }
}
