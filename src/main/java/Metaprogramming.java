import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Metaprogramming {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Metaprogramming().solve(in));
	}

	public String solve(Scanner in) {
		Map<String, Integer> defines = new HashMap<>();
		List<String> evals = new ArrayList<>();

		while (in.hasNextLine()) {
			String line = in.nextLine();
			String[] split = line.split(" ");
			String command = split[0];

			switch (command) {
				case "define":
					String key = getKey(line, split[1]);
					Integer value = Integer.valueOf(split[1]);
					defines.put(key, value);
					break;
				case "eval":
					evals.add(eval(line, defines));
					break;
			}
		}
		return evals.stream()
				.collect(Collectors.joining("\n"));
	}

	protected String eval(String line, Map<String, Integer> defines) {
		String expression = line.substring(5);

		String vars[] = expression.split(" [><=] ");
		char operand = expression.charAt(vars[0].length() + 1);

		if (!defines.containsKey(vars[0]) || !defines.containsKey(vars[1])) {
			return "undefined";
		} else {
			int one = defines.get(vars[0]);
			int two = defines.get(vars[1]);

			switch (operand) {
				case '>':
					return one > two ? "true": "false";
				case '<':
					return one < two ? "true": "false";
				case '=':
					return one == two ? "true": "false";
			}
		}
		// this should be an exception.
		return "undefined";
	}

	protected String getKey(String line, String value) {
		return line.substring(line.indexOf(value) + value.length() + 1);
	}
}
