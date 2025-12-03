public class RowColumnCipher {
    public static String encrypt(String text, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        int idx = 0;

        // keep only letters, make uppercase
        text = text.toUpperCase().replaceAll("[^A-Z]", "");

        // pad with X if needed
        while (text.length() < rows * cols)
            text += 'X';

        // fill row-wise
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = text.charAt(idx++);

        // read column-wise
        StringBuilder encrypted = new StringBuilder();
        for (int j = 0; j < cols; j++)
            for (int i = 0; i < rows; i++)
                encrypted.append(matrix[i][j]);

        return encrypted.toString();
    }

    public static void main(String[] args) {
        String text = "WINDOW";
        System.out.println("Original : " + text);
        System.out.println("Encrypted: " + encrypt(text, 2, 3));
    }
}
