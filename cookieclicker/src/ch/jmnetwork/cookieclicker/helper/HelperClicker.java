package ch.jmnetwork.cookieclicker.helper;

public class HelperClicker extends Helper
{
    public HelperClicker(float prod, int pr, int i)
    {
        super(prod, pr, i);
        type = EnumHelper.CLICKER;
    }
    
    public static int cookiesPerClick()
    {
        return 1;
    }
}
