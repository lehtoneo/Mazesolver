/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.lehtoneo.mazesolver.mazesolving;

import fi.lehtoneo.mazesolver.datastructures.ArrayList;
import fi.lehtoneo.mazesolver.mazegeneration.Maze;
import fi.lehtoneo.mazesolver.mazegeneration.Prim;
import fi.lehtoneo.mazesolver.mazesolving.WallFollower;
import fi.lehtoneo.mazesolver.util.Cell;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ossij
 */

public class WallFollowerTest {
    Maze maze1;
    int[] start1 = new int[2];
    int[] end1 = new int[2];
    ArrayList<Cell> routeList1;
    
    Maze maze2;
    int[] start2 = new int[2];
    int[] end2 = new int[2];
    ArrayList<Cell> routeList2;
    
    
    
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
        
        WallFollower wf1 = new WallFollower(maze1.getGrid(), start1, end1);
        wf1.solve();
        routeList1 = wf1.getRouteList();
                
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
            for(int j = 10; j < 15; j++) {
            if(p.getGrid()[i][j] == '.') {
                end2[0] = i;
                end2[1] = j;
                break;
            }
            }
                
        }
        
        maze2 = new Maze(p.getGrid());
        
        WallFollower wf2 = new WallFollower(maze2.getGrid(), start2, end2);
        wf2.solve();
        routeList2 = wf2.getRouteList();
    }
    
    @Test
    public void InSimpleMazewFFindsSomePath() {
        
        assertEquals(routeList1.size( ), 7);
        
    }
    
    @Test
    public void InSimpleMzewFPathIsExpected() {
        
        ArrayList<Cell> routeShouldBe = new ArrayList();
        routeShouldBe.add(new Cell(1, 1));
        routeShouldBe.add(new Cell(2, 1));
        routeShouldBe.add(new Cell(3, 1));
        routeShouldBe.add(new Cell(4, 1));
        routeShouldBe.add(new Cell(4, 2));
        routeShouldBe.add(new Cell(4, 3));
        routeShouldBe.add(new Cell(5, 3));
        
        for(int i = 0; i < routeList1.size(); i++) {
            assertTrue(routeList1.get(i).equals(routeShouldBe.get(i)));
        }
    }

    @Test 
    public void InRandomMazeLastCellInRoutelistIsTarget() {
        
        
        assertEquals(routeList2.get(routeList2.size()-1).getRow(), end2[0]);
        assertEquals(routeList2.get(routeList2.size()-1).getColumn(), end2[1]);
        
    }
    
    
    @Test 
    public void InRandomMazeAllOfTheCellsInRouteListArePath() {
        
        char h = '.';
        
        for(int i = 0; i < routeList2.size(); i++) {
            assertEquals(maze2.getGrid()[routeList2.get(i).getRow()][routeList2.get(i).getColumn()], h);
        }
        
        
    }
    
    
    @Test
    public void InRandomMazeThePathCanBeTaken() {
        
        for (int i = 0; i < routeList2.size() - 1; i++) {
            Cell curr = routeList2.get(i);
            int currR = curr.getRow();
            int currC = curr.getColumn();
            Cell next = routeList2.get(i+1);
            int nextR = next.getRow();
            int nextC = next.getColumn();
            
            if((currR + 1 == nextR && currC == nextC) || (currR - 1 == nextR && currC == nextC)) {
                assertTrue(true);
            } else if ((currR == nextR && currC == nextC + 1) || (currR == nextR && currC == nextC - 1)) {
                assertTrue(true);
            } else {
                assertTrue(false);
            }
        }
    }
        
    
}
