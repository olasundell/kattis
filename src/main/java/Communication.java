import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Communication {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Communication().solve(in));
    }

    public String solve(Scanner in) {
        int n = in.nextInt();
        List<Integer> integers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            String asBin = Integer.toBinaryString(x);
            StringBuilder result = new StringBuilder();
            char prev = '0';

            for (char c : asBin.toCharArray()) {
                if (c == prev) {
                    prev = '0';
                } else {
                    prev = '1';
                }
                result.append(prev);
            }

            integers.add(Integer.valueOf(result.toString(), 2));
        }

        return integers.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
