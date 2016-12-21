import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class FizzBuzz {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new FizzBuzz().solve(in));
	}

	public String solve(Scanner in) {
		int fizz = in.nextInt();
		int buzz = in.nextInt();
		int n = in.nextInt();

		List<String> result = new ArrayList<>();

		for (int i = 1 ; i <= n ; i++) {
			String s = "";

			if (i % fizz == 0) {
				s += "Fizz";
			}

			if (i % buzz == 0) {
				s += "Buzz";
			}

			if (s.isEmpty()) {
				s = String.valueOf(i);
			}

			result.add(s);
		}

		return result.stream().collect(Collectors.joining("\n"));
	}
}
