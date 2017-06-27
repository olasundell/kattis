import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Yoda {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Yoda().solve(in));
	}

	public String solve(Scanner in) {
		final String firstLine = in.nextLine();
		final String secondLine = in.nextLine();

		List<Integer> firstIn = createList(firstLine);
		List<Integer> secondIn = createList(secondLine);

		int max = Math.max(firstIn.size(), secondIn.size());

		pad(firstIn, max);
		pad(secondIn, max);

		List<Integer> first = new ArrayList<>();
		List<Integer> second = new ArrayList<>();

		// iterate over the two and combine, add remainder to the end of its corresponding builder

		for (int i = 0 ; i < max ; i++) {
			if (firstIn.get(i) >= secondIn.get(i)) {
				first.add(firstIn.get(i));
			}
			if (firstIn.get(i) <= secondIn.get(i)) {
				second.add(secondIn.get(i));
			}
		}

		String f = createString(first);
		String s = createString(second);

		return f + "\n" + s;
	}

	private List<Integer> createList(String line) {
		List<Integer> list = new ArrayList<>();
		for (char c: line.toCharArray()) {
			list.add(c - '0');
		}
		return list;
	}

	private String createString(List<Integer> list) {
		String f;
		if (list.isEmpty()) {
			f = "YODA";
		} else {
			f = list.stream().map(String::valueOf).collect(Collectors.joining());
			f = String.valueOf(Integer.valueOf(f));
		}
		return f;
	}

	private void pad(List<Integer> list, int max) {
		final int count = max - list.size();
		for (int i = 0; i < count; i++) {
			list.add(0, 0);
		}
	}
}
