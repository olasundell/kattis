import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Zoo {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Zoo().solve(in));
	}

	public String solve(Scanner in) {
		List<String> result = new ArrayList<>();
		for (int testCase = 1 ; ; testCase++) {
			Map<String, Integer> animals = new HashMap<>();
			int n = in.nextInt();
			if (n == 0) {
				break;
			}

			in.nextLine();

			for (int i = 0 ; i < n ; i++) {
				String animal = in.nextLine();
				if (animal.contains(" ")) {
					animal = animal.substring(animal.lastIndexOf(" ") + 1);
				}

				animal = animal.toLowerCase();

				int val = 1;
				if (animals.containsKey(animal)) {
					val = animals.get(animal) + 1;
				}
				animals.put(animal, val);
			}


			String s = animals.entrySet().stream()
					.sorted((o1, o2) -> o1.getKey().compareTo(o2.getKey()))
					.map((entry) -> String.format("%s | %d", entry.getKey(), entry.getValue()))
					.collect(Collectors.joining("\n"));

			result.add(String.format("List %d:\n%s", testCase, s));
		}
		return result.stream().collect(Collectors.joining("\n"));
	}
}
