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
public interface List<E>{
    boolean addFirst(E element);
    boolean addLast(E element);
    boolean addIndex(E element, int index);
    E get (int index);
    int size();
    boolean contains(E element);
    boolean removeFirst();
    boolean removeLast();
    boolean removeIndex(int index);
    E getFrist();
    E getLast();   
    boolean isEmpty();
}
