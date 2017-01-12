import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Babelfish {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Babelfish().solve(in));
	}

	public String solve(Scanner in) {
		String line;
		Map<String, String> dict = new HashMap<>();

		while (!(line = in.nextLine()).isEmpty()) {
			String[] split = line.split(" ");
			dict.put(split[1], split[0]);
		}

		List<String> result = new ArrayList<>();

		while (in.hasNextLine()) {
			result.add(dict.getOrDefault(in.nextLine(), "eh"));
		}
		return result.stream().collect(Collectors.joining("\n"));
	}
}
