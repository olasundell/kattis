import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class ClosingTheLoop {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new ClosingTheLoop().solve(in));
    }

    public String solve(Scanner in) {
        int n = in.nextInt();
        in.nextLine();
        List<Case> cases = new ArrayList<>();

        for (int i = 0 ; i < n ; i++) {
            in.nextLine();
            PriorityQueue<Segment> redSegments = new PriorityQueue<>();
            PriorityQueue<Segment> blueSegments = new PriorityQueue<>();

            String line = in.nextLine();
            for (String s: line.split(" ")) {
                Segment e = new Segment(s);
                if (e.color == Color.BLUE) {
                    blueSegments.add(e);
                } else {
                    redSegments.add(e);
                }
            }
            
            int total = 0;

            while (!blueSegments.isEmpty() && !redSegments.isEmpty()) {
                Segment blue = blueSegments.poll();
                Segment red = redSegments.poll();

                total += blue.length + red.length - 2;
            }
            cases.add(new Case(i + 1, total));
        }
        return cases.stream().map(Case::toString).collect(Collectors.joining("\n"));
    }

    private static class Segment implements Comparable<Segment> {
        final Color color;
        final int length;

        public Segment(String s) {
            length = Integer.valueOf(s.substring(0, s.length() - 1));
            switch (s.substring(s.length() - 1)) {
                case "R":
                    color = Color.RED;
                    break;
                case "B":
                    color = Color.BLUE;
                    break;
                default:
                    throw new IllegalStateException(s + " contains no valid colour");
            }
        }

        @Override
        public int compareTo(Segment o) {
            return o.length - this.length;
        }
    }

    private static class Case {
        final int num;
        final int answer;

        public Case(int num, int answer) {
            this.num = num;
            this.answer = answer;
        }

        public String toString() {
            return String.format("Case #%d: %d", num, answer);
        }
    }
}
