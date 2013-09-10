package ch.jmnetwork.cookieclicker.helper.achievement;

public class AchievementEventHandler
{
    public static void onEvent(String eventType, Object[] data)
    {
        
    }
    
    public static String save()
    {
        String data = (Achievement.achieved[0]?"1":"0");
        
        for (int i = 1; i < Achievement.achievements.length - 1; i++)
        {
            data = data + "" + (Achievement.achieved[i]?":1":":0");
        }
        
        return data;
    }
    
    public static void load(String data)
    {
        
    }
}
