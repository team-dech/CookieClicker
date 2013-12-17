package ch.jmnetwork.cookieclicker.exceptions;

public class EventCorruptDataException extends Exception
{
    private static final long serialVersionUID = 8886214702368007419L;
    
    public EventCorruptDataException()
    {
        printStackTrace();
    }
    
    public void printStackTrace()
    {
        System.err.println("Event Handler received a data type which wasn't expected!");
        super.printStackTrace();
    }
}
