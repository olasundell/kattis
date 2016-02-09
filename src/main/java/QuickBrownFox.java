import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class QuickBrownFox {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new QuickBrownFox().solve(in));
    }

    public String solve(Scanner in) {
        int n = in.nextInt();
        in.nextLine();
        List<String> results = new ArrayList<>();

        for (int i = 0 ; i < n ; i++) {
            SortedSet<Character> chars = new TreeSet<>(Comparator.naturalOrder());

            for (char c = 'a' ; c <= 'z' ; c++) {
                chars.add(c);
            }


            String next = in.nextLine();
            for (char c: next.toCharArray()) {
                char lowerCase = Character.toLowerCase(c);
                if (lowerCase <= 'z' && lowerCase >= 'a') {
                    chars.remove(Character.valueOf(lowerCase));
                }
            }

            if (chars.isEmpty()) {
                results.add("pangram");
            } else {
                results.add(String.format("missing %s", chars.stream().map(String::valueOf).collect(Collectors.joining())));
            }
        }
        return results.stream().collect(Collectors.joining("\n"));
    }
}
