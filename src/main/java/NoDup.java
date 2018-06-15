import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO write documentation
 */
public class NoDup {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new NoDup().solve(in));
	}

	public String solve(Scanner in) {
		Map<String, AtomicInteger> map = new HashMap<>();

		while (in.hasNext()) {
			String s = in.next();
			map.computeIfAbsent(s, s1 -> new AtomicInteger(0)).getAndIncrement();
		}

		if (map.values().stream().anyMatch(i -> i.get() > 1)) {
			return "no";
		} else {
			return "yes";
		}
	}
}
