import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class HayPoints {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new HayPoints().solve(in));
	}

	public String solve(Scanner in) {
		int dictSize = in.nextInt();
		int noOfSentences = in.nextInt();

		Map<String, Integer> dict = new HashMap<>();

		for (int i = 0 ; i < dictSize ; i++) {
			dict.put(in.next(), in.nextInt());
		}

		List<Integer> sums = new ArrayList<>();

		for (int i = 0 ; i < noOfSentences ; i++) {
			String word;
			int sum = 0;

			while (!".".equals(word = in.next())) {
				if (dict.containsKey(word)) {
					sum += dict.get(word);
				}
			}

			sums.add(sum);
		}
		return sums.stream().map(String::valueOf).collect(Collectors.joining("\n"));
	}
}
