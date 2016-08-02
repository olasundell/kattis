import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Trik {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Trik().solve(in));
	}

	public String solve(Scanner in) {
		String s = in.next();
		boolean cups[] = new boolean[3];
		cups[0] = true;

		for (char c: s.toCharArray()) {
			switch (c) {
			case 'A':
				boolean t = cups[0];
				cups[0] = cups[1];
				cups[1] = t;
				break;
			case 'B':
				t = cups[1];
				cups[1] = cups[2];
				cups[2] = t;
				break;
			case 'C':
				t = cups[0];
				cups[0] = cups[2];
				cups[2] = t;
				break;
			}
		}
		int n = -1;
		for (int i = 0 ; i < 3 ; i++) {
			if (cups[i]) {
				n = i + 1;
				break;
			}
		}
		return String.valueOf(n);
	}
}
