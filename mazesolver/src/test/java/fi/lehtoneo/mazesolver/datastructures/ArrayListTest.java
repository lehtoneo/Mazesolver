package fi.lehtoneo.mazesolver.datastructures;

import fi.lehtoneo.mazesolver.datastructures.ArrayList;
import fi.lehtoneo.mazesolver.util.Cell;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ArrayListTest {
    
    @Before
    public void setUp() {
        
        
    }
    
    @Test
    public void addingOfOneWorks() {
        ArrayList<Cell> test1 = new ArrayList();
        
        test1.add(new Cell(1, 2));
        
        assertEquals(test1.size(), 1);
    }
    
    @Test
    public void addingOf20Works() {
        ArrayList<Cell> test2 = new ArrayList();
        
        for(int i = 0; i < 20; i++) {
            test2.add(new Cell(i, i+1));
        }
        
        assertEquals(test2.size(), 20);
    }
    
    @Test
    public void addingOf1000Works() {
        ArrayList<Cell> test3 = new ArrayList();
        
        for(int i = 0; i < 1000; i++) {
            test3.add(new Cell(i, i+1));
        }
        
        assertEquals(test3.size(), 1000);
    }
    
    @Test
    public void gettingWorks1() {
        ArrayList<Cell> test4 = new ArrayList();
        
        for(int i = 0; i < 1000; i++) {
            test4.add(new Cell(i, i+1));
        }
        
        for(int i = 0; i < 1000; i++) {
            
        assertTrue(test4.get(i).equals(new Cell(i, i+1)));
        }
    }
    
    @Test
    public void gettingWorks2() {
        ArrayList<Cell> test5 = new ArrayList();
        Cell c = new Cell(1,1);
        test5.add(c);
        
        assertEquals(c, test5.get(0));
    }
    
    @Test
    public void removingWorks1() {
        ArrayList<Cell> test6 = new ArrayList();
        
        for(int i = 0; i < 10; i++) {
            test6.add(new Cell(i, i));
        }
        
        assertTrue(test6.get(1).equals(new Cell(1,1)));
                
        test6.remove(1);
        
        assertTrue(test6.get(1).equals(new Cell(2,2)));
    }
    
    @Test 
    public void removingWorks2() {
        ArrayList<Cell> test6 = new ArrayList();
        
        for(int i = 0; i < 1000; i++) {
            test6.add(new Cell(i, i));
        }
        
        for(int i = 0; i < 100; i++) {
            test6.remove(300);
        }
        
        assertEquals(test6.size(), 900);
        
        assertTrue(test6.get(300).equals(new Cell(400,400)));
        
    }
    
    
}
