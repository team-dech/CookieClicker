package ch.jmnetwork.cookieclicker.strings;

public class JStrings
{
    
    String workString, separator;
    
    public JStrings(String theString, String separator)
    {
        workString = theString;
        this.separator = separator;
    }
    
    public String[] getSplittedStringArray()
    {
        return workString.split(separator);
    }
    
    public JStringIterator getIterator()
    {
        return new JStringIterator(getSplittedStringArray());
    }
}
