package ch.jmnetwork.cookieclicker.threading;

import ch.jmnetwork.cookieclicker.ui.CCUserInterface;
import ch.jmnetwork.cookieclicker.util.SaveLoadHandler;

public class SaveThread implements Runnable
{
    CCUserInterface ccui;
    SaveLoadHandler slhandler;
    
    public SaveThread(CCUserInterface ccuserI, SaveLoadHandler slHandler)
    {
        ccui = ccuserI;
        slhandler = slHandler;
    }
    
    @Override
    public void run()
    {
        ccui.setInfoMessage("Saving game...");
        System.out.println("\n[CC] Saving...");
        slhandler.saveToDisk();
        System.out.println("[CC] Saving complete.\n");
        try
        {
            Thread.sleep(500L);
        }
        catch (InterruptedException e)
        {
        }
        ccui.setInfoMessage("");
    }
}
