package fi.lehtoneo.mazesolver.mazesolving;

import fi.lehtoneo.mazesolver.datastructures.ArrayList;
import fi.lehtoneo.mazesolver.mazegeneration.Maze;
import fi.lehtoneo.mazesolver.mazegeneration.Prim;
import fi.lehtoneo.mazesolver.util.Cell;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ossij
 */
public class BFSTest {
    
    
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
        
        char[][] c2 =   {{'#','#','#','#', '#',},
                        {'#','.','#','.', '#',},
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
        
        maze3 = new Maze(c2);
        start3 = start1;
                
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
            for(int j = 7; j < 15; j++) {
            if(p.getGrid()[i][j] == '.') {
                end2[0] = i;
                end2[1] = j;
                break;
            }
            }
                
        }
        
        maze2 = new Maze(p.getGrid());
        
    }
    
    
    @Test
    public void bfsFindsSomeRouteFromSimpleMaze() {
        BFS bfs = new BFS(maze1.getGrid(), start1, end1);
        
        bfs.solveRoute();
        ArrayList<Cell> route = bfs.getGoBackList();
        
        
        assertEquals(route.size(), 7);
        
        
    }
    
    @Test
    public void bfsFindsSomeRouteFromPrimMaze() {
        BFS bfs = new BFS(maze2.getGrid(), start2, end2);
        bfs.solveRoute();
        ArrayList<Cell> route = bfs.getRouteList();
        
        assertTrue(route.size() >= 2);
        
        
    }
    
    @Test 
    public void InRandomMazeAllOfTheCellsInRouteListArePath() {
        BFS bfs = new BFS(maze2.getGrid(), start2, end2);
        bfs.solveRoute();
        ArrayList<Cell> route = bfs.getRouteList();        
        char h = '.';
        
        for(int i = 0; i < route.size(); i++) {
            assertEquals(maze2.getGrid()[route.get(i).getRow()][route.get(i).getColumn()], h);
        }
        
        
    }
    
    @Test
    public void mazeIsPerfectReturnsTrueWhenMazeIsPerfect() {
        BFS bfs = new BFS(maze1.getGrid(), start1, end1);
        
        assertTrue(bfs.everythingIsReachableInMaze());
    }
    
    
    @Test
    public void mazeIsPerfectReturnsFalseWhenMazeIsNot() {
        BFS bfs = new BFS(maze3.getGrid(), start3, end3);
        
        assertFalse(bfs.everythingIsReachableInMaze());
    }
    
    
    
    
}
