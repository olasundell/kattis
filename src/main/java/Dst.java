import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Dst {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Dst().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		List<String> results = new ArrayList<>();
		for (int i = 0 ; i < n ; i++) {
			int sign = "F".equals(in.next()) ? 1 : -1;

			int diff = in.nextInt() * sign;
			int hour = in.nextInt();
			int minute = in.nextInt();

			LocalTime time = LocalTime.of(hour, minute);
			final LocalTime plus = time.plus(diff, ChronoUnit.MINUTES);

			results.add(String.format("%d %d", plus.getHour(), plus.getMinute()));
		}
		return results.stream().collect(Collectors.joining("\n"));
	}
}
