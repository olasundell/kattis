package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class SubstringDiff {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new SubstringDiff().solve(in));
	}

	public String solve(Scanner in) {
		List<Integer> results = new ArrayList<>();

		int n = in.nextInt();
		for (int i = 0 ; i < n ; i++) {
			int allowedDiff = in.nextInt();
			String one = in.next();
			String two = in.next();
			System.err.println(allowedDiff + " " + one + " " + two);

			results.add(slideOptimised(one.toCharArray(), two.toCharArray(), allowedDiff));
		}
		return results.stream().map(String::valueOf).collect(Collectors.joining("\n"));
	}

	private int slideOptimised(char[] one, char[] two, int i, int j, int maxDiff) {
		int best = 0;
		int bad = 0;
		int newI = i;
		int newJ = j;
		int l = 0;
		for (;;) {
			if (newI + l >= one.length || newJ + l >= one.length) {
				best = Math.max(best, l);
				break;
			}

			if (one[newI + l] != two[newJ + l]) {
				bad++;
			}

			if (bad > maxDiff) {
				best = Math.max(best, l);

				while (one[newI] == two[newJ]) {
					newI++; newJ++; l--;
				}
				bad--;
				newI++; newJ++;
			} else {
				l++;
			}
		}
		return best;

	}

	private int slideOptimised(char[] one, char[] two, int maxDiff) {
		int best = 0;
		for (int i = 0 ; i < one.length ; i++) {
			best = Math.max(best, slideOptimised(one, two, 0, i, maxDiff));
			best = Math.max(best, slideOptimised(one, two, i, 0, maxDiff));
		}
		return best;
	}

	protected int slideOnwards(char[] one, char[] two, int maxDiff) {
		int best = 0;
		for (int i = 0 ; i < one.length ; i++) {
			for (int j = 0 ; j < one.length ; j++) {
				int bad = 0;

				for (int l = 0 ; l <= one.length ; l++) {
					if (i + l >= one.length || j + l >= one.length) {
						best = Math.max(best, l);
						break;
					}
					if (one[i + l] != two[j + l]) {
						bad++;
					}
					if (bad > maxDiff) {
						best = Math.max(best, l);
						break;
					}
				}

			}
		}

		return best;
	}

	private int windowSlide(int allowedDiff, String one, String two) {
		for (int windowSize = one.length() ; windowSize > 0 ; windowSize--) {
			for (int j = 0; j <= one.length() - windowSize; j++) {
				String substring = one.substring(j, windowSize + j);
				for (int k = 0 ; k <= one.length() - windowSize ; k++) {
					String substring1 = two.substring(k, windowSize + k);
					if (sortaEquals(substring, substring1, allowedDiff)) {
						return windowSize;
					}
				}
			}
		}

		return -1;
	}

	protected int letItSlide(String s1, String s2, int allowedDiff) {
		char[] one = s1.toCharArray();
		char[] two = s2.toCharArray();
		int left = 0;
		int right;
		int max = 0;
		int currentDiff = 0;
		String subOne;
		String subTwo;

		for (right = 0 ; right < one.length ; right++) {
			subOne = s1.substring(left, right + 1);
			subTwo = s2.substring(left, right + 1);
			if (one[right] != two[right]) {
				currentDiff++;
				while (currentDiff > allowedDiff) {
					// backtrack
					if (one[left] != two[left]) {
						currentDiff--;
					}
					left++;
				}
			}
			max = Math.max(max, right - left + 1);
		}

		return max;
	}

	private boolean sortaEquals(String substring, String substring1, int allowedDiff) {
		char[] one = substring.toCharArray();
		char[] two = substring1.toCharArray();
		int currentDiff = 0;

		for (int i = 0 ; i < one.length ; i++) {
			if (one[i] != two[i]) {
				currentDiff++;
			}

			if (currentDiff > allowedDiff) {
				return false;
			}
		}

		return true;
	}
}
