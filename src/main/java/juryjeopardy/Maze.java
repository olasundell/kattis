package juryjeopardy;

import java.awt.*;
import java.awt.List;
import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
class Maze {
	static final Character EMPTY = '.';
	static final Character WALL = '#';

	Point current = new Point(0, 0);
	Point initial = new Point(0, 0);
	int maxX;
	int maxY;

	java.util.List<java.util.List<Character>> tiles = new ArrayList<>();

	public Maze() {
		tiles.add(new ArrayList<>());

		tiles.get(current.y).add(EMPTY);

		maxX = 1;
		maxY = 1;

		bonkDown();
		addBottom();
		addRight();
	}

	void bonkDown() {
		ArrayList<Character> element = new ArrayList<>();
		tiles.add(0, element);

		for (int i = 0; i < maxX; i++) {
			element.add(WALL);
		}

		initial = new Point(initial.x, initial.y + 1);
		current = new Point(current.x, current.y + 1);
		maxY++;
	}

	public void addBottom() {
		ArrayList<Character> e = new ArrayList<>();
		tiles.add(e);

		for (int i = 0; i < maxX; i++) {
			e.add(WALL);
		}

		maxY++;
	}

	public void bonkRight() {
		tiles.forEach(l -> l.add(0, WALL));
		initial = new Point(initial.x + 1, initial.y);
		current = new Point(current.x + 1, current.y);
		maxX++;
	}

	public void addRight() {
		tiles.forEach(l -> l.add(WALL));
		maxX++;
	}

	public String prettyPrint() {
		return maxY + " " + maxX + "\n" + tiles.stream()
				.map(row -> row.stream().map(String::valueOf).collect(Collectors.joining()))
				.collect(Collectors.joining("\n"));
	}

	public void setCurrentToEmpty() {
		tiles.get(current.y).set(current.x, EMPTY);
	}
}
