import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Everywhere {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Everywhere().solve(in));
    }

    public String solve(Scanner in) {
        int rounds = in.nextInt();
        List<Integer> numberOfCities = new ArrayList<>();

        for (int i = 0 ; i < rounds ; i++) {
            int lines = in.nextInt();
            Set<String> cities = new HashSet<>();

            for (int j = 0; j < lines; j++) {
                cities.add(in.next());
            }

            numberOfCities.add(cities.size());
        }

        return numberOfCities.stream().map(String::valueOf).collect(Collectors.joining("\n"));
    }
}
