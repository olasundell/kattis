import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO write documentation
 */
public class SynchronizingLists {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new SynchronizingLists().solve(in));
    }

    public String solve(Scanner in) {
        int n;
        List<String> solutions = new ArrayList<>();

        while ((n = in.nextInt()) != 0) {
            List<Integer> first = new ArrayList<>();
            List<Integer> second = new ArrayList<>();

            for (int i = 0 ; i < n ; i++) {
                first.add(in.nextInt());
            }

            for (int i = 0 ; i < n ; i++) {
                second.add(in.nextInt());
            }

            List<Integer> firstSorted = new ArrayList<>(first);
            List<Integer> secondSorted = new ArrayList<>(second);

            Collections.sort(firstSorted);
            Collections.sort(secondSorted);

            Integer[] secondCorrect = new Integer[n];

            for (int i = 0 ; i < n ; i++) {
                int index = first.indexOf(firstSorted.get(i));
                secondCorrect[index] = secondSorted.get(i);
            }

            solutions.add(Stream.of(secondCorrect).map(String::valueOf).collect(Collectors.joining("\n")));
        }

        return solutions.stream().collect(Collectors.joining("\n\n"));
    }
}
