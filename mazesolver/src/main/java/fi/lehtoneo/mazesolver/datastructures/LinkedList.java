package fi.lehtoneo.mazesolver.datastructures;

import fi.lehtoneo.mazesolver.util.Node;

/**
* Linkedlist data structure
 * @param <T> type of objects saved to the list
*/
public class LinkedList<T> {
    
    private Node first;
    private Node last;
    private int size;
    
    public LinkedList() {
        first = null;
        size = 0;
    }
    
    /**
    * Adds an object at the end of the list
     * @param t is the object added to the list
    */
    public void add(T t) {
        
        size++;
        Node<T> n = new Node(t);
        
        if (first == null) {
            first = n;
            last = n;
            return;
        }
        
        last.next = n;
        last = n;
        
        
    }
    
    /**
    * Adds an object at the beginning of the list
     * @param t is the object added to the list
    */
    public void push(T t) {
        size++;
        
        Node<T> n = new Node(t);
        
        if (first == null) {
            first = n;
            last = n;
            return;
        }
        n.next = first;
        first = n;
        
    }
    
    /**
    * Removes on object from the list
     * @param i index of the object to be removed
    */
    public void remove(int i) {
        int j = 0;
        
        if (i >= size) {
            throw new IndexOutOfBoundsException();
        }
        
        
        if (i == 0) {
            removeFirst();
            return;
        }
        
        if (i == size - 1) {
            removeLast();
            return;
        }
        
        
        Node<T> curr = first;
        
        while (j < i - 1) {
            curr = curr.next;
            j++;
        }
        
        
        
        Node<T> toLink = curr;
        curr = curr.next;
        curr = curr.next;
        toLink.next = curr;
        
        size--;
        
    }
    
    /**
    * Removes first object from the list
     * 
    */
    public void removeFirst() {
        
        first = first.next;
        size--;
        
    }
    /**
    * Removes and returns first object from the list
     * @return first object from the list
    */
    public T pop() {
        T toReturn = (T) first.value;
        first = first.next;
        size--;
        return toReturn;
    }
    
    /**
    * Removes last object from the list
     *
    */
    public void removeLast() {
        int j = 0;
        Node<T> curr = first;
        
        while (j < size - 2) {
            curr = curr.next;
            j++;
        }
        
        curr.next = null;
        last = curr;
        
        size--;
    }

    /**
    * Gets an object from the list
     * @param i index of the object to be returned
     * @return object with index i
    */
    public T get(int i) {
        
        int j = 0;
        if (i >= size) {
            throw new IndexOutOfBoundsException();
        }
        
        Node<T> curr = first;
        if (i == size - 1) {
            return (T) last.value;
        }
        while (j < i) {
            curr = curr.next;
            j++;
        }
        
        return curr.value;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    
    
}
