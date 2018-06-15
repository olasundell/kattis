import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class SidewaysSorting {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new SidewaysSorting().solve(in));
	}

	public String solve(Scanner in) {
		List<String> results = new ArrayList<>();
		for (;;) {
			int x = in.nextInt();
			int y = in.nextInt();

			if (x == 0 && y == 0) {
				break;
			}

			List<List<Character>> arr = new ArrayList<>();

			for (int i = 0; i < y; i++) {
				List<Character> line = new ArrayList<>();
				for (Character c: in.next().toCharArray()) {
					line.add(c);
				}

				arr.add(line);
			}

			PriorityQueue<PosChar> queue = new PriorityQueue<>();
			for (int i = 0 ; i < arr.size() ; i++) {
				queue.add(new PosChar(String.valueOf(arr.get(0).get(i)), i));
			}

			while (!queue.isEmpty()) {

			}
		}

		return "";
	}

	class PosChar implements Comparable<PosChar> {
		final String s;
		final int pos;

		public PosChar(String s, int pos) {
			this.s = s;
			this.pos = pos;
		}

		@Override
		public int compareTo(PosChar o) {
			return o.s.toLowerCase().compareTo(this.s.toLowerCase());
		}
	}
}
