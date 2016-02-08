import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Server {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Server().solve(in));
    }

    public String solve(Scanner in) {
        int expected = in.nextInt();
        int time = in.nextInt();
        int run = 0;

        for (int i = 0 ; i < expected ; i++) {
            time -= in.nextInt();
            if (time >= 0) {
                run++;
            } else {
                break;
            }
        }

        return String.format("%d", run);
    }
}
