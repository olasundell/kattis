import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class BusNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new BusNumbers().solve(in));
    }

    public String solve(Scanner in) {
        int n = in.nextInt();

        if (n == 0) {
            return "";
        }

        List<Integer> numbers = new ArrayList<>();

        while (in.hasNextInt()) {
            numbers.add(in.nextInt());
        }

        Collections.sort(numbers);

        List<String> results = new ArrayList<>();
        int consecutive = 1;
        for (int i = 0 ; i < numbers.size() ; i++) {
            while (consecutive + i < numbers.size() && numbers.get(i + consecutive) == numbers.get(i) + consecutive) {
                consecutive++;
            }
            if (consecutive > 2) {
                results.add(String.format("%d-%d", numbers.get(i), numbers.get(i) + consecutive - 1));
                i += consecutive - 1;
            } else {
                results.add(String.valueOf(numbers.get(i)));
            }
            consecutive = 1;
        }

        return results.stream().collect(Collectors.joining(" "));
    }

    @Deprecated
    public String solve2(Scanner in) {
        int n = in.nextInt();

        if (n == 0) {
            return "";
        }

        SortedSet<Integer> numbers = new TreeSet<>();
        List<String> results = new ArrayList<>();

        while (in.hasNextInt()) {
            numbers.add(in.nextInt());
        }

        Iterator<Integer> it = numbers.iterator();
        int prev = it.next();
        int consecutive = 1;
        int now = prev;

        // fugly
        while (it.hasNext()) {
            now = it.next();
            if (prev + consecutive == now) {
                consecutive++;
            } else {
                if (consecutive > 2) {
                    results.add(String.format("%d-%d", prev, prev + consecutive - 1));
                } else  {
                    results.add(String.valueOf(prev));
                    if (consecutive == 2) {
                        results.add(String.valueOf(prev + 1));
                    }
                }
                consecutive = 1;
                prev = now;
            }
        }

        if (results.isEmpty() || !results.get(results.size() -1 ).contains("-")) {
            results.add(String.valueOf(now));
        }

        return results.stream().collect(Collectors.joining(" "));
    }
}
