import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Autori {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Autori().solve(in));
	}

	public String solve(Scanner in) {
		String s = in.next();
		String[] arr = s.split("-");

		return Arrays.stream(arr).map(a -> a.substring(0, 1)).collect(Collectors.joining());
	}
}
