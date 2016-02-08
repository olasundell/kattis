import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class ReverseRot {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new ReverseRot().solve(in));
    }

    public String solve(Scanner in) {
        List<Character> alphabet = new ArrayList<>();
        Map<Character, Integer> indexOf = new HashMap<>();

        for (char c: "ABCDEFGHIJKLMNOPQRSTUVWXYZ_.".toCharArray()) {
            alphabet.add(c);
            indexOf.put(c, alphabet.size() - 1);
        }

        int step;
        List<String> rotated = new ArrayList<>();

        while ((step = in.nextInt()) != 0) {
            String toRotate = in.next();
            StringBuilder builder = new StringBuilder();

            for (char c: toRotate.toCharArray()) {
                int index = indexOf.get(c);
                builder.insert(0, alphabet.get((index + step) % alphabet.size()));
            }

            rotated.add(builder.toString());
        }

        return rotated.stream().collect(Collectors.joining("\n"));
    }
}
