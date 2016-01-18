import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class SymmetricOrder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new SymmetricOrder().solve(in));
    }

    public String solve(Scanner in) {
        int n;
        int currentSet = 0;

        List<String> lines = new ArrayList<>();

        while ((n = in.nextInt()) != 0) {
            lines.add("SET " + ++currentSet);
            List<String> names = new ArrayList<>();
            for (int i = 0 ; i < n ; i++) {
                names.add((int) Math.ceil(names.size() / 2.0),  in.next());
            }

            lines.addAll(names);
        }

        return lines.stream().collect(Collectors.joining("\n"));
    }
}
