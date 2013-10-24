package ch.jmnetwork.cookieclicker.util;

import ch.jmnetwork.cookieclicker.CookieClickerMain;
import ch.jmnetwork.cookieclicker.CookieManager;
import ch.jmnetwork.cookieclicker.achievement.AchievementCookiesMade;
import ch.jmnetwork.cookieclicker.achievement.AchievementEventHandler;
import ch.jmnetwork.cookieclicker.exceptions.CCLoadFromDiskException;
import ch.jmnetwork.cookieclicker.helper.Helper;
import ch.jmnetwork.cookieclicker.strings.JStringIterator;
import ch.jmnetwork.cookieclicker.strings.JStrings;

public class SaveLoadHandler
{
    private static CookieManager cookiemanager;
    // private static EncryptionHandler encryptionhandler;
    private static PropertiesHandler ph = new PropertiesHandler("CCSave.xml");
    
    public SaveLoadHandler(CookieManager cm)
    {
        cookiemanager = cm;
    }
    
    public void saveToDisk()
    {
        ph.setProperty("COOKIES", buildCookiePropertyString());
        ph.setProperty("ACHIEVEMENTS", AchievementEventHandler.save());
        ph.setProperty("OBJECTS", buildObjectsPropertyString());
        ph.setProperty("TICKS_S", "" + CookieClickerMain.TICKS_PER_SECOND);
        
        ph.saveProperties();
    }
    
    public void loadFromDisk() throws CCLoadFromDiskException
    {
        try
        {
            CookieClickerMain.TICKS_PER_SECOND = Integer.parseInt(ph.getProperty("TICKS_S", "25"));
            JStringIterator fsi1 = new JStrings(ph.getProperty("COOKIES", "0_0_0"), "_").getIterator();
            JStringIterator fsi2 = new JStrings(ph.getProperty("OBJECTS", "0_0_0_0_0_0_0_0_0"), "_").getIterator();
            
            cookiemanager.setTotalCookies(Long.parseLong(fsi1.getNextString()));
            cookiemanager.setCurrentCookies(Long.parseLong(fsi1.getNextString()));
            long handmade = Long.parseLong(fsi1.getNextString());
            if (handmade == cookiemanager.getTotalCookies())
            {
                cookiemanager.setHandmadeCookies(0);
            }
            else
            {
                cookiemanager.setHandmadeCookies(handmade);
            }
            Helper.owned[0] = Integer.parseInt(fsi2.getNextString());
            Helper.owned[1] = Integer.parseInt(fsi2.getNextString());
            Helper.owned[2] = Integer.parseInt(fsi2.getNextString());
            Helper.owned[3] = Integer.parseInt(fsi2.getNextString());
            Helper.owned[4] = Integer.parseInt(fsi2.getNextString());
            Helper.owned[5] = Integer.parseInt(fsi2.getNextString());
            Helper.owned[6] = Integer.parseInt(fsi2.getNextString());
            Helper.owned[7] = Integer.parseInt(fsi2.getNextString());
            Helper.owned[8] = Integer.parseInt(fsi2.getNextString());
            
            AchievementEventHandler.load(ph.getProperty("ACHIEVEMENTS", "0_0_0_0_0_0_0_0_0_0_0_0_0_0_0_0"));
            
            System.out.println(AchievementCookiesMade.nextCookies);
            System.out.println("Loading finished!");
        }
        catch (Exception e)
        {
            throw new CCLoadFromDiskException(e);
        }
    }
    
    private String buildObjectsPropertyString()
    {
        return Helper.owned[0] + "_" + Helper.owned[1] + "_" + Helper.owned[2] + "_" + Helper.owned[3] + "_" + Helper.owned[4] + "_" + Helper.owned[5] + "_" + Helper.owned[6] + "_" + Helper.owned[7] + "_" + Helper.owned[8];
    }
    
    private String buildCookiePropertyString()
    {
        return cookiemanager.getTotalCookies() + "_" + cookiemanager.getCurrentCookies() + "_" + cookiemanager.getHandmadeCookies();
    }
    
}
