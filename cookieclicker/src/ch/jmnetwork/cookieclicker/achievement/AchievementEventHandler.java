package ch.jmnetwork.cookieclicker.achievement;

import ch.jmnetwork.cookieclicker.exceptions.EventCorruptDataException;
import ch.jmnetwork.cookieclicker.strings.JStringIterator;
import ch.jmnetwork.cookieclicker.strings.JStrings;

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
                Achievement.achieved[(int) data[1]] = true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new EventCorruptDataException();
        }
    }
    
    public static String save()
    {
        String data = "";
        
        for (int i = 0; i < Achievement.achieved.length; i++)
        {
            if (i > 0)
            {
                data = data + (Achievement.achieved[i] ? "_1" : "_0");
            }
            else
            {
                data = data + (Achievement.achieved[i] ? "1" : "0");
            }
            
        }
        
        return data;
    }
    
    public static void load(String data)
    {
        JStringIterator achStrIterator = new JStrings(data, "_").getIterator();
        
        for (int i = 0; i < achStrIterator.getNumberOfObjects(); i++)
        {
            int current = Integer.parseInt(achStrIterator.getNextString());
            
            try
            {
                Achievement.achieved[i] = current == 1; // Have we got that achievement allready?
                AchievementCookiesMade.currentIndex = current != 0 ? i + 1 : AchievementCookiesMade.currentIndex; // Where are we at the moment?
            }
            catch (Exception e)
            {
                
            }
        }
        AchievementCookiesMade.nextCookies = AchievementCookiesMade.needed[AchievementCookiesMade.currentIndex + 1];
    }
}
