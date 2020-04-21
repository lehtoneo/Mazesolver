
package fi.lehtoneo.mazesolver.mazegeneration;

import fi.lehtoneo.mazesolver.mazesolving.BFS;
import static org.junit.Assert.*;
import org.junit.Test;

import org.junit.Before;
/**
 *
 * @author ossij
 */
public class PrimTest {
    private Prim prim;
    private Prim prim2;
    @Before
    public void setUp() {
        this.prim = new Prim(10,10);
        this.prim2 = new Prim(21,21);
    }
    
    
    @Test
    public void afterInitEverythingIsWall() {
        prim.init();
        
        
        for (int i = 0; i < this.prim.getGrid().length; i++) {
            for (int j = 0; j < this.prim.getGrid()[0].length; j++) {
                assertEquals(this.prim.getGrid()[i][j], '#');
            }
        }
        
    }
    
    @Test
    public void theWholeMazeIsNotWallAfterCreation() {
        prim.generate();
        boolean truth = false;
        
        for (int i = 0; i < this.prim.getGrid().length; i++) {
            if(truth) {
                break;
            }
            for (int j = 0; j < this.prim.getGrid()[0].length; j++) {
                if (this.prim.getGrid()[i][j] == '.') {
                    truth = true;
                    
                }
            }
        }
        
        assertTrue(truth);
        
    }
    
    @Test
    public void theMazeIsPerfect() {
        prim.generate();
        int[] start = new int[2];
        int[] end = new int[2];
        
            for(int i = 0; i < prim.grid.length; i++) {
                
                for(int j = 0; j < prim.grid[0].length; j++) {
                    if(prim.grid[i][j] == '.') {
                        start[0] = i;
                        start[1] = j;
                    }
                }
            }
        BFS bfs = new BFS(prim.getGrid(), start, end);
        
        assertTrue(bfs.everythingIsReachableInMaze());
    }
    
}
