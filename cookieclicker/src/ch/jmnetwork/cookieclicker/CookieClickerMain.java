package ch.jmnetwork.cookieclicker;

import ch.jmnetwork.cookieclicker.helper.Helper;

public class CookieClickerMain 
{
    public static CookieClickerMain INSTANCE;
    
    public static void main(String[] args)
    {
        INSTANCE = new CookieClickerMain();
    }
    
    public CookieClickerMain()
    {
        Helper.registerHelpers();
    }
}
