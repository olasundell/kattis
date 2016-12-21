import java.util.Comparator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Cups {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Cups().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		SortedSet<Cup> cups = new TreeSet<>(Comparator.comparingInt(c -> c.diameter));
		for (int i = 0 ; i < n ; i++) {
			int dia;
			String c;
			if (in.hasNextInt()) {
				dia = in.nextInt();
				c = in.next();
			} else {
				c = in.next();
				dia = in.nextInt() * 2;
			}

			cups.add(new Cup(dia, c));
			in.nextLine();
		}

		return cups.stream().map(c -> c.colour).collect(Collectors.joining("\n"));
	}

	public static class Cup {
		final int diameter;
		final String colour;

		public Cup(int diameter, String colour) {
			this.diameter = diameter;
			this.colour = colour;
		}
	}
}
