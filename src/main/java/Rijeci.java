import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * One day, little Mirko came across a funny looking machine!
 * It consisted of a very very large screen and a single button. When he found the machine,
 * the screen displayed only the letter A. After he pressed the button, the letter changed to B.
 * The next few times he pressed the button, the word transformed from B to BA, then to BAB, then to BABBA...
 * When he saw this, Mirko realized that the machine alters the word in a way that
 * all the letters B get transformed to BA and all the letters A get transformed to B.
 *
 * Amused by the machine, Mirko asked you a very difficult question!
 * After K times of pressing the button, how many letters A and how much letters B will be displayed on the screen?
 *
 * Input
 * The first line of input contains the integer K
 K
 (1≤K≤45
 1
 K
 45
 ), the number of times Mirko pressed the button.

 Output
 The first and only line of output must contain two space-separated integers,
 the number of letters A and the number of letter B.
 */
public class Rijeci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Rijeci().solve(in));
    }

    public String solve(Scanner in) {
        int k = in.nextInt();
        int a = 1;
        int b = 0;

        for (int i = 0 ; i < k ; i++) {
            int newB = b + a;
            int newA = b;

            a = newA;
            b = newB;
        }

        return String.format("%d %d", a, b);
    }

//    public String solve(Scanner in) {
//        int k = in.nextInt();
//        int a = 1;
//        String s = "A";
//
//        for (int i = 0 ; i < k ; i++) {
//            s = changeLettersSB(s);
//        }
//
//        return String.format("%d %d",
//                s.replaceAll("B", "").length(),
//                s.replaceAll("A", "").length());
//    }
//
//    protected String changeLettersSB(String s) {
//        StringBuffer result = new StringBuffer();
//
//        for (byte b: s.getBytes()) {
//            if (b == 'A') {
//                result.append('B');
//            } else if (b == 'B') {
//                result.append("BA");
//            }
//        }
//        return result.toString();
//    }
//
//    protected String changeLetters(String s) {
//        String result = "";
//
//        for (byte b: s.getBytes()) {
//            if (b == 'A') {
//                result += "B";
//            } else if (b == 'B') {
//                result += "BA";
//            }
//        }
//        return result;
//    }
}
