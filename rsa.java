import java.security.*;
import javax.crypto.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        // Generate RSA key pair (public + private)
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();

        PublicKey pub = kp.getPublic();
        PrivateKey pri = kp.getPrivate();

        Cipher c = Cipher.getInstance("RSA");

        // Encrypt
        c.init(Cipher.ENCRYPT_MODE, pub);
        byte[] enc = c.doFinal("HELLO".getBytes());
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(enc));

        // Decrypt
        c.init(Cipher.DECRYPT_MODE, pri);
        byte[] dec = c.doFinal(enc);
        System.out.println("Decrypted: " + new String(dec));
    }
}
