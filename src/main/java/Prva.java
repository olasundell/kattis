import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * TODO write documentation
 */
public class Prva {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Prva().solve(in));
	}

	public String solve(Scanner in) {
		in.nextLine();
		List<String> across = new ArrayList<>();
		List<String> down = new ArrayList<>();

		while (in.hasNextLine()) {
			across.add(in.nextLine());
		}

		for (int i = 0; i < across.get(0).length() ; i++) {
			StringBuilder builder = new StringBuilder();

			for (String acros : across) {
				builder.append(acros.charAt(i));
			}

			down.add(builder.toString());
		}

		SortedSet<String> words = new TreeSet<>();

		across.forEach(s -> addWords(words, s));
		down.forEach(s -> addWords(words, s));

		return words.first();
	}

	private void addWords(SortedSet<String> words, String s) {
		for (String w: s.split("#")) {
			if (w.length() > 1) {
				words.add(w);
			}
		}
	}
}
