package fi.lehtoneo.mazesolver.util;

public class Node<T> {
    
    T value;
    Node next;
    
    
    public Node(T t) {
        
        this.value = t;
        this.next = null;
    }
}
