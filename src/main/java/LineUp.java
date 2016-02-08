import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * TODO write documentation
 */
public class LineUp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new LineUp().solve(in));
    }

    public String solve(Scanner in) {
        int noOfNames = in.nextInt();

        if (noOfNames == 0) {
            return "NEITHER";
        }

        SortedSet<String> increasing = new TreeSet<>(Comparator.naturalOrder());
        SortedSet<String> decreasing = new TreeSet<>(Comparator.reverseOrder());
        List<String> actual = new ArrayList<>();

        for (int i = 0; i < noOfNames; i++) {
            String name = in.next();

            increasing.add(name);
            decreasing.add(name);
            actual.add(name);
        }

        Iterator<String> incIt = increasing.iterator();
        Iterator<String> decIt = decreasing.iterator();
        Iterator<String> actIt = actual.iterator();

        boolean inc = true;
        boolean dec = true;

        while (actIt.hasNext()) {
            String next = actIt.next();
            if (!next.equals(incIt.next())) {
                inc = false;
            }

            if (!next.equals(decIt.next())) {
                dec = false;
            }
        }

        if (dec) {
            return "DECREASING";
        }

        if (inc) {
            return "INCREASING";
        }

        return "NEITHER";
    }
}
