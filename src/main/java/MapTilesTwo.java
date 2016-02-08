import java.util.Scanner;

/**
 * TODO write documentation
 */
public class MapTilesTwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new MapTilesTwo().solve(in));
    }

    public String solve(Scanner in) {
        String quad = in.next();

        int length = quad.length();
        int x = 0;
        int y = 0;

        for (int i = 0 ; i < length ; i++) {
            int val = Integer.valueOf(quad.substring(i, i + 1));
            x += (val % 2) * Math.pow(2, length - i - 1);
            y += (val / 2) * Math.pow(2, length - i - 1);
        }

        return String.format("%d %d %d",
                length,
                x,
                y);
    }
}
