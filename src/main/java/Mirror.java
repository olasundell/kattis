import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Mirror {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Mirror().solve(in));
	}

	public String solve(Scanner in) {
		List<List<String>> results = new ArrayList<>();
		int n = in.nextInt();
		in.nextLine();
		for (int i = 0 ; i < n ; i++) {
			List<String> r = new ArrayList<>();
			int rowN = in.nextInt();
			in.nextLine();

			for (int j = 0 ; j < rowN ; j++) {
				r.add(0, new StringBuilder(in.nextLine()).reverse().toString());
			}

			results.add(r);
		}

		AtomicInteger i = new AtomicInteger(1);

		return results.stream()
				.map(l -> "Test " + i.getAndIncrement() + "\n" + l.stream().collect(Collectors.joining("\n")))
				.collect(Collectors.joining("\n"));
	}
}
