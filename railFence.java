import java.util.*;
public class Main { 
    public static String encrypt(String text, int key) {  
        char[][] rail = new char[key][text.length()]; 
        boolean dirDown = false; 
        int row = 0; 

        for (int i = 0; i < text.length(); i++) { 
            if (row == 0 || row == key - 1) 
                dirDown = !dirDown; 

            rail[row][i] = text.charAt(i); 
            row += dirDown ? 1 : -1; 
        } 

        StringBuilder result = new StringBuilder();  

        for (int i = 0; i < rail.length; i++) {
            for (int j = 0; j < rail[i].length; j++) {
                char c = rail[i][j];
                if (c != 0) {
                    result.append(c);
                }
            }
        }

        return result.toString(); 
    }    

    public static void main(String[] args) {  
        String message = "NETWORK"; 
        System.out.println("Original : " + message); 
        System.out.println("Encrypted: " + encrypt(message, 3)); 
    }
}
