package ch.jmnetwork.cookieclicker.helper;


public class HelperFactory extends Helper
{
    public HelperFactory(float prod, int pr, int i)
    {
        super(prod, pr, i);
        type = EnumHelper.FACTORY;
    }
}
