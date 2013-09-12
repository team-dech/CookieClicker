package ch.jmnetwork.cookieclicker.achievement;

public class Achievement
{
    public static Achievement[] achievements = new Achievement[16];
    public static boolean[] achieved = new boolean[16];
    
    public int achievementID;
    public String achievementName, achievementDesc;
    
    public Achievement(int ID, String name, String desc)
    {
        achievementID = ID;
        achievementName = name;
        achievementDesc = desc;
    }
    
    public String getName()
    {
        return achievementName;
    }
    
    public String getDesc()
    {
        return achievementDesc;
    }
    
    public static void registerAchievements()
    {
        achievements[0] = new AchievementCookiesMade(0, "$N", "$D", 1);
        achievements[1] = new AchievementCookiesMade(1, "$N", "$D", 100);
        achievements[2] = new AchievementCookiesMade(2, "$N", "$D", 1000);
        achievements[3] = new AchievementCookiesMade(3, "$N", "$D", 10000);
        achievements[4] = new AchievementCookiesMade(4, "$N", "$D", 100000);
        achievements[5] = new AchievementCookiesMade(5, "$N", "$D", 1000000);
        achievements[6] = new AchievementCookiesMade(6, "$N", "$D", 10000000);
        achievements[7] = new AchievementCookiesMade(7, "$N", "$D", 100000000);
        achievements[8] = new AchievementCookiesMade(8, "$N", "$D", 1000000000);
        achievements[9] = new AchievementCookiesMade(9, "$N", "$D", 5000000000L);
        achievements[10] = new AchievementCookiesMade(10, "$N", "$D", 10000000000L);
        achievements[11] = new AchievementCookiesMade(11, "$N", "$D", 50000000000L);
        achievements[12] = new AchievementCookiesMade(12, "$N", "$D", 100000000000L);
        achievements[13] = new AchievementCookiesMade(13, "$N", "$D", 500000000000L);
        achievements[14] = new AchievementCookiesMade(14, "$N", "$D", 1000000000000L);
        achievements[15] = new AchievementCookiesMade(15, "$N", "$D", 10000000000000L);
    }
}
