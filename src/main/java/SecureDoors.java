import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class SecureDoors {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new SecureDoors().solve(in));
	}

	public String solve(Scanner in) {
		// discard initial
		in.nextLine();
		List<String> result = new ArrayList<>();
		Set<String> entered = new HashSet<>();

		while (in.hasNextLine()) {
			String[] parts = in.nextLine().split(" ");
			String action = parts[0];
			String employee = parts[1];

			if ("entry".equals(action)) {
				String s = String.format("%s %s", employee, "entered");
				if (entered.contains(employee)) {
					s += " (ANOMALY)";
				} else {
					entered.add(employee);
				}

				result.add(s);
			} else {
				String s = String.format("%s %s", employee, "exited");
				if (!entered.contains(employee)) {
					s += " (ANOMALY)";
				} else {
					entered.remove(employee);
				}

				result.add(s);
			}
		}
		return result.stream().collect(Collectors.joining("\n"));
	}
}
