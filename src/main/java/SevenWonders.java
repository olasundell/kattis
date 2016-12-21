import java.util.Scanner;

/**
 * TODO write documentation
 */
public class SevenWonders {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new SevenWonders().solve(in));
	}

	public String solve(Scanner in) {
		String line = in.nextLine();
		int t = 0;
		int c = 0;
		int g = 0;

		for (char ch: line.toCharArray()) {
			switch (ch) {
				case 'T':
					t++;
					break;
				case 'C':
					c++;
					break;
				case 'G':
					g++;
					break;
			}
		}
		return String.valueOf(t * t + c * c + g * g + least(t, c, g) * 7);
	}

	private int least(int t, int c, int g) {
		int min = Math.min(t, c);
		min = Math.min(min, g);

		return min;
	}
}
