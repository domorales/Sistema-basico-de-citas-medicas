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
import java.util.LinkedList;

/**
 *
 * @author gabrielaramos
 */
public class Turno implements Serializable {
    private String codigo;
    private Puesto puesto;
    private Paciente paciente;
    private static final long serialVersionUID = 4L;
    
    public Turno(String codigo, Puesto puesto, Paciente paciente) {
        this.codigo = codigo;
        this.puesto = puesto;
        this.paciente = paciente;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }


    public static void guardar(LinkedList<Turno> cola,String archivo){
        try(ObjectOutputStream es = new ObjectOutputStream(new FileOutputStream(archivo))){
            
                es.writeObject(cola);        
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());

        }
    }
    
    public static LinkedList<Turno> leer(String archivo) {
        LinkedList<Turno> lista = new LinkedList<>();
        try(ObjectInputStream es = new ObjectInputStream(new FileInputStream(archivo))){
                lista=(LinkedList<Turno>)es.readObject();  
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        } 
        return lista;
    }    

    
    @Override
    public String toString() {
        return "Turno{" + "codigo=" + codigo +"paciente=" + paciente + '}';
    }
    
    
    
}
