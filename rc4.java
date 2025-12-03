import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        // RC4 key
        SecretKey key = new SecretKeySpec("MYSECRETKEY".getBytes(), "RC4");

        Cipher c = Cipher.getInstance("RC4");

        // Encrypt
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] enc = c.doFinal("HELLO".getBytes());
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(enc));

        // Decrypt (same key)
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] dec = c.doFinal(enc);
        System.out.println("Decrypted: " + new String(dec));
    }
}
