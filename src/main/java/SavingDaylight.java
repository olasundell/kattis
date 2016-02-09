import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class SavingDaylight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new SavingDaylight().solve(in));
    }

    public String solve(Scanner in) {
        List<String> results = new ArrayList<>();
        while (in.hasNext()) {
            String month = in.next();
            String date = in.next();
            String year = in.next();

            String startStr = in.next();
            String endStr = in.next();

            String[] split = startStr.split(":");
            LocalTime start = LocalTime.of(Integer.valueOf(split[0]), Integer.valueOf(split[1]));

            split = endStr.split(":");
            LocalTime end = LocalTime.of(Integer.valueOf(split[0]), Integer.valueOf(split[1]));

            Duration duration = Duration.between(start, end);

            results.add(String.format("%s %s %s %s hours %s minutes",
                    month, date, year, duration.toHours(), duration.toMinutes() % 60));
        }

        return results.stream().collect(Collectors.joining("\n"));
    }
}
