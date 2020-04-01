package fi.lehtoneo.mazesolver.util;

public class Node<T> {
    
    public T value;
    public Node next;
    
    
    public Node(T t) {
        
        this.value = t;
        this.next = null;
    }
}
