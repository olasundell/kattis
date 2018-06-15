import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * TODO write documentation
 */
public class CookingWater {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new CookingWater().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();

		Set<Integer> set = range(in.nextInt(), in.nextInt());

		for (int i = 1 ; i < n ; i++) {
			set.retainAll(range(in.nextInt(), in.nextInt()));
		}

		if (set.isEmpty()) {
			return "edward is right";
		} else {
			return "gunilla has a point";
		}
	}

	private Set<Integer> range(int start, int end) {
		Set<Integer> set = new HashSet<>();

		for (int i = start ; i <= end ; i++) {
			set.add(i);
		}

		return set;
	}
}
