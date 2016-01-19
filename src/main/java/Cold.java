import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Cold {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Cold().solve(in));
    }

    public String solve(Scanner in) {
        in.nextInt();

        List<Integer> temps = new ArrayList<>();

        while (in.hasNextInt()) {
            temps.add(in.nextInt());
        }

        return String.valueOf(temps.stream().filter((i) -> i < 0).count());
    }
}
