import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class OddManOut {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new OddManOut().solve(in));
    }

    public String solve(Scanner in) {
        List<String> results = new ArrayList<>();

        int numberOfCases = in.nextInt();

        for (int i = 0 ; i < numberOfCases ; i++) {
            Set<String> set = new HashSet<>();
            int n = in.nextInt();

            for (int j = 0; j < n; j++) {
                String str = in.next();
                if (set.contains(str)) {
                    set.remove(str);
                } else {
                    set.add(str);
                }
            }

            results.add(String.format("Case #%d: %s", i + 1, set.iterator().next()));
        }

        return results.stream().collect(Collectors.joining("\n"));
    }
}
