import java.security.*;

public class DigitalSignatureSimple {
    public static void main(String[] args) throws Exception {

        String message = "hello";

        // Generate keys
        KeyPairGenerator k = KeyPairGenerator.getInstance("RSA");
        k.initialize(1024);
        KeyPair pair = k.generateKeyPair();

        // Sign
        Signature s = Signature.getInstance("SHA256withRSA");
        s.initSign(pair.getPrivate());
        s.update(message.getBytes());
        byte[] signature = s.sign();

        // Verify
        Signature v = Signature.getInstance("SHA256withRSA");
        v.initVerify(pair.getPublic());
        v.update(message.getBytes());
        boolean ok = v.verify(signature);

        System.out.println("Signature Verified: " + ok);
    }
}
