package ch.jmnetwork.cookieclicker.net;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class NetworkHelper
{
    public File getFileFromURL(String URL, String saveLocation)
    {
        
        URL website;
        ReadableByteChannel rbc;
        FileOutputStream fos;
        File f = new File(saveLocation);
        
        try
        {
            website = new URL(URL);
            
            System.out.println("[get file] " + website + " --> " + f.getAbsolutePath());
            rbc = Channels.newChannel(website.openStream());
            if (!f.exists())
            {
                try
                {
                    File parentFile = null;
                    if (f.getParentFile() != null)
                    {
                        parentFile = f.getParentFile();
                    }
                    if (!(parentFile == null))
                    {
                        parentFile.mkdirs();
                    }
                }
                catch (Exception e)
                {
                    
                }
                f.createNewFile();
                
            }
            fos = new FileOutputStream(saveLocation);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            
            fos.close();
        }
        catch (Exception e)
        {
            System.out.println("Beim Herunterladen von " + URL + " ist ein Fehler aufgetreten.");
            e.printStackTrace();
        }
        
        return new File(saveLocation);
    }
    
}
