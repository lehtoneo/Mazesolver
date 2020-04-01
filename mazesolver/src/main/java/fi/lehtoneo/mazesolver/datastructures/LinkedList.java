package fi.lehtoneo.mazesolver.datastructures;

import fi.lehtoneo.mazesolver.util.Node;

public class LinkedList<T> {
    
    private Node first;
    private Node last;
    private int size;
    
    public LinkedList() {
        first = null;
        size = 0;
    }
    
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
    
    
    public void removeFirst() {
        
        first = first.next;
        size--;
        
    }
    
    public T pop() {
        T toReturn = (T) first.value;
        first = first.next;
        size--;
        return toReturn;
    }
    
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
