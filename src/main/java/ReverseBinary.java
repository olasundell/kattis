import java.util.Scanner;

/**
 * TODO write documentation
 */
public class ReverseBinary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new ReverseBinary().solve(in));
    }

    public String solve(Scanner in) {
        String str = Integer.toBinaryString(in.nextInt());
        StringBuilder builder = new StringBuilder(str);
        int i = Integer.parseInt(builder.reverse().toString(), 2);

        return String.valueOf(i);
    }
}
