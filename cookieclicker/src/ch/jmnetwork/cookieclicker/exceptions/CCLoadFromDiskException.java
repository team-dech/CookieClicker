package ch.jmnetwork.cookieclicker.exceptions;

public class CCLoadFromDiskException extends Exception
{
    private static final long serialVersionUID = 6095635912008021464L;
    
    public CCLoadFromDiskException()
    {
        System.err.println("[ERROR] For further information use printStackTrace()");
        System.exit(1);
    }
    
    @Override
    public void printStackTrace()
    {
        System.err.println("A value in savefile was changed and is no longer usable. Exiting");
    }
}
