import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Bijele {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Bijele().solve(in));
	}

	public String solve(Scanner in) {
		List<Integer> should = Arrays.asList(1, 1, 2, 2, 2, 8);
		List<Integer> would = new ArrayList<>();

		should.forEach(s -> would.add(s - in.nextInt()));

		return would.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(" "));
	}
}
