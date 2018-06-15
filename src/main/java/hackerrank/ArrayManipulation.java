package hackerrank;

import java.util.Scanner;

/**
 * TODO write documentation
 */
public class ArrayManipulation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new ArrayManipulation().solve(in));
	}

	public String solve(Scanner in) {
		int size = in.nextInt();
		int rows = in.nextInt();
		long[] nums = new long[size];

		long max = Long.MIN_VALUE;

		for (int i = 0 ; i < rows ; i++) {
			max = Long.max(applyRow(nums, in.nextInt(), in.nextInt(), in.nextInt()), max);
		}

		return String.valueOf(max);
	}

	private long applyRow(long[] nums, int from, int to, int add) {
		long max = Long.MIN_VALUE;
		for (int i = from - 1 ; i < to ; i++) {
			nums[i] += add;
			max = Long.max(nums[i], max);
		}

		return max;
	}
}
