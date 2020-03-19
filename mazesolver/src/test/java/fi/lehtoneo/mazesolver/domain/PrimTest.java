
package fi.lehtoneo.mazesolver.domain;

import static org.junit.Assert.*;
import org.junit.Test;

import org.junit.Before;
/**
 *
 * @author ossij
 */
public class PrimTest {
    private Prim prim;
    @Before
    public void setUp() {
        this.prim = new Prim(10,12);
    }
    
    @Test
    public void thereAre10Rows() {
        
        assertEquals(this.prim.getGrid().length, 10);
    }
    
    @Test
    public void thereAre12Columns() {
        assertEquals(this.prim.getGrid()[0].length, 12);
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
    
}
