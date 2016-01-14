import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Acm {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Acm().solve(in));
    }

    public String solve(Scanner in) {
        Map<String, Problem> problems = new HashMap<>();

        String line = "";

        while (!"-1".equals((line = in.nextLine()))) {
            String[] split = line.split(" ");

            int currentTime = Integer.valueOf(split[0]);
            String problemId = split[1];
            boolean success = "right".equals(split[2]);

            problems.putIfAbsent(problemId, new Problem());
            Problem problem = problems.get(problemId);

            problem.time = currentTime;

            if (!success) {
                problem.failures++;
            } else {
                problem.solved = true;
            }
        }

        List<Problem> collect = problems.values()
                .stream()
                .filter((p) -> p.solved)
                .collect(Collectors.toList());

        return String.format("%d %d",
                collect.size(),
                collect.stream()
                        .mapToInt(Problem::time)
                        .sum());
    }

    public static class Problem {
        boolean solved = false;
        int time;
        int failures;

        public int time() {
            return time + failures * 20;
        }
    }
}
