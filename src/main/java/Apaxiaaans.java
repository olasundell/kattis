import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Apaxiaaans {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Apaxiaaans().solve(in));
    }

    public String solve(Scanner in) {
        char prev = '_';
        StringBuilder builder = new StringBuilder();
        String s = in.next();

        for (char c : s.toCharArray()) {
            if (c != prev) {
                builder.append(c);
            }
            prev = c;
        }
        return builder.toString();
    }
}
