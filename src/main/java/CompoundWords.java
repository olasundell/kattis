import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class CompoundWords {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new CompoundWords().solve(in));
	}

	public String solve(Scanner in) {
		List<String> words = new ArrayList<>();

		while (in.hasNext()) {
			words.add(in.next());
		}

		SortedSet<String> compound = new TreeSet<>();

		for (int i = 0 ; i < words.size() ; i++) {
			for (int j = i + 1 ; j < words.size() ; j++) {
				compound.add(words.get(i) + words.get(j));
				compound.add(words.get(j) + words.get(i));
			}
		}
		return compound.stream().collect(Collectors.joining("\n"));
	}
}
