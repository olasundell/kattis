import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/**
 * TODO write documentation
 */
public class Recount {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Recount().solve(in));
	}

	public String solve(Scanner in) {
		Map<String, Candidate> candidateMap = new HashMap<>();
		PriorityQueue<Candidate> candidates = new PriorityQueue<>();

		while (in.hasNextLine()) {
			String line = in.nextLine();
			if ("***".equals(line)) {
				break;
			}

			if (!candidateMap.containsKey(line)) {
				final Candidate value = new Candidate(line);
				candidateMap.put(line, value);
			} else {
				candidateMap.get(line).inc();
			}
		}

		candidates.addAll(candidateMap.values());

		Candidate top = candidates.poll();
		if (!candidates.isEmpty() && candidates.peek().count.equals(top.count)) {
			return "Runoff!";
		} else {
			return top.name;
		}
	}

	static class Candidate implements Comparable<Candidate> {
		private final String name;
		private Integer count;

		public Candidate(String name) {
			this.name = name;
			this.count = 1;
		}

		void inc() {
			count++;
		}

		@Override
		public int compareTo(Candidate o) {
			return o.count - this.count;
		}
	}
}
