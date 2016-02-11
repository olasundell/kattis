import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Different {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Different().solve(in));
    }

    public String solve(Scanner in) {
        List<Long> results = new ArrayList<>();

        while (in.hasNextLine()) {
            long a = in.nextLong();
            long b = in.nextLong();

            results.add(Math.abs(a - b));

            in.nextLine();
        }

        return results.stream().map(String::valueOf).collect(Collectors.joining("\n"));
    }
}
