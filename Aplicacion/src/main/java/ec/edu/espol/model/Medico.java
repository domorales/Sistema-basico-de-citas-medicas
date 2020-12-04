/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author gabrielaramos
 */
public class Medico extends Usuario{
    private String especialidad;
    private int  puesto;
    private static final long serialVersionUID = 100L;

    public Medico(String nombres, String apellidos, String especialidad) {
        super(nombres,apellidos);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }



    public static ArrayList<String> nombresMedicos() {
        Map<String, Usuario> medicos = Usuario.leer("medicos.ser");
        ArrayList<String> nombres = new ArrayList<>();
        Iterator it = medicos.keySet().iterator();
        while (it.hasNext()) {
            String nombre= (String)it.next();
            Medico m = (Medico) medicos.get(nombre);
            if(m.getPuesto()==0){
            nombres.add(nombre);     
            }
        }
        return nombres;
    } 

    @Override
    public String toString() {
        return "Medico{"+this.nombres+" "+this.apellidos+" " + "especialidad=" + especialidad + ", puesto=" + puesto + '}';
    }
    
    
    
    
    
      
}
