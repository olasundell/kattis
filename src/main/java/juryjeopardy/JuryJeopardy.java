package juryjeopardy;

import util.Matrix;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class JuryJeopardy {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new JuryJeopardy().solve(in));
	}

	public String solve(Scanner in) {
		in.nextLine();
		List<Maze> mazes = new ArrayList<>();

		while (in.hasNextLine()) {
			Maze maze = new Maze();
			String line = in.nextLine();

			Matrix.CardinalDirection direction = Matrix.CardinalDirection.EAST;

			for (char c : line.toCharArray()) {
				switch (c) {
					case 'F':
						break;
					case 'R':
						direction = direction.turn(Matrix.Direction.RIGHT);
						break;
					case 'L':
						direction = direction.turn(Matrix.Direction.LEFT);
						break;
					case 'B':
						direction = direction.turn(Matrix.Direction.LEFT);
						direction = direction.turn(Matrix.Direction.LEFT);
						break;
				}
				step(direction, maze);
			}
			mazes.add(maze);
		}
		return mazes.size() + "\n" + mazes.stream().map(Maze::prettyPrint).collect(Collectors.joining("\n"));
	}

	void step(Matrix.CardinalDirection direction, Maze maze) {
		int x = maze.current.x;
		int y = maze.current.y;

		switch (direction) {
			case EAST:
				x++;
				break;
			case WEST:
				x--;
				break;
			case NORTH:
				y--;
				break;
			case SOUTH:
				y++;
				break;
		}

		if (y == 0) {
			maze.bonkDown();
			y++;
		}

		if (y == maze.maxY - 1) {
			maze.addBottom();
		}

		if (x == -1) {
			maze.bonkRight();
			x++;
		}

		if (x == maze.maxX - 1) {
			maze.addRight();
		}

		maze.current = new Point(x, y);
		maze.setCurrentToEmpty();

//		System.err.println(direction + " " + maze.current);
//		System.err.println(maze.prettyPrint());
	}
}
