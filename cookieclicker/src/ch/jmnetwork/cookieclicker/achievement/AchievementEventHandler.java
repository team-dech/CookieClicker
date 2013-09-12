package ch.jmnetwork.cookieclicker.achievement;

public class AchievementEventHandler
{
    public static void onEvent(String eventType, Object[] data)
    {
        
    }
    
    public static String save()
    {
        String data = "";
        
        for (int i = 0; i < Achievement.achieved.length; i++)
            data = data + (Achievement.achieved[i]?"$1":"$0");
        
        return data;
    }
    
    public static void load(String data)
    {
        String[] split = data.split("$");
        
        for (int i = 0; i < split.length; i++)
            Achievement.achieved[i] = split[i].equals(1);
    }
}
