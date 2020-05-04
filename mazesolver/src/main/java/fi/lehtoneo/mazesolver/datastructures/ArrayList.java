package fi.lehtoneo.mazesolver.datastructures;



/**
* List data structure
 * @param <T> type of objects saved to the list
*/
public class ArrayList<T> {
    
    private T[] arr = (T[])new Object[20];
    
    private int lastI;
    private int size;
    
    public ArrayList() {
        lastI = -1;
    }
    
    /**
    * Adds an object at the end of the list
     * @param o is the object added to the list
    */
    public void add(T o) {
        
        if(lastI+1 == arr.length) {
            T[] temp = (T[])new Object[arr.length*2];
            
            for(int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            
            arr = temp;
        }
        
        arr[lastI+1] = o;
        lastI++;

    }
    
    /**
    * Removes an object from the list
     * @param i the index of the object to be removed
    */
    public void remove(int i) {
        
        for(int j = i; j < lastI; j++) {
            arr[j] = arr[j+1];
        }
        arr[lastI] = null;
        size--;
        lastI--;
    }
    
    /**
     * Gets an object from the list
     * @param i the index of the object to be returned
     * @return the object in the place i
     */
    public T get(int i) {
        return arr[i];
    }
    
    
    public int size() {
        return lastI + 1;
    }

}
