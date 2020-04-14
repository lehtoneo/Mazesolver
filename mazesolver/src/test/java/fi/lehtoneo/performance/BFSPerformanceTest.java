package fi.lehtoneo.performance;

import fi.lehtoneo.mazesolver.mazecreation.Prim;
import fi.lehtoneo.mazesolver.mazesolving.BFS;
import org.junit.After;
import org.junit.Test;


public class BFSPerformanceTest {
    private final int[] sizes = {100, 100, 100, 200, 300, 400, 500, 600};
    private double[] results = new double[sizes.length];
    
    @Test
    public void runPerfTests() {
        System.out.println("BFS performance tests starting, this might take a while...");
        long n = 300;
        long a = 0;
        for(int i = 0; i < sizes.length; i++) {
            long sum = 0;
            
            while(a < n) {
                Prim p = new Prim(sizes[i], sizes[i]);
                p.generate();
                int[] startPoint = getStartingPoint(p.getGrid());
                int[] endPoint = getEndingPoint(p.getGrid());
                BFS bfs = new BFS(p.getGrid(), startPoint, endPoint);
            
                long start = System.nanoTime();
                bfs.solveRoute();
                long end = System.nanoTime();
                
                if(a > 0) {
                    sum += (end-start)/1000000.0;
                }
                
                a++;
            }
            
            a = 0;
            results[i] = Double.valueOf(sum)/(n-1);
            
            System.out.println(i + 1 + "/" + sizes.length + " done");
            
        }
        
    }
    @After 
    public void showResults() {
        System.out.println("BFS performance results: ");
        System.out.println("");
        for(int i = 0; i < sizes.length; i++) {
            System.out.println("When maze size was (" + sizes[i] + " x " + sizes[i] + ")");
            System.out.println("AVG solving time was: ");
            System.out.println(results[i] + " ms");
            System.out.println("");
        }
   }
    
    private int[] getStartingPoint(char[][] grid) {
        int[] start = new int[2];
        for(int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid.length; j++) {
                if(grid[i][j] == '.') {
                start[0] = i;
                start[1] = j;
                return start;
                }
            }
        }
        
        // this is unreachable
        return start;
    }
    
    private int[] getEndingPoint(char[][] grid) {
        int[] end = new int[2];
        for(int i = grid.length - 1; i > 0; i--) {
            for (int j = grid.length - 1; j > 0; j--) {
                if(grid[i][j] == '.') {
                end[0] = i;
                end[1] = j;
                return end;
                }
            }
        }
        //this is unreachable
        return end;
        
    }
}