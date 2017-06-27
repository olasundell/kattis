import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Height {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Height().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		in.nextLine();

		List<String> results = new ArrayList<>();

		for (int i = 0 ; i < n ; i++) {
			String line = in.nextLine();
			String[] parts = line.split(" ");
			int lnum = Integer.valueOf(parts[0]);

			List<Integer> numbers = Arrays.stream(parts).skip(1).map(Integer::valueOf).collect(Collectors.toList());
			long sortLength = sort(numbers);
		}
		return "";
	}

	private long sort(List<Integer> numbers) {
		int current = 1;
		List<Integer> newList = new ArrayList<>();

		for (int i = 0 ; i < numbers.size() ; i++) {
			final Integer currentHeight = numbers.get(current);
			if (numbers.get(i) > currentHeight) {
				if (current == i) {
					break;
				} else {
					// switch
					numbers.add(i, currentHeight);
					numbers.remove(current);
				}
			}
		}

		return 0;
	}
}
