import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        // 16-byte AES key
        SecretKey key = new SecretKeySpec("1234567812345678".getBytes(), "AES");

        // Create AES cipher
        Cipher cipher = Cipher.getInstance("AES");

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
