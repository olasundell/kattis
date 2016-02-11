import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Friday {
    private final static int FRIDAY = 5;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Friday().solve(in));
    }

    public String solve(Scanner in) {
        int n = in.nextInt();
        List<Integer> fridays = new ArrayList<>();

        for (int i = 0 ; i < n ; i++) {
            int daysInYear = in.nextInt();
            int monthsInYear = in.nextInt();
            List<Integer> monthLengths = new ArrayList<>();

            for (int j = 0 ; j < monthsInYear ; j++) {
                monthLengths.add(in.nextInt());
            }

            int currentDay = 0;
            int friday13 = 0;

            for (int l: monthLengths) {
                for (int j = 1 ; j <= l ; j++) {
                    if (j == 13 && currentDay == FRIDAY) {
                        friday13++;
                    }

                    currentDay = (currentDay + 1) % 7;
                }
            }

            fridays.add(friday13);
        }

        return fridays.stream().map(String::valueOf).collect(Collectors.joining("\n"));
    }
}
