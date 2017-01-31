import java.awt.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * TODO write documentation
 */
public class TreasureHunt {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new TreasureHunt().solve(in));
	}

	public String solve(Scanner in) {
		int rows = in.nextInt();
		int cols = in.nextInt();

		char[][] board = new char[rows][cols];

		for (int i = 0 ; i < rows ; i++) {
			char[] arr = in.next().toCharArray();
			System.arraycopy(arr, 0, board[i], 0, cols);
		}

		Set<Point> points = new HashSet<>();

		int x = 0;
		int y = 0;
		Point p = null;

		while (!points.contains(p)) {

			switch (board[y][x]) {
				case 'T':
					return String.valueOf(points.size());
				case 'N':
					y--;
					break;
				case 'S':
					y++;
					break;
				case 'E':
					x++;
					break;
				case 'W':
					x--;
					break;
			}

			points.add(p);

			if (x < 0 || x >= cols || y < 0 || y >= rows) {
				return "Out";
			}

			p = new Point(x, y);
		}

		return "Lost";
	}
}
