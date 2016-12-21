import java.awt.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * TODO write documentation
 */
public class Cetvrta {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Cetvrta().solve(in));
	}

	public String solve(Scanner in) {
		Set<Integer> x = new HashSet<>();
		Set<Integer> y = new HashSet<>();

		for (int i = 0 ; i < 3 ; i++) {
			int o = in.nextInt();
			if (x.contains(o)) {
				x.remove(o);
			} else {
				x.add(o);
			}

			o = in.nextInt();
			if (y.contains(o)) {
				y.remove(o);
			} else {
				y.add(o);
			}
		}

		return x.iterator().next() + " " + y.iterator().next();
	}
}
