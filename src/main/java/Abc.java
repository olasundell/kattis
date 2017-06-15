import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Abc {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Abc().solve(in));
	}

	public String solve(Scanner in) {
		PriorityQueue<Integer> numbers = new PriorityQueue<>();

		while (in.hasNextInt()) {
			numbers.add(in.nextInt());
		}

		Map<Character, Integer> map = new HashMap<>();

		map.put('A', numbers.poll());
		map.put('B', numbers.poll());
		map.put('C', numbers.poll());

		String s = in.next();

		List<Integer> result = new ArrayList<>();

		for (char c: s.toCharArray()) {
			result.add(map.get(c));
		}

		return result.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(" "));
	}
}
