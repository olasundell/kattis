import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Aaah {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Aaah().solve(in));
    }

    public String solve(Scanner in) {
        String available = in.next();
        String expected = in.next();

        if (available.length() < expected.length()) {
            return "no";
        } else {
            return "go";
        }
    }
}
