import java.util.ArrayList;
import java.util.Arrays;
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

	// TODO major cleanup
	public String solve(Scanner in) {
		List<Integer> firstIn = new ArrayList<>();

		for (char c: in.nextLine().toCharArray()) {
			firstIn.add(c - '0');
		}

		List<Integer> secondIn = new ArrayList<>();

		for (char c: in.nextLine().toCharArray()) {
			secondIn.add(c - '0');
		}

		int max = Math.max(firstIn.size(), secondIn.size());

		for (int i = 0 ; i < max - firstIn.size() ; i++) {
			firstIn.add(0, 0);
		}

		for (int i = 0 ; i < max - secondIn.size() ; i++) {
			secondIn.add(0, 0);
		}

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

		String f;
		String s;

		if (first.isEmpty()) {
			f = "YODA";
		} else {
			f = first.stream().map(String::valueOf).collect(Collectors.joining());
			f = String.valueOf(Integer.valueOf(f));
		}

		if (second.isEmpty()) {
			s = "YODA";
		} else {
			s = second.stream().map(String::valueOf).collect(Collectors.joining());
			s = String.valueOf(Integer.valueOf(s));
		}
		return f + "\n" + s;
	}
}
