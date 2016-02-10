import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class PlantingTrees {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new PlantingTrees().solve(in));
    }

    public String solve(Scanner in) {
        int max;
        in.nextInt();
//        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b.intValue() - a.intValue());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        while (in.hasNextInt()) {
            queue.add(in.nextInt());
        }

        max = queue.peek() + 1;

        int i = 1;
        while (queue.size() > 0) {
            int n = queue.poll();
            if (max < n + i) {
                max = n + i;
            }

            i++;
        }

        return String.valueOf(max + 1);
    }
}
