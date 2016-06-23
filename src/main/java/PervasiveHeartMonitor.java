import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class PervasiveHeartMonitor {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new PervasiveHeartMonitor().solve(in));
	}

	public String solve(Scanner in) {
		List<MonitorResult> monitorResults = new ArrayList<>();

		while (in.hasNextLine()) {
			String line = in.nextLine();

			MonitorResult monitorResult = new MonitorResult();
			List<Double> measurements = new ArrayList<>();

			for (String s : line.split(" ")) {
				try {
					Double d = Double.valueOf(s);
					measurements.add(d);
				} catch (NumberFormatException e) {
					monitorResult.name.add(s);
				}
			}

			monitorResult.average = measurements.stream()
					.mapToDouble(d -> d)
					.average()
					.getAsDouble();

			monitorResults.add(monitorResult);
		}

		return monitorResults.stream()
				.map(MonitorResult::toString)
				.collect(Collectors.joining("\n"));
	}

	private static class MonitorResult {
		List<String> name = new ArrayList<>();
		double average;

		public String toString() {
			return String.format("%.6f %s", average, name.stream().collect(Collectors.joining(" ")));
		}
	}
}
