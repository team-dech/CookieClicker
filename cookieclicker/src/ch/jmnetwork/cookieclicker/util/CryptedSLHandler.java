package ch.jmnetwork.cookieclicker.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import ch.jmnetwork.cookieclicker.CookieManager;

public class CryptedSLHandler
{
    public static CryptedSLHandler instance;
    public CookieManager cmanager;
    
    public CryptedSLHandler(CookieManager manager)
    {
        instance = this;
        cmanager = manager;
    }
    
    public void save()
    {
        ByteArrayOutputStream outputBytes = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(outputBytes);
        
        try
        {
            dos.writeLong(cmanager.getCurrentCookies());
            dos.writeBoolean(true);
            dos.writeLong(cmanager.getTotalCookies());
            dos.writeBoolean(true);
            dos.writeLong(cmanager.getHandmadeCookies());
            dos.writeBoolean(false);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        System.out.println(outputBytes.toString());
    }
    
    public void load(byte[] data)
    {
        ByteArrayInputStream inputBytes = new ByteArrayInputStream(data);
        DataInputStream dis = new DataInputStream(inputBytes);
       
        boolean next, stop = false;
        
        try
        {
            cmanager.setCurrentCookies(dis.readLong());
            
            next = dis.readBoolean();
            if (next && !stop) cmanager.setTotalCookies(dis.readLong()); else cmanager.setTotalCookies(0);
            if (!next && !stop) stop = true;
            
            next = dis.readBoolean();
            if (next && !stop) cmanager.setHandmadeCookies(dis.readLong()); else cmanager.setHandmadeCookies(0);
            if (!next && !stop) stop = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
