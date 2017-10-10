import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class VariableArithmetic {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new VariableArithmetic().solve(in));
	}

	public String solve(Scanner in) {
		List<String> results = new ArrayList<>();
		Map<String, Integer> variables = new HashMap<>();
		String line = in.nextLine();

		for ( ; ; ) {
			if ("0".equals(line)) {
				break;
			}

			if (line.contains(" = ")) {
				final String[] split = line.split(" = ");
				variables.put(split[0], Integer.valueOf(split[1]));
			} else {
				results.add(parseExpression(line, variables));
			}

			line = in.nextLine();
		}

		return results.stream().collect(Collectors.joining("\n"));
	}

	private String parseExpression(String s, Map<String, Integer> variables) {
		Integer sum = null;
		List<String> resultParts = new ArrayList<>();
		String[] line = s.split(" [+] ");

		for (String part: line) {
			if (part.matches("[0-9]+")) {
				sum = add(sum, Integer.valueOf(part));
			} else if (variables.containsKey(part)) {
				sum = add(sum, variables.get(part));
			} else {
				resultParts.add(part);
			}
		}

		if (sum != null) {
			resultParts.add(0, String.valueOf(sum));
		}

		return resultParts.stream().collect(Collectors.joining(" + "));
	}

	private Integer add(Integer a, Integer b) {
		if (a == null) {
			return b;
		} else {
			return a + b;
		}
	}
}
