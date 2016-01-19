import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Easiest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Easiest().solve(in));
    }

    public String solve(Scanner in) {
        String s;
        List<Integer> answers = new ArrayList<>();

        while (!"0".equals((s = in.next()))) {
            int sum = split(s).stream().mapToInt(Integer::intValue).sum();
            int sVal = Integer.valueOf(s);

            for (int i = 11 ; i < 5_000_000 ; i++) {
                int possible = split(String.valueOf(i * sVal)).stream().mapToInt(Integer::intValue).sum();
                if (possible == sum) {
                    answers.add(i);
                    break;
                }
            }
        }
        return answers.stream().map(String::valueOf).collect(Collectors.joining("\n"));
    }

    protected List<Integer> split(String s) {
        List<Integer> list = new ArrayList<>();
        for (char c: s.toCharArray()) {
            list.add(c - '0');
        }

        return list;
    }
}
