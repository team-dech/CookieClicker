package ch.jmnetwork.cookieclicker.encryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.crypto.SecretKey;

public class EncryptionHandler
{
    private SecretKey key;
    private EncryptionHelper encHelper;
    
    public EncryptionHandler()
    {
        // SAVE TO FILE
        
        // try
        // {
        // SecretKey key = KeyGenerator.getInstance("DES").generateKey();
        //
        // ObjectOutputStream objOutStream = new ObjectOutputStream(new
        // FileOutputStream("key.obj"));
        // objOutStream.writeObject(key);
        // objOutStream.close();
        // }
        // catch (NoSuchAlgorithmException e)
        // {
        // e.printStackTrace();
        // }
        // catch (FileNotFoundException e)
        // {
        // e.printStackTrace();
        // }
        // catch (IOException e)
        // {
        // e.printStackTrace();
        // }
        
        try
        {
            ObjectInputStream objInputStream = new ObjectInputStream(new FileInputStream("key.obj"));
            key = (SecretKey) objInputStream.readObject();
            objInputStream.close();
        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        encHelper = new EncryptionHelper(key);
    }
    
    public File readDecryptProperties(String encryptedPropertiesPath, String decryptTo)
    {
        try
        {
            encHelper.decrypt(new FileInputStream(encryptedPropertiesPath), new FileOutputStream(decryptTo));
        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new File(decryptTo);
    }
    
    public void encryptProperties(String propertiesToEncryptPath, String encryptTo)
    {
        try
        {
            encHelper.encrypt(new FileInputStream(new File(propertiesToEncryptPath)), new FileOutputStream(new File(encryptTo)));
        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
