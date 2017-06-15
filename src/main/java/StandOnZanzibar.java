import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class StandOnZanzibar {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new StandOnZanzibar().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		in.nextLine();

		List<String> results = new ArrayList<>();
		for (int i = 0 ; i < n ; i++) {
			results.add(once(in.nextLine()));
		}
		return results.stream().collect(Collectors.joining("\n"));
	}

	private String once(String s) {
		String[] arr = s.split(" ");
		List<Integer> nums = Arrays.stream(arr).map(Integer::valueOf).filter(i -> i != 0).collect(Collectors.toList());

		int immigrants = 0;
		int current = nums.get(0);

		for (int num: nums.subList(1, nums.size())) {
			if (num > current * 2) {
				immigrants += num - current * 2;
			}
			current = num;
		}

		return String.valueOf(immigrants);
	}
}
