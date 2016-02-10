import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Simon {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Simon().solve(in));
    }

    public String solve(Scanner in) {
        List<String> list = new ArrayList<>();
        in.nextLine();
        while (in.hasNextLine()) {
            list.add(in.nextLine());
        }
        return list.stream()
                .map((s) -> {
                    if (!s.startsWith("simon says ")) {
                        return "";
                    }
                    return s;
                })
                .map((s) -> s.replaceAll("simon says ", ""))
                .collect(Collectors.joining("\n"));
    }
}
