package ec.edu.espol.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dilan
 */
public class Puesto implements Serializable {
    private int codigo;
    private  LinkedList<Turno> turnos;
    private Medico medico;
    private static final long serialVersionUID = 1000L;

    public Puesto(int codigo, Medico medico) {
        this.codigo = codigo;
        this.turnos = new LinkedList<>();
        this.medico = medico;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LinkedList<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(LinkedList<Turno> turnos) {
        this.turnos = turnos;
    }

   

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    public static void guardar(Queue<Puesto> cola,String archivo){
        try(ObjectOutputStream es = new ObjectOutputStream(new FileOutputStream(archivo))){
                    es.writeObject(cola);
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    
    }

    public static Queue<Puesto> leer(String archivo){
        Queue<Puesto> puestos=new LinkedList<>();
        try(ObjectInputStream es = new ObjectInputStream(new FileInputStream(archivo))){
            puestos=(Queue<Puesto>)es.readObject();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        } 
        return puestos;
      
    }
    
    public static ArrayList<String> codigosPuesto(String archivo){
        Queue<Puesto> puestos = leer(archivo);
        ArrayList<String> codigo = new ArrayList<>();
        int tamanio = puestos.size();
        for (int i = 0 ; i< tamanio; i++){
            Puesto p = puestos.poll();
            codigo.add(p.codigo+"");
        }   
        return codigo;
    }
    
    public static void eliminar(int codigo, String arhivo){
        Map<String, Usuario> medicos = Medico.leer("medicos.ser");
        Queue<Puesto> puestos =  Puesto.leer(arhivo);
        for (int i = 0 ; i< puestos.size();i++){
            Puesto  p = puestos.poll();
            if(p.codigo == codigo){                
                Medico m = (Medico)medicos.get(p.medico.nombres);
                m.setPuesto(0); 
            }
            else {
                puestos.offer(p);    
            }
        }
        Medico.guardar(medicos, "medicos.ser");
        guardar(puestos, "puestos.ser");
    }
    
    public static int obtenerCod(String ruta){
        Queue<Puesto> puestos = leer(ruta);
        return  puestos.size()+1;   
    }

    @Override
    public String toString() {
        return "Puesto{" + "codigo=" + codigo + ",medico=" + medico + '}';
    }
    
    
 
}

    