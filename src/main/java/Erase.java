import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Erase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Erase().solve(in));
    }

    public String solve(Scanner in) {
        int n = in.nextInt();
        String orig = in.next();
        String result = in.next();
        boolean success = true;

        for (int i = 0 ; i < orig.length() ; i++) {
            if (n % 2 == 0) {
                if (orig.charAt(i) != result.charAt(i)) {
                    success = false;
                    break;
                }
            } else {
                if (orig.charAt(i) == result.charAt(i)) {
                    success = false;
                    break;
                }
            }
        }
        return String.format("Deletion %s", success ? "succeeded" : "failed");
    }
}
