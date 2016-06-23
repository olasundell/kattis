import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Timeloop {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Timeloop().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		List<String> result = new ArrayList<>();

		for (int i = 1 ; i <= n ; i++) {
			result.add(i + " Abracadabra");
		}

		return result.stream().collect(Collectors.joining("\n"));
	}
}
