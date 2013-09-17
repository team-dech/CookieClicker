package ch.jmnetwork.cookieclicker.achievement;

import ch.jmnetwork.cookieclicker.exceptions.EventCorruptDataException;

public class AchievementEventHandler
{
    public static void onEvent(String eventType, Object[] data) throws EventCorruptDataException
    {
        try
        {
            if (eventType.equals("COOKIESMADE"))
            {
                long cookies = (long) data[0];
                
                AchievementCookiesMade.achievementAchieved(cookies);
            }
        }
        catch (Exception e)
        {
            throw new EventCorruptDataException();
        }
    }
    
    public static String save()
    {
        String data = "";
        
        for (int i = 0; i < Achievement.achieved.length; i++)
            data = data + (Achievement.achieved[i] ? "$1" : "$0");
        
        return data;
    }
    
    public static void load(String data)
    {
        String[] split = data.split("$");
        
        for (int i = 0; i < split.length; i++)
            Achievement.achieved[i] = split[i].equals(1);
    }
}
