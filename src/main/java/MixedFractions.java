import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class MixedFractions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new MixedFractions().solve(in));
    }

    public String solve(Scanner in) {
        String line = "";
        List<String> fractions = new ArrayList<>();

        while (!"0 0".equals((line = in.nextLine()))) {
            int numerator = Integer.valueOf(line.split(" ")[0]);
            int denominator = Integer.valueOf(line.split(" ")[1]);

            fractions.add(String.format("%d %d / %d",
                    numerator / denominator,
                    numerator % denominator,
                    denominator));
        }

        return fractions.stream().collect(Collectors.joining("\n"));
    }
}
