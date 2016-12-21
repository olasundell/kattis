import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Pot {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Pot().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		in.nextLine();
		List<Pair> pairs = new ArrayList<>();

		for (int i = 0 ; i < n ; i++) {
			String s = in.nextLine();
			String s1 = s.substring(0, s.length() - 1);
			pairs.add(new Pair(Integer.valueOf(s1),
					Integer.valueOf(s.substring(s.length() - 1))));
		}

		return String.valueOf(pairs.stream().mapToInt(Pair::sum).sum());
	}

	public static class Pair {
		private final int number;
		private int pow;

		public Pair(int number, int pow) {
			this.number = number;
			this.pow = pow;
		}

		public int sum() {
			return (int) Math.pow(number, pow);
		}
	}
}
