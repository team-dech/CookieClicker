package ch.jmnetwork.cookieclicker.helper;

public class Helper
{
    public static Helper[] helpers = new Helper[9];
    
    public float productivity;
    public int price;
    
    public int helperID;
    
    public EnumHelper type;
    
    public Helper(float prod, int pr, int ID)
    {
        productivity = prod;
        price = pr;
    }
    
    public int getPriceForNextHelper()
    {
        return 0;
    }
    
    public static void registerHelpers()
    {
        helpers[0] = new HelperClicker(0.1F, 15, 0);
        helpers[1] = new HelperGrandma(0.5F, 100, 1);
        helpers[2] = new HelperFarm(2F, 500, 2);
        helpers[3] = new HelperFactory(10F, 3000, 3);
        helpers[4] = new HelperMine(40F, 10000, 4);
        helpers[5] = new HelperShipment(100F, 40000, 5);
        helpers[6] = new HelperAlchemyLab(400F, 200000, 6);
        helpers[7] = new HelperPortal(6666F, 1666666, 7);
        helpers[8] = new HelperTimeMachine(98765F, 123456789, 8);
    }
}
