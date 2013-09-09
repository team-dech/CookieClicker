package ch.jmnetwork.cookieclicker;

import ch.jmnetwork.cookieclicker.helper.Helper;

public class CookieClickerMain
{
    public static CookieClickerMain INSTANCE;
    private final static int TICKS_PER_SECOND = 25;
    private static long lastTime = 0;
    private static long thisTime = 0;
    
    public static void main(String[] args)
    {
        INSTANCE = new CookieClickerMain();
        
        while (true)
        {
            if (lastTime == 0) lastTime = System.nanoTime();
            
            thisTime = System.nanoTime();
            
            // only run this TICKS_PER_SECOND times per second
            if ((thisTime - lastTime) / 1000000 >= 1000 / TICKS_PER_SECOND)
            {
                // ======================================//
                // STUFF TO RUN EACH TICK
                // ======================================//
                
            }
            
        }
        
    }
    
    public CookieClickerMain()
    {
        Helper.registerHelpers();
    }
    
    /**
     * Convert a nanoTime to miliseconds
     * 
     * @param nanoTime
     *            {@see System#nanoTime()}
     * @return time in miliseconds
     */
    public int nanoToMiliseconds(long nanoTime)
    {
        return (int) (nanoTime / 1000000);
    }
}
