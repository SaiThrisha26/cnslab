import java.security.MessageDigest;
import java.util.Scanner;

public class SHA512Hash {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        byte[] hash = md.digest(input.getBytes());

        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }

        System.out.println("\nSHA-512 Digest:");
        System.out.println(sb.toString());
    }
}
