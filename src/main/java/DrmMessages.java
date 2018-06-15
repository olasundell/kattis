import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class DrmMessages {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new DrmMessages().solve(in));
	}

	public String solve(Scanner in) {
		final String orig = in.next();

		final String left = orig.substring(0, orig.length() / 2);
		final String right = orig.substring(orig.length() / 2);

		final List<Integer> leftRot = sumAndRotate(left);
		final List<Integer> rightRot = sumAndRotate(right);

		return rotateAndConvert(leftRot, rightRot);
	}

	private String rotateAndConvert(List<Integer> leftRot, List<Integer> rightRot) {
		StringBuilder builder = new StringBuilder();

		for (int i = 0 ; i < leftRot.size() ; i++) {
			final int c = (leftRot.get(i) + rightRot.get(i)) % 26 + 'A';
			builder.append(Character.valueOf((char) c));
		}

		return builder.toString();
	}

	private List<Integer> sumAndRotate(String str) {
		return rotate(str, sum(str));
	}

	private int sum(String str) {
		return str.chars().map(i -> i - 'A').sum();
	}

	private List<Integer> rotate(String str, int rot) {
		return str.chars()
				.map(i -> i - 'A')
				.map(i -> (i + rot) % 26)
				.boxed()
				.collect(Collectors.toList());
	}
}
