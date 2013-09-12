package ch.jmnetwork.cookieclicker.achievement;

public class AchievementCookiesMade extends Achievement
{
    public long cookiesNeeded;
    
    public String[] myDesc = new String[] { "Wake and bake", "Making some dough", "So baked right now", "Fledgling bakery", 
            "Affluent bakery", "World famous bakery", "Cosmic bakery", "Galactic bakery", "Universal bakery", "Timeless bakery", 
            "Infinite bakery", "Immortal bakery", "You can stop now", "Cookies all the way down", "Overdose", "How?" };
    
    public AchievementCookiesMade(int ID, String name, String desc, long cookies)
    {
        super(ID, name, desc);
        cookiesNeeded = cookies;
    }
    
    public String getName()
    {
        return myDesc[this.achievementID];
    }
    
    public String getDesc()
    {
        return "Bake " + cookiesNeeded + " cookies.";
    }
}
