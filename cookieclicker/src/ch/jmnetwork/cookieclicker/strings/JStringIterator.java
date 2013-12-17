package ch.jmnetwork.cookieclicker.strings;

import java.util.Arrays;

public class JStringIterator
{
    
    String[] splittedString;
    int i = 0;
    
    public JStringIterator(String[] splitdString)
    {
        splittedString = Arrays.copyOf(splitdString, splitdString.length);
    }
    
    public String getNextString()
    {
        
        String toReturn;
        
        if (i < splittedString.length)
        {
            toReturn = splittedString[i];
            i++;
        }
        else
        {
            i = 0;
            toReturn = splittedString[i];
        }
        
        return toReturn;
    }
    
    public int getNumberOfObjects()
    {
        return splittedString.length;
    }
}
