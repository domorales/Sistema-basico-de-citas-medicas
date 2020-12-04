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
public class Usuario implements Serializable {

    protected String nombres;
    protected String apellidos;
    private static final long serialVersionUID = 5L;

    public Usuario(String nombres, String apellidos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public static void guardar(Map<String, Usuario> mapa, String archivo) {
        try (ObjectOutputStream es = new ObjectOutputStream(new FileOutputStream(archivo))) {
            es.writeObject(mapa);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    
    public static Map<String, Usuario> leer(String archivo) {
        Map<String, Usuario> usuarios = new HashMap<>();
        try (ObjectInputStream es = new ObjectInputStream(new FileInputStream(archivo))) {
            usuarios = (Map<String, Usuario>) es.readObject();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return usuarios;

    }

}
