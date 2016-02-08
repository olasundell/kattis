import java.util.Scanner;

/**
 * TODO write documentation
 */
public class AlphabetSpam {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new AlphabetSpam().solve(in));
    }

    // whitespace characters,
    // lowercase letters,
    // uppercase letters,
    // symbols
    public String solve(Scanner in) {
        String s = in.next();

        int whitespace = 0;
        int lowercase = 0;
        int uppercase = 0;
        int symbol = 0;

        for (Character c: s.replaceAll("_", " ").toCharArray()) {
            switch (Character.getType(c)) {
                case Character.UPPERCASE_LETTER:
                    uppercase++;
                    break;
                case Character.LOWERCASE_LETTER:
                    lowercase++;
                    break;
                case Character.DIRECTIONALITY_WHITESPACE:
                    whitespace++;
                    break;
                default:
                    symbol++;
                    break;
            }
        }

        return String.format("%.13g%n%.13g%n%.13g%n%.13g",
                (double)whitespace / s.length(),
                (double)lowercase / s.length(),
                (double)uppercase / s.length(),
                (double)symbol / s.length());
    }
}
