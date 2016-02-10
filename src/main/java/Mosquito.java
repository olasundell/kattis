import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Mosquito {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Mosquito().solve(in));
    }

    public String solve(Scanner in) {
        List<String> results = new ArrayList<>();

        while (in.hasNextInt()) {
            int mosquitoes = in.nextInt();
            int pupae = in.nextInt();
            int larvae = in.nextInt();
            int eggsPerMosquito = in.nextInt();
            int larvaeSurvivalRate = in.nextInt();
            int pupaeSurvivalRate = in.nextInt();
            int weeks = in.nextInt();


            for (int i = 0; i < weeks; i++) {
                int eggs = mosquitoes * eggsPerMosquito;
                mosquitoes = pupae / pupaeSurvivalRate;
                pupae = larvae / larvaeSurvivalRate;
                larvae = eggs;
            }

            results.add(String.valueOf(mosquitoes));
        }

        return results.stream().collect(Collectors.joining("\n"));
    }
}
