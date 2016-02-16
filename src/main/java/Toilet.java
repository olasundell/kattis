import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Toilet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Toilet().solve(in));
    }

    public String solve(Scanner in) {
        byte b = in.nextByte();
        String line = in.next();
        int upStrategy = 0;
        int downStrategy = 0;
        int leaveStrategy = 0;
        boolean up = b == 'U';

        char[] chars = line.toCharArray();

        for (char c: chars) {
            // strategy up
            if (!up) {
                upStrategy++;
            } else if (c == 'D') {
                upStrategy += 2;
            }
            // strategy down
            // strategy as used
        }
        return "";
    }
}
