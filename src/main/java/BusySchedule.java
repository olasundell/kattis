import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class BusySchedule {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new BusySchedule().solve(in));
	}

	public String solve(Scanner in) {
		List<PriorityQueue<Time>> results = new ArrayList<>();


		while (in.hasNextLine()) {
			PriorityQueue<Time> queue = new PriorityQueue<>();
			int n = in.nextInt();
			in.nextLine();

			for (int i = 0 ; i < n ; i++) {
				queue.add(buildTime(in.nextLine()));
			}

			results.add(queue);
		}

		return results.stream()
				.map(q -> q.stream().map(Time::toString).collect(Collectors.joining("\n")))
				.collect(Collectors.joining("\n"));
	}

	private Time buildTime(String s) {
		String[] split = s.split(" ");

		String[] t = split[0].split(":");

		return new Time(Integer.valueOf(t[0]), Integer.valueOf(t[1]), "a.m.".equals(split[1]));
	}

	static class Time implements Comparable<Time> {
		final int hour;
		final int minute;
		final boolean am;

		Time(int hour, int minute, boolean am) {
			this.hour = hour;
			this.minute = minute;
			this.am = am;
		}

		@Override
		public String toString() {
			return String.format("%d:%02d %s", hour, minute, am ? "a.m." : "p.m.");
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Time)) {
				return false;
			}

			Time t = (Time) obj;

			return t.am == this.am &&
					t.minute == this.minute &&
					t.hour == this.hour;
		}

		@Override
		public int compareTo(Time o) {
			if (o.am && !this.am) {
				return 1;
			} else if (!o.am && this.am) {
				return -1;
			}

			if (this.hour != o.hour) {
				return this.hour - o.hour;
			}

			return this.minute - o.minute;
		}
	}
}
