import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class SnapperHard {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new SnapperHard().solve(in));
	}

	public String solve(Scanner in) {
		int cases = in.nextInt();
		List<Result> results = new ArrayList<>();

		for (int i = 0 ; i < cases ; i++) {
			int n = in.nextInt();
			int k = in.nextInt();
			List<Boolean> bools = new ArrayList<>();
			for (int j = 0 ; j < n ; j++) {
				bools.add(Boolean.FALSE);
			}

			for (int j = 0 ; j < k ; j++) {
				for (int current = 0; current < bools.size() ;) {
					if (bools.get(current)) {
						bools.set(current, false);
						current++;
					} else {
						bools.set(current, true);
						break;
					}
				}
			}
			results.add(new Result(i + 1, bools.stream().filter(b -> !b).count() == 0));
		}

		return results.stream().map(Result::toString).collect(Collectors.joining("\n"));
	}

	class Result {
		final int index;
		final boolean result;

		public Result(int index, boolean result) {
			this.index = index;
			this.result = result;
		}

		@Override
		public String toString() {
			return "Case #" + index + ": " + (result ? "ON" : "OFF");
		}
	}
}
