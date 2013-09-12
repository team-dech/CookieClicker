package ch.jmnetwork.cookieclicker.helper;


public class HelperFactory extends Helper
{
    public HelperFactory(float prod, long l, int i)
    {
        super(prod, l, i);
        type = EnumHelper.FACTORY;
    }
}
