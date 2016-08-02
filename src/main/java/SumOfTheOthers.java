import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

/**
 * TODO write documentation
 */
public class SumOfTheOthers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new SumOfTheOthers().solve(in));
	}

	public String solve(Scanner in) {
		List<Integer> results = new ArrayList<>();

		while (in.hasNextLine()) {
			String line = in.nextLine();
			final AtomicInteger sum = new AtomicInteger(0);

			List<Integer> f = Arrays.stream(line.split(" "))
					.map(Integer::valueOf)
					.peek(i -> sum.addAndGet(i))
					.collect(Collectors.toList());

			for (int c: f) {
				if (sum.get() - c == c) {
					results.add(c);
					break;
				}
			}
		}

		return results.stream().map(String::valueOf).collect(Collectors.joining("\n"));
	}
}
