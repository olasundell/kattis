import java.awt.*;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Tajna {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Tajna().solve(in));
	}

	public String solve(Scanner in) {
		String str = in.next();

		Point size = findMatrixSize(str);

		int k = 0;

		final char[] result = new char[str.length()];
		final char[] charArray = str.toCharArray();

		for (int j = 0 ; j < size.x ; j++) {
			for (int i = 0 ; i < size.y ; i++) {
				result[i * size.x + j] = charArray[k++];
			}
		}

		return new String(result);
	}

	private Point findMatrixSize(String str) {
		int rows = 1;
		int sqrt = (int) Math.floor(Math.sqrt(str.length()));
		for (int i = 2 ; i <= sqrt ; i++) {
			if (str.length() % i == 0) {
				rows = i;
			}
		}

		return new Point(str.length() / rows, rows);
	}
}
