package ch.jmnetwork.cookieclicker.encryption;

import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class EncryptionHelper
{
    private static Cipher encryptCipher;
    private static Cipher decryptCipher;
    
    private static byte[] iv =
    { (byte) 0xB2, (byte) 0x12, (byte) 0xD5, (byte) 0xB2, (byte) 0x44, (byte) 0x21, (byte) 0xC3, (byte) 0xC3 };
    
    public EncryptionHelper(SecretKey secretKey)
    {
        try
        {
            SecretKey key = secretKey;
            AlgorithmParameterSpec parameterSpec = new IvParameterSpec(iv);
            encryptCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            decryptCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            encryptCipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);
            decryptCipher.init(Cipher.DECRYPT_MODE, key, parameterSpec);
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchPaddingException e)
        {
            e.printStackTrace();
        }
        catch (InvalidKeyException e)
        {
            e.printStackTrace();
        }
        catch (InvalidAlgorithmParameterException e)
        {
            e.printStackTrace();
        }
    }
    
    public void encrypt(InputStream input, OutputStream output)
    {
        try
        {
            byte[] buffer = new byte[1024];
            
            output = new CipherOutputStream(output, encryptCipher);
            
            int numRead = 0;
            
            while ((numRead = input.read(buffer)) >= 0)
            {
                output.write(buffer, 0, numRead);
            }
            output.close();
            input.close();
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void decrypt(InputStream input, OutputStream output)
    {
        try
        {
            byte[] buffer = new byte[1024];
            
            CipherInputStream cis = new CipherInputStream(input, decryptCipher);
            
            int numRead = 0;
            
            while ((numRead = cis.read(buffer)) >= 0)
            {
                output.write(buffer, 0, numRead);
            }
            cis.close();
            input.close();
            output.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
