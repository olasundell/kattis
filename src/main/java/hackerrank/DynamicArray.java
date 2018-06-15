package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class DynamicArray {
	private static final int APPEND = 1;
	private static final int PRINT = 2;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new DynamicArray().solve(in));
	}

	public String solve(Scanner in) {
		List<Integer> output = new ArrayList<>();
		final List<List<Integer>> array = new ArrayList<>();
		int n = in.nextInt();

		for (int i = 0 ; i < n ; i++) {
			array.add(new ArrayList<>());
		}

		int rows = in.nextInt();
		int lastAnswer = 0;

		for (int i = 0; i < rows; i++) {
			final int operand = in.nextInt();
			final int x = in.nextInt();
			final int y = in.nextInt();

			final int index = (x ^ lastAnswer) % n;
			final List<Integer> integers = array.get(index);

			switch (operand) {
				case APPEND:
					integers.add(y);
					break;
				case PRINT:
					lastAnswer = integers.get(y % integers.size());
					output.add(lastAnswer);
					break;
			}
		}

		return output.stream().map(String::valueOf).collect(Collectors.joining("\n"));
	}
}
