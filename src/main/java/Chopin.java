import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Chopin {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Chopin().solve(in));
	}

	public String solve(Scanner in) {
		Map<String, String> aliases = createAliases();
		List<String> cases = new ArrayList<>();
		int i = 0;

		while (in.hasNextLine()) {
			i++;
			String note = in.next();
			String tonality = in.next();
			String s;
			if (aliases.containsKey(note)) {
				s = aliases.get(note);
				cases.add(String.format("Case %d: %s %s", i, s, tonality));
			} else {
				cases.add(String.format("Case %d: UNIQUE", i));
			}
			in.nextLine();
		}

		return cases.stream().collect(Collectors.joining("\n"));
	}

	private Map<String,String> createAliases() {
		return new HashMap<String, String>() {{
			put("A#", "Bb");
			put("Bb", "A#");

			put("C#", "Db");
			put("Db", "C#");

			put("D#", "Eb");
			put("Eb", "D#");

			put("F#", "Gb");
			put("Gb", "F#");

			put("G#", "Ab");
			put("Ab", "G#");
		}};
	}
}
