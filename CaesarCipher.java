public class CaesarCipher { 
    public static void main(String[] args) 
    { 
        String text = "SAIPOOJA"; 
        int shift = 3; 
        String enc = ""; 
        for (int i = 0; i < text.length(); i++) { 
            char c = (char) (((text.charAt(i) - 'A' + shift) % 26) + 'A'); 
            enc += c; 
        } 
        String dec = ""; 
        for (int i = 0; i < enc.length(); i++) { 
            char c = (char) (((enc.charAt(i) - 'A' - shift + 26) % 26) + 'A'); 
            dec += c; 
        } 
        System.out.println("Original : " + text); 
        System.out.println("Encrypted: " + enc); 
        System.out.println("Decrypted: " + dec); 
    } 
}
