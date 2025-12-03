import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        // AES key must be 16 bytes
        SecretKey key = new SecretKeySpec("1234567812345678".getBytes(), "AES");

        // Create AES cipher
        Cipher c = Cipher.getInstance("AES");

        // Encrypt
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = c.doFinal("HELLO".getBytes());
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));

        // Decrypt
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = c.doFinal(encrypted);
        System.out.println("Decrypted: " + new String(decrypted));
    }
}
