package ec.edu.espol.model.listas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Iterator;

/**
 *
 * @author dilan
 */
public class CircularDoublyLinkedList <E> implements List<E> , Iterable<E> {
    
    private Node<E> first;
    private Node<E> last;
    private int current;
    
    public class Node<E>{
        private E data;
        private Node<E> next;
        private Node<E> previous;
        public Node(E data) {
            this.data = data;
        }
        
    }
    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>(){
            
            Node<E> i =first;
            @Override
            public boolean hasNext() {
                return i!=null;
            }

            @Override
            public E next() {
                E temp = i.data;
                i=i.next;
                return temp;
            }
        
        };
        return it;
    }

    @Override
    public boolean addFirst(E element) {
        if(element== null) return false;
        Node<E> nodo = new Node<>(element);
        if(this.isEmpty()) first =last = nodo;
        else{
            nodo.previous= last;
            last.next =nodo;
            nodo.next = first;
            first.previous=nodo;
            first= nodo;
        }
        current++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        if(element== null) return false;
        Node<E> nodo = new Node<>(element);
        if(this.isEmpty()) first =last = nodo;
        else{
            nodo.next= first;
            first.previous =nodo;
            nodo.previous = last;
            last.next=nodo;
            last= nodo;
        }
        current++;
        return true;
    }

    @Override
    public boolean addIndex(E element, int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        return current;
    }

    @Override
    public boolean contains(E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeFirst() {
        if(this.isEmpty()) return false;
        if(first == last){
            first.data=null;
            first = last= null;
        }
        else{
            first.next=first.previous;
            last.next=first.next;
            first.data=null;
            first=first.next;
        }
        current--;
        return true;
    }

    @Override
    public boolean removeLast() {
        if(this.isEmpty()) return false;
        if(first == last){
            first.data=null;
            first = last= null;
        }
        else{
            last.previous=last.next;
            first.previous=last.previous;
            last.data=null;
            last=last.previous;
        }
        current--;
        return true;
    }

    @Override
    public boolean removeIndex(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E getFrist() {
        return first.data;
    }

    @Override
    public E getLast() {
        return last.data;
    }

    @Override
    public boolean isEmpty() {
        return first == null && last==null;
    }

    @Override
    public String toString(){
        Node<E> nodo=first;
        StringBuilder data = new StringBuilder();
        data.append("[");
        for(int i=0; i<current-1;i++){
            data.append(nodo.data);
            data.append(",");
            nodo= nodo.next;
        }
        data.append(last.data);
        data.append("]");
        return data.toString();
    }
    
    @Override
    public boolean equals(Object ob){
        if (ob.getClass()!= this.getClass() || ob==null) return false;
        if(ob==this)return true;
        CircularDoublyLinkedList<E> l= (CircularDoublyLinkedList<E>) ob;
        if (this.current!=l.current) return false;
        else{
            Node<E> nodo=first;
             Node<E> nodoL=l.first;
            for(int i=0; i<current-1;i++){
                if(nodo.data!=nodoL.data) return false;
                nodo= nodo.next;
                nodoL= nodoL.next;   
            }
        }
        return true;
    }
    
}
