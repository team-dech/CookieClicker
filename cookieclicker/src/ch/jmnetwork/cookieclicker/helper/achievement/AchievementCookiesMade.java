package ch.jmnetwork.cookieclicker.helper.achievement;

public class AchievementCookiesMade extends Achievement
{
    public long cookiesNeeded;
    
    public AchievementCookiesMade(int ID, String name, String desc, long cookies)
    {
        super(ID, name, desc);
        cookiesNeeded = cookies;
    }
    
    public String getDesc()
    {
        return "Bake " + cookiesNeeded + " cookies.";
    }
}
