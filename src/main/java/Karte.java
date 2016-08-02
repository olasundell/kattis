import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * TODO write documentation
 */
public class Karte {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Karte().solve(in));
	}

	public String solve(Scanner in) {
		Map<Character, Set<Integer>> deck = new HashMap<>();

		deck.put('P', new HashSet<>());
		deck.put('K', new HashSet<>());
		deck.put('H', new HashSet<>());
		deck.put('T', new HashSet<>());

		String line = in.nextLine();

		for (int i = 0 ; i < line.length() / 3 ; i++) {
			String current = line.substring(i * 3, i * 3 + 3);
			Integer value = Integer.valueOf(current.substring(1));
			char suite = current.charAt(0);

			if (deck.get(suite).contains(value)) {
				return "GRESKA";
			}

			deck.get(suite).add(value);
		}

		return String.format("%d %d %d %d",
				13 - deck.get('P').size(),
				13 - deck.get('K').size(),
				13 - deck.get('H').size(),
				13 - deck.get('T').size());
	}
}
