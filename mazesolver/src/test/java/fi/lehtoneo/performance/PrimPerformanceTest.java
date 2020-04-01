package fi.lehtoneo.performance;

import fi.lehtoneo.mazesolver.mazecreation.Prim;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class PrimPerformanceTest {
    private final int[] sizes = {100, 200};
    private double[] results = new double[sizes.length];
    
    @Test
    public void runPerfTests() {
        long n = 300;
        long a = 0;
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
            System.out.println(i + " done");
            
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
