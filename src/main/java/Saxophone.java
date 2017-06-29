import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Saxophone {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Saxophone().solve(in));
	}

	public String solve(Scanner in) {
		Map<Character, Set<Integer>> notes = setupNotes();
		List<List<Integer>> results = new ArrayList<>();

		int n = in.nextInt();
		in.nextLine();

		for (int i = 0 ; i < n ; i++) {
			SortedMap<Integer, Integer> fingers = createFingers();
			char[] tune = in.nextLine().toCharArray();
			Set<Integer> previousNote = Collections.emptySet();

			for (char c: tune) {
				Set<Integer> note = notes.get(c);

				diff(note, previousNote).forEach(f -> fingers.put(f, fingers.get(f) + 1));

				previousNote = note;
			}

			results.add(new ArrayList<>(fingers.values()));
		}

		return results.stream()
				.map(r -> r.stream()
						.map(String::valueOf)
						.collect(Collectors.joining(" ")))
				.collect(Collectors.joining("\n"));
	}

	private Set<Integer> diff(Set<Integer> note, Set<Integer> previous) {
		Set<Integer> result = new HashSet<>();

		note.forEach(n -> {
			if (!previous.contains(n)) {
				result.add(n);
			}
		});

		return result;
	}

	private SortedMap<Integer, Integer> createFingers() {
		SortedMap<Integer, Integer> fingers = new TreeMap<>();

		for (int i = 1 ; i <= 10 ; i++) {
			fingers.put(i, 0);
		}
		return fingers;
	}
	/*
	c: finger 2-4 , 7-10
d: finger 2-4 , 7-9
e: finger 2-4 , 7 , 8
f: finger 2-4 , 7
g: finger 2 -4
a: finger 2 , 3
b: finger 2
C: finger 3
D: finger 1 -4 , 7 -9
E: finger 1 -4 , 7 , 8
F: finger 1 -4 , 7
G: finger 1 -4
A: finger 1 -3
B: finger 1 -2
	 */

	private Map<Character, Set<Integer>> setupNotes() {
		final Map<Character, Set<Integer>> map = new HashMap<>();
		map.put('c', new HashSet<>(Arrays.asList(2, 3, 4, 7, 8, 9, 10)));
		map.put('d', new HashSet<>(Arrays.asList(2, 3, 4, 7, 8, 9)));
		map.put('e', new HashSet<>(Arrays.asList(2, 3, 4, 7, 8)));
		map.put('f', new HashSet<>(Arrays.asList(2, 3, 4, 7)));
		map.put('g', new HashSet<>(Arrays.asList(2, 3, 4)));
		map.put('a', new HashSet<>(Arrays.asList(2, 3)));
		map.put('b', new HashSet<>(Arrays.asList(2)));
		map.put('C', new HashSet<>(Arrays.asList(3)));
		map.put('D', new HashSet<>(Arrays.asList(1, 2, 3, 4, 7, 8, 9)));
		map.put('E', new HashSet<>(Arrays.asList(1, 2, 3, 4, 7, 8)));
		map.put('F', new HashSet<>(Arrays.asList(1, 2, 3, 4, 7)));
		map.put('G', new HashSet<>(Arrays.asList(1, 2, 3, 4)));
		map.put('A', new HashSet<>(Arrays.asList(1, 2, 3)));
		map.put('B', new HashSet<>(Arrays.asList(1, 2)));

		return map;
	}
}
