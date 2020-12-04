/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gabrielaramos
 */
public class Sintoma  implements Serializable{
    private String nombre;
    private int prioridad;
    private static final long serialVersionUID = 3L;

    public Sintoma(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }
    
    public static void guardar(Map<String, Sintoma> mapa, String archivo) {
        try (ObjectOutputStream es = new ObjectOutputStream(new FileOutputStream(archivo))) {

            es.writeObject(mapa);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static Map<String, Sintoma> leer(String archivo){
        Map<String , Sintoma> sintomas = new HashMap<>();
        try(ObjectInputStream es = new ObjectInputStream(new FileInputStream(archivo))){
            sintomas=(Map<String , Sintoma> )es.readObject(); 
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        } 
        return sintomas;
      
    }        

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    
      
    @Override
    public String toString() {
        return nombre + "|" + prioridad;
    }
    

    
}
