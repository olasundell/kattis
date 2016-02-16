import java.util.Scanner;

/**
 * TODO write documentation
 */
public class BestCompression {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new BestCompression().solve(in));
    }

    public String solve(Scanner in) {
        long numOfFiles = in.nextLong();
        long bits = in.nextLong();

        String s = Long.toBinaryString(numOfFiles);
        if (s.length() > (bits + 1)) {
            return "no";
        }

        return "yes";
    }
}
