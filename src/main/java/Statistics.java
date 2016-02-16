import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

/**
 * TODO write documentation
 */
public class Statistics {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Statistics().solve(in));
    }

    public String solve(Scanner in) {
        List<Case> cases = new ArrayList<>();

        for (int i = 1 ; in.hasNextLine() ; i++) {
            IntSummaryStatistics summary = Arrays.stream(in.nextLine().split(" "))
                    .skip(1)
                    .mapToInt(Integer::parseInt)
                    .summaryStatistics();

            cases.add(new Case(i, summary.getMax(), summary.getMin()));
        }

        return cases.stream().map(Case::toString).collect(Collectors.joining("\n"));
    }

    private static class Case {
        final int num;
        final int max;
        final int min;

        public Case(int num, int max, int min) {
            this.num = num;
            this.max = max;
            this.min = min;
        }

        public String toString() {
            return String.format("Case %d: %d %d %d", num, min, max, max - min);
        }
    }
}
