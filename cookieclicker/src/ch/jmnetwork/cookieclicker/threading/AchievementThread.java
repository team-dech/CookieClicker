package ch.jmnetwork.cookieclicker.threading;

import ch.jmnetwork.cookieclicker.CookieManager;
import ch.jmnetwork.cookieclicker.achievement.AchievementCookiesMade;
import ch.jmnetwork.cookieclicker.achievement.AchievementEventHandler;
import ch.jmnetwork.cookieclicker.exceptions.EventCorruptDataException;

public class AchievementThread implements Runnable
{
    CookieManager cookiemanager;
    
    public AchievementThread(CookieManager cm)
    {
        cookiemanager = cm;
    }
    
    @Override
    public void run()
    {
        System.err.println("\n[CC] Checking Achievements!\n");
        
        if (cookiemanager.getTotalCookies() >= AchievementCookiesMade.nextCookies)
        {
            System.out.println("Achievement triggered!, " + cookiemanager.getTotalCookies() + ", " + AchievementCookiesMade.nextCookies + ", currindex: " + AchievementCookiesMade.currentIndex);
            AchievementCookiesMade.nextCookies = AchievementCookiesMade.needed[AchievementCookiesMade.currentIndex + 1];
            
            try
            {
                AchievementEventHandler.onEvent("COOKIESMADE", new Object[]
                { AchievementCookiesMade.needed[AchievementCookiesMade.currentIndex], AchievementCookiesMade.currentIndex });
            }
            catch (EventCorruptDataException e)
            {
                System.out.println("EVENT CORRUPT DATA EXCEPTION CAUGHT");
            }
            
            AchievementCookiesMade.currentIndex += 1;
        }
    }
    
}
