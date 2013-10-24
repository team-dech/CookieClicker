package ch.jmnetwork.cookieclicker.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import ch.jmnetwork.cookieclicker.CookieClickerMain;
import ch.jmnetwork.cookieclicker.CookieManager;
import ch.jmnetwork.cookieclicker.helper.Helper;

/**
 * Save format:
 * 
 *        1: Cookies in bank
 *        2: Total cookies made
 *        3: Cookies produced by clicking
 *        4: Ticks per second
 *     5-14: Quantity of helpers owned
 */
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
        File save = new File("cookieclicker.sav");
        
        ByteArrayOutputStream outputBytes = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(outputBytes);
        
        try
        {
            dos.writeLong(cmanager.getCurrentCookies());
            dos.writeBoolean(true);
            dos.writeLong(cmanager.getTotalCookies());
            dos.writeBoolean(true);
            dos.writeLong(cmanager.getHandmadeCookies());
            dos.writeBoolean(true);
            dos.writeInt(CookieClickerMain.TICKS_PER_SECOND);
            dos.writeBoolean(true);
            dos.writeInt(Helper.owned[0]);
            dos.writeBoolean(true);
            dos.writeInt(Helper.owned[1]);
            dos.writeBoolean(true);
            dos.writeInt(Helper.owned[2]);
            dos.writeBoolean(true);
            dos.writeInt(Helper.owned[3]);
            dos.writeBoolean(true);
            dos.writeInt(Helper.owned[4]);
            dos.writeBoolean(true);
            dos.writeInt(Helper.owned[5]);
            dos.writeBoolean(true);
            dos.writeInt(Helper.owned[6]);
            dos.writeBoolean(true);
            dos.writeInt(Helper.owned[7]);
            dos.writeBoolean(true);
            dos.writeInt(Helper.owned[8]);
            dos.writeBoolean(true);
            dos.writeInt(Helper.owned[9]);
            dos.writeBoolean(false);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        try
        {
            FileOutputStream fileOut = new FileOutputStream(save, false);
            fileOut.write(outputBytes.toByteArray());
            fileOut.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void load()
    {
        File save = new File("cookieclicker.sav");
        if (!save.exists()) createDefaultFile();
        
        FileInputStream fileIn;
        
        byte[] data = new byte[(int) save.length()];
        
        try
        {
            fileIn = new FileInputStream(save);
            fileIn.read(data);
            fileIn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        if (data != null)
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
            
                next = dis.readBoolean();
                if (next && !stop) CookieClickerMain.TICKS_PER_SECOND = dis.readInt(); else CookieClickerMain.TICKS_PER_SECOND = 25;
                if (!next && !stop) stop = true;
            
                next = dis.readBoolean();
                if (next && !stop) Helper.owned[0] = dis.readInt(); else Helper.owned[0] = 0;
                if (!next && !stop) stop = true;
            
                next = dis.readBoolean();
                if (next && !stop) Helper.owned[1] = dis.readInt(); else Helper.owned[1] = 0;
                if (!next && !stop) stop = true;
            
                next = dis.readBoolean();
                if (next && !stop) Helper.owned[2] = dis.readInt(); else Helper.owned[2] = 0;
                if (!next && !stop) stop = true;
            
                next = dis.readBoolean();
                if (next && !stop) Helper.owned[3] = dis.readInt(); else Helper.owned[3] = 0;
                if (!next && !stop) stop = true;
            
                next = dis.readBoolean();
                if (next && !stop) Helper.owned[4] = dis.readInt(); else Helper.owned[4] = 0;
                if (!next && !stop) stop = true;
            
                next = dis.readBoolean();
                if (next && !stop) Helper.owned[5] = dis.readInt(); else Helper.owned[5] = 0;
                if (!next && !stop) stop = true;
            
                next = dis.readBoolean();
                if (next && !stop) Helper.owned[6] = dis.readInt(); else Helper.owned[6] = 0;
                if (!next && !stop) stop = true;
            
                next = dis.readBoolean();
                if (next && !stop) Helper.owned[7] = dis.readInt(); else Helper.owned[7] = 0;
                if (!next && !stop) stop = true;
            
                next = dis.readBoolean();
                if (next && !stop) Helper.owned[8] = dis.readInt(); else Helper.owned[8] = 0;
                if (!next && !stop) stop = true;
            
                next = dis.readBoolean();
                if (next && !stop) Helper.owned[9] = dis.readInt(); else Helper.owned[9] = 0;
                if (!next && !stop) stop = true;
                
                
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public void createDefaultFile()
    {
        File save = new File("cookieclicker.sav");
        
        try
        {
            save.createNewFile();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        ByteArrayOutputStream outputBytes = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(outputBytes);
        
        try
        {
            dos.writeLong(0);
            dos.writeBoolean(true);
            dos.writeLong(0);
            dos.writeBoolean(true);
            dos.writeLong(0);
            dos.writeBoolean(true);
            dos.writeInt(25);
            dos.writeBoolean(true);
            dos.writeInt(0);
            dos.writeBoolean(true);
            dos.writeInt(0);
            dos.writeBoolean(true);
            dos.writeInt(0);
            dos.writeBoolean(true);
            dos.writeInt(0);
            dos.writeBoolean(true);
            dos.writeInt(0);
            dos.writeBoolean(true);
            dos.writeInt(0);
            dos.writeBoolean(true);
            dos.writeInt(0);
            dos.writeBoolean(true);
            dos.writeInt(0);
            dos.writeBoolean(true);
            dos.writeInt(0);
            dos.writeBoolean(true);
            dos.writeInt(0);
            dos.writeBoolean(false);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        try
        {
            FileOutputStream fileOut = new FileOutputStream(save, false);
            
            fileOut.write(outputBytes.toByteArray());
            
            fileOut.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
