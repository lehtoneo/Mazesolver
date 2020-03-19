/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.lehtoneo.mazesolver.domain;

/**
 *
 * @author ossij
 */

import static org.junit.Assert.*;
import org.junit.Test;

import org.junit.Before;
public class MazeTest {
    
    private Maze maze;
    
    @Before 
    public void setUp() {
        maze = new Maze(10,10);
    }
    
    @Test
    public void outerBordersAreWall() {
        char[][] grid = maze.getGrid();
        
        for(int j = 0; j < grid[0].length; j++) {
            assertEquals(grid[0][j], '#');
            assertEquals(grid[grid.length-1][j], '#');
        }
        
        for(int i = 1; i < grid.length; i++) {
            assertEquals(grid[i][0], '#');
            assertEquals(grid[i][grid[0].length-1], '#');
        }
    }
    
    @Test
    public void toStringWorks() {
        char[][] c = {{'#', '#'},
                      {'.', '#'}};
        
        System.out.println(c[0][0]);
        System.out.println(c[1][0]);
        Maze m = new Maze(c);
        String expected = "##\n.#";
        assertEquals(expected, m.toString());
    }
    
}
