/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.lehtoneo.mazesolver.mazegeneration;

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
        char[][] c =   {{'#','#','#','#', '#',},
                        {'#','.','#','#', '#',},
                        {'#','.','#','#', '#',},
                        {'#','.','#','.', '#',},
                        {'#','.','.','.', '#',},
                        {'#','#','#','.', '#',},
                        {'#','#','#','#', '#',}};
        
        maze = new Maze(c);
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
