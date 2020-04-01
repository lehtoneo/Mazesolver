package fi.lehtoneo.mazesolver.datastructures;

import fi.lehtoneo.mazesolver.datastructures.LinkedList;
import fi.lehtoneo.mazesolver.util.Cell;
import static org.junit.Assert.*;
import org.junit.Test;

import org.junit.Before;


public class LinkedListTest {
    
    
    
    @Test
    public void sizeIncreasesWhenAddingObjects() {
        LinkedList<Integer> testList = new LinkedList<>();
        
        testList.add(1);
        testList.add(3);
        
        assertEquals(testList.size(), 2);
    }
    
    @Test
    public void getReturnsCorrectObjectFromMiddleOfList() {
        LinkedList<Integer> testList = new LinkedList<>();
        
        testList.add(1);
        testList.add(3);
        testList.add(9);
        int shouldBe = testList.get(1);
        
        assertEquals(shouldBe, 3);
        
    }
    
    @Test
    public void getReturnsCorrectObjectFromBeginningOfList() {
        LinkedList<Integer> testList = new LinkedList<>();
        
        testList.add(1);
        testList.add(3);
        testList.add(9);
        int shouldBe = testList.get(0);
        
        assertEquals(shouldBe, 1);
        
    }

    
    
    @Test
    public void getReturnsCorrectObjectFromEndOfList() {
        LinkedList<Integer> testList = new LinkedList<>();
        
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);
        testList.add(6);
        
        int shouldBe = testList.get(5);
        
        assertEquals(shouldBe, 6);
        
    }
    
    @Test
    public void removingAnObjectInTheMiddleRemovesObject() {
        LinkedList<Integer> testList = new LinkedList<>();
        
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);
        testList.add(6);
        
        testList.remove(3);
        int shouldBe = testList.get(3);
        assertEquals(shouldBe, 5);
        assertEquals(testList.size(), 5);
    }
    
    @Test
    public void removingLastRemovesObject() {
        LinkedList<Integer> testList = new LinkedList<>();
        
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);
        testList.add(6);
        
        testList.remove(testList.size() - 1);
        int shouldBe = testList.get(testList.size() - 1);
        assertEquals(shouldBe, 5);
        assertEquals(testList.size(), 5);
    }
    
    @Test
    public void removingFirstRemovesObject() {
        LinkedList<Integer> testList = new LinkedList<>();
        
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);
        testList.add(6);
        
        testList.remove(0);
        int shouldBe = testList.get(0);
        
        assertEquals(shouldBe, 2);
        assertEquals(testList.size(), 5);
    }
    
    
    @Test
    public void popWorks() {
        LinkedList<Cell> testList = new LinkedList<>();
        
        testList.add(new Cell(1,1));
        testList.add(new Cell(1,2));
        
        Cell c = testList.pop();
        
        
        
        assertTrue(c.equals(new Cell(1,1)));
        assertEquals(testList.size(), 1);
    }
        

    
    
}
