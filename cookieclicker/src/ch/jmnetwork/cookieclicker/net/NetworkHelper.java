package ch.jmnetwork.cookieclicker.net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class NetworkHelper
{
    
    public static boolean isInternetReachable()
    {
        try
        {
            URL url = new URL("http://www.google.com");
            
            HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
            HttpURLConnection.setFollowRedirects(false);
            urlConnect.setConnectTimeout(1000);
            urlConnect.setRequestMethod("GET");
            urlConnect.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2 (.NET CLR 3.5.30729)");
            urlConnect.connect();
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
            return false;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public File getFileFromURL(String URL, String saveLocation)
    {
        if (!isInternetReachable()) { return null; }
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
