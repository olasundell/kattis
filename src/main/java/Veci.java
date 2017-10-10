import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Veci {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Veci().solve(in));
	}

	public String solve(Scanner in) {

		final String next = in.next();
		List<Integer> numerals = new ArrayList<>();

		int num = Integer.valueOf(next);

		for (char c: next.toCharArray()) {
			numerals.add(c - '0');
		}

		List<Integer> solution = findSolution(numerals);

		return solution.stream().map(String::valueOf).collect(Collectors.joining());
	}

	private List<Integer> findSolution(List<Integer> numerals) {
		for (int k = numerals.size() - 2 ; k >= 0 ; k--) {
			if (numerals.get(k) < numerals.get(k + 1)) {
				for (int l = numerals.size() - 1 ; l > k ; l--) {
					if (numerals.get(l) > numerals.get(k)) {
						return swaperoo(numerals, k, l);
					}
				}
			}
		}

		return Collections.singletonList(0);
	}

	private List<Integer> swaperoo(List<Integer> numerals, int k, int l) {

		List<Integer> result = new ArrayList<>();
		if (k > 0) {
			result.addAll(numerals.subList(0, k));
		}

		result.add(numerals.get(l));

		List<Integer> copy = new ArrayList<>(numerals);
		copy.set(l, numerals.get(k));
		List<Integer> reversed = new ArrayList<>(copy.subList(k + 1, copy.size()));
		Collections.reverse(reversed);
		result.addAll(reversed);

		return result;
	}
}
