import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/**
 * TODO write documentation
 */
public class Simplicity {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Simplicity().solve(in));
	}

	public String solve(Scanner in) {
		String s =in.next();
		Map<Character, CharCount> map = new HashMap<>();

		for (char c: s.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, new CharCount(c));
			}
			map.get(c).inc();
		}

		if (map.size() <= 2) {
			return "0";
		}

		PriorityQueue<CharCount> queue = new PriorityQueue<>(Comparator.comparingInt(CharCount::getCount));

		queue.addAll(map.values());

		int count = 0;
		while (queue.size() > 2) {
			count += queue.poll().getCount();
		}

		return String.valueOf(count);
	}

	private static class CharCount {
		private final Character c;
		private int count = 0;

		public CharCount(Character c) {
			this.c = c;
		}

		public int getCount() {
			return count;
		}

		public void inc() {
			this.count++;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			CharCount charCount = (CharCount) o;

			return c.equals(charCount.c);
		}

		@Override
		public int hashCode() {
			return c.hashCode();
		}
	}
}
