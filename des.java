import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        // DES key must be 8 bytes
        SecretKey key = new SecretKeySpec("12345678".getBytes(), "DES");

        // Create DES cipher
        Cipher cipher = Cipher.getInstance("DES");

        // Encrypt
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal("HELLO".getBytes());
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));

        // Decrypt
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = cipher.doFinal(encrypted);
        System.out.println("Decrypted: " + new String(decrypted));
    }
}
