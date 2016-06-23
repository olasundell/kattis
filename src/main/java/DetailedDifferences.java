import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class DetailedDifferences {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new DetailedDifferences().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		// discard the end of line
		in.nextLine();
		List<Result> results = new ArrayList<>();

		for (int i = 0 ; i < n ; i++) {
			String one = in.nextLine();
			String two = in.nextLine();
			StringBuilder builder = new StringBuilder();

			byte[] oneBytes = one.getBytes();
			byte[] twoBytes = two.getBytes();

			for (int j = 0 ; j < one.length() ; j++) {
				if (oneBytes[j] == twoBytes[j]) {
					builder.append('.');
				} else {
					builder.append('*');
				}
			}

			results.add(new Result(one, two, builder.toString()));
		}
		return results.stream()
				.map(Result::toString)
				.collect(Collectors.joining("\n\n")) + "\n";
	}

	private static class Result {
		String first;
		String second;
		String diff;

		public Result(String first, String second, String diff) {
			this.first = first;
			this.second = second;
			this.diff = diff;
		}

		public String toString() {
			return String.format("%s\n%s\n%s", first, second, diff);
		}
	}
}
