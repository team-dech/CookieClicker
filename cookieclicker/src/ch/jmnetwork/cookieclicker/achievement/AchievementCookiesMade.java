package ch.jmnetwork.cookieclicker.achievement;

public class AchievementCookiesMade extends Achievement
{
    public static Long nextCookies;
    public static int currentIndex;
    
    public static long[] needed = new long[] { 1, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 5000000000L, 10000000000L, 50000000000L, 100000000000L, 500000000000L, 1000000000000L, 10000000000000L };
    
    
    public long cookiesNeeded;
    
    public static String[] myDesc = new String[] { "Wake and bake", "Making some dough", "So baked right now", "Fledgling bakery", 
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
