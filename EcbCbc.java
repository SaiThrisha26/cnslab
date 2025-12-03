import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        String message = "HELLOWORLD12345";   // must be multiple of 16 bytes for simplicity

        // 16-byte AES key
        SecretKey key = new SecretKeySpec("1234567812345678".getBytes(), "AES");

        // 16-byte IV for CBC mode
        IvParameterSpec iv = new IvParameterSpec("ABCDEFGH12345678".getBytes());

        /* -------------------- ECB MODE -------------------- */
        Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");

        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encECB = c.doFinal(message.getBytes());
        System.out.println("ECB Encrypted : " + Base64.getEncoder().encodeToString(encECB));

        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decECB = c.doFinal(encECB);
        System.out.println("ECB Decrypted : " + new String(decECB));


        /* -------------------- CBC MODE -------------------- */
        Cipher c2 = Cipher.getInstance("AES/CBC/PKCS5Padding");

        c2.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] encCBC = c2.doFinal(message.getBytes());
        System.out.println("\nCBC Encrypted : " + Base64.getEncoder().encodeToString(encCBC));

        c2.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] decCBC = c2.doFinal(encCBC);
        System.out.println("CBC Decrypted : " + new String(decCBC));
    }
}
