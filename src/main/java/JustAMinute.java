import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class JustAMinute {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new JustAMinute().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		double minutes = 0;
		double seconds = 0;

		for (int i = 0 ; i < n ; i++) {
			minutes += in.nextInt();
			seconds += in.nextInt();
		}

		double v = seconds / (minutes * 60);
		if (v > 1.0) {
			return String.format("%.9f", v);
		} else {
			return "measurement error";
		}
	}
}
