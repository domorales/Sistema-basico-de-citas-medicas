package ec.edu.espol.model.listas;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author dilan
 */
public class ErrorEmptyList extends Exception {
    int tam;
    public ErrorEmptyList(int tam){
        this.tam=tam;
    }    
    
    
    @Override
    public String toString(){
        return "Excepcion lista vacía " + tam;
    }     
    
}
