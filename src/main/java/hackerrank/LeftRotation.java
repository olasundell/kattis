package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class LeftRotation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new LeftRotation().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		int distance = in.nextInt();
		List<Integer> list = new ArrayList<>();


		for (int i = 0 ; i < n ; i++) {
			list.add(in.nextInt());
		}

		Collections.rotate(list, -distance);

		return list.stream().map(String::valueOf).collect(Collectors.joining(" "));
	}
}
