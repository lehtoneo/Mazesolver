/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.lehtoneo.mazesolver.mazesolving;

import fi.lehtoneo.mazesolver.datastructures.ArrayList;
import fi.lehtoneo.mazesolver.mazegeneration.Maze;
import fi.lehtoneo.mazesolver.mazegeneration.Prim;
import fi.lehtoneo.mazesolver.util.Cell;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;


public class TremauxsTest {

    Maze maze1;
    int[] start1 = new int[2];
    int[] end1 = new int[2];
    
    Maze maze2;
    int[] start2 = new int[2];
    int[] end2 = new int[2];
    
    Maze maze3;
    int[] start3 = new int[2];
    int[] end3 = new int[2];
    
    @Before
    public void setUp() {
        char[][] c =   {{'#','#','#','#', '#',},
                        {'#','.','#','#', '#',},
                        {'#','.','#','#', '#',},
                        {'#','.','#','.', '#',},
                        {'#','.','.','.', '#',},
                        {'#','#','#','.', '#',},
                        {'#','#','#','#', '#',}};
        
        
        
        maze1 = new Maze(c);
        start1[0] = 1;
        start1[1] = 1;
        end1[0] = 5;
        end1[1] = 3;
        
        
                
        Prim p = new Prim(21, 21);
        
        p.generate();
        for(int i = 0; i < 21; i++) {
            for(int j = 1; j < 3; j++) {
            if(p.getGrid()[i][j] == '.') {
                start2[0] = i;
                start2[1] = j;
                break;
            }
            }
                
        }
        
        for(int i = 0; i < 21; i++) {
            for(int j = 7; j < 21; j++) {
            if(p.getGrid()[i][j] == '.') {
                end2[0] = i;
                end2[1] = j;
                break;
            }
            }
                
        }
        
        maze2 = new Maze(p.getGrid());
        
        p = new Prim(51,51);
                p.generate();
        for(int i = 41; i < 51; i++) {
            for(int j = 41; j < 51; j++) {
            if(p.getGrid()[i][j] == '.') {
                start3[0] = i;
                start3[1] = j;
                break;
            }
            }
                
        }
        
        for(int i = 1; i < 10; i++) {
            for(int j = 1; j < 10; j++) {
            if(p.getGrid()[i][j] == '.') {
                end3[0] = i;
                end3[1] = j;
                break;
            }
            }
                
        }
        
        maze3 = new Maze(p.getGrid());
        
    }
    
    
    @Test
    public void tremauxsFindsSomeRouteFromSimpleMaze() {
        Tremauxs t = new Tremauxs(maze1.getGrid(), start1, end1);
        
        t.solve();
        ArrayList<Cell> route = t.getRouteList();
        
        
        assertTrue(route.size() >= 7);
        
        
    }
    
    @Test
    public void tremauxsFindSomeRouteFromSmallPrimMaze() {
        Tremauxs t = new Tremauxs(maze2.getGrid(), start2, end2);
        
        t.solve();
        
        assertTrue(t.getRouteList().size() >= 2);
    }
    
    
    
    @Test
    public void tremauxsFindSomeRouteFromBigPrimMaze() {
        Tremauxs t = new Tremauxs(maze3.getGrid(), start3, end3);
        
        t.solve();
        
        assertTrue(t.getRouteList().size() >= 2);
    }
    
    
    
    
}
