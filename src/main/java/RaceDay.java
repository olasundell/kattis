import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class RaceDay {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new RaceDay().solve(in));
	}

	public String solve(Scanner in) {
		List<PriorityQueue<Runner>> results = new ArrayList<>();
		while (in.hasNext()) {
			int n = in.nextInt();
			if (n == 0) {
				break;
			}

			in.nextLine();

			Map<String, Runner> runners = createRunners(in, n);
			readTimes(in, runners, n);

			PriorityQueue<Runner> e = new PriorityQueue<>((r1, r2) -> {
				int v = r1.surName.compareTo(r2.surName);
				if (v == 0) {
					return r1.firstName.compareTo(r2.firstName);
				} else {
					return v;
				}
			});
			e.addAll(runners.values());
			results.add(e);
		}
		return constructString(results);
	}

	private String constructString(List<PriorityQueue<Runner>> results) {
		String str = results.stream().map(this::queueToString).collect(Collectors.joining("\n"));
		System.err.println(str);
		return str;


//		System.err.println(builder.toString());
//
//		return builder.toString();
	}

	private String queueToString(PriorityQueue<Runner> q) {
		String header = "NAME                       BIB    SPLIT1      RANK    SPLIT2      RANK    FINISH      RANK";
		StringBuilder builder = new StringBuilder();
		builder.append(header).append("\n");

		Map<String, Integer> sf1 = rank(q, Runner::getSplit1);
		Map<String, Integer> sf2 = rank(q, Runner::getSplit2);
		Map<String, Integer> f = rank(q, Runner::getFinish);

		while (!q.isEmpty()) {
			Runner runner = q.poll();
			String name = String.format("%s, %s", runner.surName, runner.firstName);
			builder.append(String.format("%-25s%5s%10s%10d%10s%10d%10s%10d",
					name,
					runner.number,
					asMmSs(runner.getSplit1()),
					sf1.get(runner.number),
					asMmSs(runner.getSplit2()),
					sf2.get(runner.number),
					asMmSs(runner.getFinish()),
					f.get(runner.number)));
				builder.append("\n");
		}

		return builder.toString();
	}

	private Map<String, Integer> rank(PriorityQueue<Runner> q, Function<Runner, Duration> getDuration) {
		Map<String, Integer> map = new HashMap<>();

		List<Runner> list = new ArrayList<>(q);
		list.sort(Comparator.comparing(getDuration));

		map.put(list.get(0).number, 1);

		for (int i = 1 ; i < list.size() ; i++) {
			Runner prevRunner = list.get(i - 1);
			Runner runner = list.get(i);
			if (getDuration.apply(runner).equals(getDuration.apply(prevRunner))) {
				map.put(runner.number, map.get(prevRunner.number));
			} else {
				map.put(runner.number, i + 1);
			}
		}

		return map;
	}

	private String asMmSs(Duration duration) {
		return String.format("%d:%02d", duration.toMinutes(), duration.get(ChronoUnit.SECONDS) % 60);
	}



	private void readTimes(Scanner in, Map<String, Runner> runners, int n) {
		for (int i = 0 ; i < n * 3 ; i++) {
			String number = in.next();
			String type = in.next();
			String time = in.next();
			in.nextLine();

			Runner r = runners.get(number);

			String[] split = time.split(":");

			int minutes = Integer.valueOf(split[0]);
			int seconds = Integer.valueOf(split[1]);

			Duration duration = Duration.of(minutes, ChronoUnit.MINUTES);
			duration = duration.plus(seconds, ChronoUnit.SECONDS);

			if ("S1".equals(type)) {
				r.split1 = duration;
			} else if ("S2".equals(type)) {
				r.split2 = duration;
			} else if ("F".equals(type)) {
				r.finish= duration;
			}
		}
	}

	private Map<String,Runner> createRunners(Scanner in, int n) {
		Map<String, Runner> map = new HashMap<>();

		for (int i = 0 ; i < n ; i++) {
			Runner r = new Runner(in.next(), in.next(), in.next());
//			System.err.println(r);
			in.nextLine();
			map.put(r.number, r);
		}

		return map;
	}

	private static class Runner {
		private final String firstName;
		private final String surName;
		private final String number;
		private Duration split1;
		private Duration split2;
		private Duration finish;

		public Runner(String firstName, String surName, String number) {
			this.firstName = firstName;
			this.surName = surName;
			this.number = number;
		}

		public Duration getSplit1() {
			return split1;
		}

		public Duration getSplit2() {
			return split2;
		}

		public Duration getFinish() {
			return finish;
		}

		@Override
		public String toString() {
			return "Runner{" +
					"firstName='" + firstName + '\'' +
					", surName='" + surName + '\'' +
					", number='" + number + '\'' +
					'}';
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Runner runner = (Runner) o;

			return number.equals(runner.number);
		}

		@Override
		public int hashCode() {
			return number.hashCode();
		}
	}
}
