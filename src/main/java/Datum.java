import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Datum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Datum().solve(in));
	}

	public String solve(Scanner in) {
		int d = in.nextInt();
		int m = in.nextInt();

		return LocalDate.of(2009, m, d).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
	}
}
