import java.math.BigInteger;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class SimpleAddition {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new SimpleAddition().solve(in));
	}

	public String solve(Scanner in) {
		BigInteger a = new BigInteger(in.next());
		BigInteger b = new BigInteger(in.next());

		return a.add(b).toString();
	}
}
