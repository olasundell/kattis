import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class HelpAPhD {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new HelpAPhD().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		List<String> out = new ArrayList<>();

		for (int i = 0 ; i < n ; i++) {
			out.add(calc(in.next()));
		}

		return out.stream().collect(Collectors.joining("\n"));
	}

	private String calc(String next) {
		if ("P=NP".equals(next)) {
			return "skipped";
		}
		String[] split = next.split("[+]");

		return String.valueOf(Integer.valueOf(split[0]) + Integer.valueOf(split[1]));
	}
}
