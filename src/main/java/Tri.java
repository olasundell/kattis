import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Tri {
    public static void main(String[] args) {
        System.out.println(new Tri().solve(new Scanner(System.in)));
    }

    public String solve(Scanner scanner) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();

        char first = '=';
        char second = '=';

        if (x + y == z) {
            first = '+';
            second = '=';
        } else if (x - y == z) {
            first = '-';
            second = '=';
        } else if (x * y == z) {
            first = '*';
            second = '=';
        } else if (x / y == z) {
            first = '/';
            second = '=';
        } else if (x == y + z) {
            first = '=';
            second = '+';
        } else if (x == y - z) {
            first = '=';
            second = '-';
        } else if (x == y * z) {
            first = '=';
            second = '*';
        } else if (x == y / z) {
            first = '=';
            second = '/';
        }

        return String.format("%d%c%d%c%d", x, first, y, second, z);
    }
}
