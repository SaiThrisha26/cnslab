public class Main {

    char[][] key = {
        {'M','O','N','A','R'},
        {'C','H','Y','B','D'},
        {'E','F','G','I','K'},
        {'L','P','Q','S','T'},
        {'U','V','W','X','Z'}
    };

    int[] pos(char c) {

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {

                if (key[i][j] == c) {

                    return new int[] { i, j };
                }
            }
        }

        return null;
    }

    String process(String msg, boolean enc) {

        msg = msg.replace("J", "I");

        if (msg.length() % 2 != 0) {
            msg = msg + "X";
        }

        StringBuilder res = new StringBuilder();

        int s;

        if (enc) {
            s = 1;
        } else {
            s = -1;
        }

        for (int i = 0; i < msg.length(); i += 2) {

            int[] p1 = pos(msg.charAt(i));
            int[] p2 = pos(msg.charAt(i + 1));

            boolean sameRow = (p1[0] == p2[0]);
            boolean sameCol = (p1[1] == p2[1]);

            if (sameRow) {

                int newCol1 = (p1[1] + 5 + s) % 5;
                int newCol2 = (p2[1] + 5 + s) % 5;

                res.append(key[p1[0]][newCol1]);
                res.append(key[p2[0]][newCol2]);
            }

            else if (sameCol) {

                int newRow1 = (p1[0] + 5 + s) % 5;
                int newRow2 = (p2[0] + 5 + s) % 5;

                res.append(key[newRow1][p1[1]]);
                res.append(key[newRow2][p2[1]]);
            }

            else {

                res.append(key[p1[0]][p2[1]]);
                res.append(key[p2[0]][p1[1]]);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {

        Main obj = new Main();

        String msg = "HELLO";

        String enc = obj.process(msg, true);
        String dec = obj.process(enc, false);

        System.out.println("Original: " + msg);
        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + dec);
    }
}
