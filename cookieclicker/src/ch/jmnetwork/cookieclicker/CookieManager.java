package ch.jmnetwork.cookieclicker;

public class CookieManager
{
    private int cookiesTotal = 0, cookiesCurrent = 0;
    public float decimalValue;
    
    public void addCookies(int cookiesAmount)
    {
        cookiesTotal += cookiesAmount;
        cookiesCurrent += cookiesAmount;
    }
    
    public int getCurrentCookies()
    {
        return cookiesCurrent;
    }
    
    public boolean buyPrice(int cookiesPrice)
    {
        if (cookiesCurrent >= cookiesPrice)
        {
            cookiesCurrent -= cookiesPrice;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public int getTotalCookies()
    {
        return cookiesTotal;
    }
}
