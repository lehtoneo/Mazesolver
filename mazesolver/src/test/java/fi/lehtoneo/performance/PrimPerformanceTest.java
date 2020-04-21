package fi.lehtoneo.performance;

import fi.lehtoneo.mazesolver.mazegeneration.Prim;
import org.junit.After;
import org.junit.Test;


public class PrimPerformanceTest {
    private final int[] sizes = {100, 100, 100, 127, 200, 500, 625, 1000, 1222};
    private double[] results = new double[sizes.length];
    
    @Test
    public void runPerfTests() {
        long n = 300;
        long a = 0;
        System.out.println("Prim performance tests starting, this might take a while... ");
        for(int i = 0; i < sizes.length; i++) {
            long sum = 0;
            
            while(a < n) {
                
                Prim p = new Prim(sizes[i], sizes[i]);
                long start = System.nanoTime();
                p.generate();
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
        System.out.println("Prim performance results: ");
        System.out.println("");
        for(int i = 0; i < sizes.length; i++) {
            System.out.println("When maze size was (" + sizes[i] + " x " + sizes[i] + "), avg generation time was ");
            System.out.println(results[i] + " ms");
            System.out.println("");
        }
   }
}
