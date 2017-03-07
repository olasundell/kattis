import util.Matrix;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class BoundingRobots {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new BoundingRobots().solve(in));
	}

	public String solve(Scanner in) {
		List<Board> results = new ArrayList<>();

		for (Point bounds = new Point(in.nextInt(), in.nextInt()); !bounds.equals(new Point(0, 0)) ; bounds = new Point(in.nextInt(), in.nextInt())) {
			Point robot = new Point(0, 0);
			Point actual = new Point(0, 0);
			Board board = new Board(bounds, robot, actual);

			int n = in.nextInt();

			for (int i = 0 ; i < n ; i++) {
				String d = in.next();
				int amount = in.nextInt();

				Matrix.Direction dir = Matrix.Direction.of(d);
				move(board, new Matrix.Move(dir, amount));
			}
			results.add(board);
		}
		return results.stream()
				.map(this::prettyPrint)
				.collect(Collectors.joining("\n"));
	}

	private String prettyPrint(Board board) {
		return "Robot thinks " +
				board.robot.x +
				" " +
				board.robot.y +
				'\n' +
				"Actually at " +
				board.actual.x +
				" " +
				board.actual.y +
				'\n';
	}

	private void move(Board board, Matrix.Move move) {
		board.robot.translate(move.getDelta().x, -move.getDelta().y);

		final int dx = bounded(board.actual.x, move.getDelta().x, board.bounds.x);
		final int dy = bounded(board.actual.y, -move.getDelta().y, board.bounds.y);

		board.actual.move(dx, dy);
	}

	private int bounded(int current, int delta, int bound) {
		final int i = current + delta;
		if (i < 0) {
			return 0;
		} else if (i >= bound) {
			return bound - 1;
		} else {
			return i;
		}
	}

	class Board {
		private final Point bounds;
		private final Point robot;
		private final Point actual;

		public Board(Point bounds, Point robot, Point actual) {
			this.bounds = bounds;
			this.robot = robot;
			this.actual = actual;
		}
	}
}
