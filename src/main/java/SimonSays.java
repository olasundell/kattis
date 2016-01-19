import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class SimonSays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new SimonSays().solve(in));
    }

    public String solve(Scanner in) {
        List<String> list = new ArrayList<>();
        in.nextInt();
        while (in.hasNextLine()) {
            list.add(in.nextLine());
        }
        return list.stream()
                .filter((s) -> s.startsWith("Simon says"))
                .map((s) -> s.replaceAll("Simon says", ""))
                .collect(Collectors.joining("\n"));
    }
}
