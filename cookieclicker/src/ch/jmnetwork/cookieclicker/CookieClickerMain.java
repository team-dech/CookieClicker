package ch.jmnetwork.cookieclicker;

import ch.jmnetwork.cookieclicker.helper.Helper;
import ch.jmnetwork.cookieclicker.ui.CCUserInterface;

public class CookieClickerMain
{
    public static CookieClickerMain INSTANCE;
    private final static int TICKS_PER_SECOND = 25;
    private static long lastTime = 0;
    private static long thisTime = 0;
    private static CCUserInterface ccui;
    private static int i = 0;
    
    public static void main(String[] args)
    {
        INSTANCE = new CookieClickerMain();
        
        ccui = new CCUserInterface();
        
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
                
                // DEBUG START
                ccui.setCookieLevel(i);
                i++;
                // DEBUG END
            }
        }
    }
    
    public CookieClickerMain()
    {
        Helper.registerHelpers();
    }
    
    /**
     * Convert a nanoTime to milliseconds
     * 
     * @param nanoTime
     *            {@see System#nanoTime()}
     * @return time in milliseconds
     */
    public int nanoToMilliseconds(long nanoTime)
    {
        return (int) (nanoTime / 1000000);
    }
}
