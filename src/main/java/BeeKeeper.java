import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class BeeKeeper {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new BeeKeeper().solve(in));
	}

	public String solve(Scanner in) {
		List<String> results = new ArrayList<>();

		for (;;) {
			int n = in.nextInt();

			if (n == 0) {
				break;
			}

			PriorityQueue<Word> queue = new PriorityQueue<>();

			for (int i = 0 ; i < n ; i++) {
				queue.add(new Word(in.next()));
			}

			results.add(queue.poll().word);
		}

		return results.stream().collect(Collectors.joining("\n"));
	}

	class Word implements Comparable<Word> {
		final String word;
		final int doubleVowels;

		public Word(String word) {
			this.word = word;
			this.doubleVowels = calcVowels(word);
		}

		int calcVowels(String word) {
			String s = word.replaceAll("(aa|ee|ii|oo|uu|yy)", "");
			return word.length() - s.length() / 2;
		}

		@Override
		public int compareTo(Word o) {
			return o.doubleVowels - this.doubleVowels;
		}
	}

	class DoubleVowelComparator implements Comparator<String> {
		Pattern pattern = Pattern.compile("(aa|ee|ii|oo|uu|yy)");

		@Override
		public int compare(String o1, String o2) {
			pattern.matcher(o1);
			pattern.matcher(o2);
			return 0;
		}
	}
}
