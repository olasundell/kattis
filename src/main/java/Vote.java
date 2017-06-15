import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Vote {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Vote().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		List<String> results = new ArrayList<>();

		for (int i = 0 ; i < n ; i++) {
			int noOfCandidates = in.nextInt();
			PriorityQueue<Candidate> candidates = new PriorityQueue<>();

			for (int j = 1 ; j <= noOfCandidates ; j++) {
				candidates.add(new Candidate(j, in.nextInt()));
			}

			int sum = candidates.stream().sorted().mapToInt(c -> c.votes).sum();
			int sumWithoutFirst = candidates.stream().sorted().skip(1).mapToInt(c -> c.votes).sum();

			Candidate largest = candidates.poll();
			Candidate secondLargest = candidates.poll();

			if (largest.votes > sumWithoutFirst) {
				results.add("majority winner " + largest.id);
			} else if (secondLargest.votes == largest.votes) {
				results.add("no winner");
			} else {
				results.add("minority winner " + largest.id);
			}
		}
		return results.stream().collect(Collectors.joining("\n"));
	}

	private class Candidate implements Comparable<Candidate> {
		final int id;
		final int votes;

		Candidate(int id, int votes) {
			this.votes = votes;
			this.id = id;
		}

		@Override
		public int compareTo(Candidate o) {
			return o.votes - votes;
		}

		@Override
		public String toString() {
			return "Candidate{" +
					"id=" + id +
					", votes=" + votes +
					'}';
		}
	}
}
