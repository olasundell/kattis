import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Zamka {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Zamka().solve(in));
	}

	/*
	determine the minimal integer N such that L≤N≤D and the sum of its digits is X
	determine the maximal integer M such that L≤M≤D and the sum of its digits is X
	 */

	public String solve(Scanner in) {
		int l = in.nextInt();
		int d = in.nextInt();
		int x = in.nextInt();

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = l ; i <= d ; i++) {
			int number = i;
			int current = 0;
			while (number > 0) {
				current += number % 10;
				number /= 10;
			}

			if (current == x) {
				if (min > i) {
					min = i;
				}
				if (max < i) {
					max = i;
				}
			}
		}


		return String.format("%s\n%s", min, max);
	}
}
