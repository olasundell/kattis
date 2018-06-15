package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class SparseArrays {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new SparseArrays().solve(in));
	}

	public String solve(Scanner in) {
		final int n = in.nextInt();

		List<String> strings = new ArrayList<>();
		List<Long> searches = new ArrayList<>();

		for (int i = 0 ; i < n ; i++) {
			strings.add(in.next());
		}

		final int m = in.nextInt();

		for (int i = 0 ; i < m ; i++) {
			searches.add(search(strings, in.next()));
		}

		return searches.stream().map(String::valueOf).collect(Collectors.joining("\n"));
	}

	private long search(List<String> strings, String word) {
		return strings.stream().filter(s -> s.equals(word)).count();
	}

//	private int searchOneString(String str, String word) {
//		System.err.println("Finding " + word + " in " + str);
//		Pattern p = Pattern.compile(word);
//		Matcher m = p.matcher(str);
//		int count = 0;
//
//		while (m.find()) {
//			count++;
//		}
//
//		return count;
//
//	}
}
