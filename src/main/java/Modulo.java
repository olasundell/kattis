import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * TODO write documentation
 */
public class Modulo {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Modulo().solve(in));
	}

	public String solve(Scanner in) {
		Set<Integer> mods = new HashSet<>();

		while (in.hasNext()) {
			mods.add(in.nextInt() % 42);
		}

		return String.valueOf(mods.size());
	}
}
