import java.util.Scanner;

/**
 * TODO write documentation
 */
public class HissingMicrophone {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new HissingMicrophone().solve(in));
	}

	public String solve(Scanner in) {
		String s = in.next();
		String ret = "hiss";
		if (!s.contains("ss")) {
			ret = "no " + ret;
		}
		return ret;
	}
}
