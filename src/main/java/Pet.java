import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Pet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Pet().solve(in));
    }

    public String solve(Scanner in) {
        Queue<Score> scores = new PriorityQueue<>((s, s1) -> s1.total - s.total);

        for (int i = 0 ; i < 5 ; i++) {
            int total = Arrays.asList(in.nextLine().split(" "))
                    .stream()
                    .mapToInt(Integer::valueOf)
                    .sum();

            scores.add(new Score(total, i + 1));
        }
        return String.format("%d %d",
                scores.peek().place,
                scores.peek().total);
    }

    public static class Score {
        int total;
        int place;

        public Score(int total, int place) {
            this.total = total;
            this.place = place;
        }
    }
}
