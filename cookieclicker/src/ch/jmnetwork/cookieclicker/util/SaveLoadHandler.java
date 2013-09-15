package ch.jmnetwork.cookieclicker.util;

import ch.jmnetwork.cookieclicker.CookieManager;
import ch.jmnetwork.cookieclicker.achievement.AchievementCookiesMade;
import ch.jmnetwork.cookieclicker.achievement.AchievementEventHandler;
import ch.jmnetwork.cookieclicker.encryption.EncryptionHandler;
import ch.jmnetwork.cookieclicker.exceptions.CCLoadFromDiskException;
import ch.jmnetwork.cookieclicker.helper.Helper;
import ch.jmnetwork.cookieclicker.strings.JStringIterator;
import ch.jmnetwork.cookieclicker.strings.JStrings;

public class SaveLoadHandler
{
    private static CookieManager cookiemanager;
    // private static EncryptionHandler encryptionhandler;
    private static PropertiesHandler ph = new PropertiesHandler("CCSave.xml");
    
    public SaveLoadHandler(CookieManager cm, EncryptionHandler encryptionHandler)
    {
        cookiemanager = cm;
        // encryptionhandler = encryptionHandler;
    }
    
    public void saveToDisk()
    {
        ph.setProperty("COOKIES", buildCookiePropertyString());
        ph.setProperty("ACHIEVEMENTS", AchievementEventHandler.save());
        ph.setProperty("OBJECTS", buildObjectsPropertyString());
        
        ph.saveProperties();
        // new File("save.cc").delete();
        // encryptionhandler.encryptProperties("CCSave.xml", "save.cc");
        // new File("CCSave.xml").deleteOnExit();
    }
    
    public void loadFromDisk() throws CCLoadFromDiskException
    {
        try
        {
            // encryptionhandler.readDecryptProperties("save.cc", "CCSave.xml");
            JStringIterator fsi1 = new JStrings(ph.getProperty("COOKIES", "0_0"), "_").getIterator();
            JStringIterator fsi2 = new JStrings(ph.getProperty("OBJECTS", "0_0_0_0_0_0_0_0_0"), "_").getIterator();
            
            cookiemanager.setTotalCookies(Long.parseLong(fsi1.getNextString()));
            cookiemanager.setCurrentCookies(Long.parseLong(fsi1.getNextString()));
            
            Helper.owned[0] = Integer.parseInt(fsi2.getNextString());
            Helper.owned[1] = Integer.parseInt(fsi2.getNextString());
            Helper.owned[2] = Integer.parseInt(fsi2.getNextString());
            Helper.owned[3] = Integer.parseInt(fsi2.getNextString());
            Helper.owned[4] = Integer.parseInt(fsi2.getNextString());
            Helper.owned[5] = Integer.parseInt(fsi2.getNextString());
            Helper.owned[6] = Integer.parseInt(fsi2.getNextString());
            Helper.owned[7] = Integer.parseInt(fsi2.getNextString());
            Helper.owned[8] = Integer.parseInt(fsi2.getNextString());
            
            AchievementEventHandler.load(ph.getProperty("ACHIEVEMENTS", "$0$0$0$0$0$0$0$0$0$0$0$0$0$0$0$0"));
            // new File("CCSave.xml").delete();
        }
        catch (Exception e)
        {
            throw new CCLoadFromDiskException(e);
        }
        finally
        {
            long[] cookiesNeeded = new long[]
            { 1, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 5000000000L, 10000000000L, 50000000000L, 100000000000L, 500000000000L, 1000000000000L, 10000000000000L };
            
            long cookiesTest = 0;
            int index = 0;
            
            for (int i = 0; i < cookiesNeeded.length; i++)
                if (cookiesTest == 0 && cookiemanager.getTotalCookies() >= cookiesNeeded[i])
                {
                    cookiesTest = cookiesNeeded[i];
                    index = i;
                }
            
            AchievementCookiesMade.nextCookies = cookiesTest;
            AchievementCookiesMade.currentIndex = index;
        }
        
    }
    
    private String buildObjectsPropertyString()
    {
        return Helper.owned[0] + "_" + Helper.owned[1] + "_" + Helper.owned[2] + "_" + Helper.owned[3] + "_" + Helper.owned[4] + "_" + Helper.owned[5] + "_" + Helper.owned[6] + "_" + Helper.owned[7] + "_" + Helper.owned[8];
    }
    
    private String buildCookiePropertyString()
    {
        return cookiemanager.getTotalCookies() + "_" + cookiemanager.getCurrentCookies();
    }
    
}
