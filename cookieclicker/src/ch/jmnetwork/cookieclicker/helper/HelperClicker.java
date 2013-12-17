package ch.jmnetwork.cookieclicker.helper;

public class HelperClicker extends Helper
{
    public HelperClicker(float prod, long l, int i)
    {
        super(prod, l, i);
        type = EnumHelper.CLICKER;
    }
    
    public static int cookiesPerClick()
    {
        return 1;
    }
}
