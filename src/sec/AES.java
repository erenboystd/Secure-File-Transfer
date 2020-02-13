package sec;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES
{
    private byte[] key;

    private static final String ALGORITHM = "AES";

    /*public AES(byte[] key)
    {
        this.key = key;
    }*/
    
    public byte[] encrypt(byte[] plainText, byte[] key) throws Exception
    {
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        return cipher.doFinal(plainText);
    }
    
    public byte[] decrypt(byte[] cipherText, byte[] key) throws Exception
    {
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        return cipher.doFinal(cipherText);
    }
}
