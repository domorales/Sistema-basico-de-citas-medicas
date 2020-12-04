/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

/**
 *
 * @author gabrielaramos
 */
public class Paciente extends Usuario {
    private int edad;
    private char genero;
    private Sintoma sintoma;
    private static final long serialVersionUID = 1L;

    public Paciente(String nombre, String apellido, int edad, char genero, Sintoma sintoma) {
        super(nombre,apellido);
        this.edad = edad;
        this.genero = genero;
        this.sintoma = sintoma;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public Sintoma getSintoma() {
        return sintoma;
    }

    public void setSintoma(Sintoma sintoma) {
        this.sintoma = sintoma;
    }

    

    
    
}
