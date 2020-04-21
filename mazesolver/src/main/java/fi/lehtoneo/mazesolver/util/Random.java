package fi.lehtoneo.mazesolver.util;

public class Random {
    
    static int xn = 7;
    static int c = 2;
    static int mul = 3;
    
    public int randomInt(int max) {
        long time = System.nanoTime();
        
        xn = mul*xn  + (int) time + c;
        if(xn < 0 ) {
            xn = (xn*-1)/2;
        }
        return xn % max;
    }
    
}
