import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Oddities {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Oddities().solve(in));
    }

    public String solve(Scanner in) {
        int n = in.nextInt();
        StringBuilder builder = new StringBuilder();

        for (int i = 0 ; i < n ; i++) {
            int x = in.nextInt();
            String s;
            if (x == 0 || x % 2 == 0) {
                s = "even";
            } else {
                s = "odd";
            }
            builder.append(String.format("%d is %s", x, s));

            if (i != n -1) {
                builder.append('\n');
            }
        }
        return builder.toString();
    }
}
