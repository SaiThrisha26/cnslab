public class DiffieHellmanSimple {
    public static void main(String[] args) {

        int p = 23;   // prime
        int g = 5;    // primitive root

        int a = 6;    // Alice private key
        int b = 15;   // Bob private key

        int A = (int)Math.pow(g, a) % p;   // Alice sends A
        int B = (int)Math.pow(g, b) % p;   // Bob sends B

        int secretAlice = (int)Math.pow(B, a) % p;
        int secretBob   = (int)Math.pow(A, b) % p;

        System.out.println("Alice Public Key: " + A);
        System.out.println("Bob Public Key: " + B);
        System.out.println("Shared Secret (Alice): " + secretAlice);
        System.out.println("Shared Secret (Bob): " + secretBob);
    }
}
