import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static util.Matrix.*;
import static util.Matrix.CardinalDirection.*;
import static util.Matrix.Direction.*;

/**
 * TODO write documentation
 */
public class FunHouse {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new FunHouse().solve(in));
	}

	public String solve(Scanner in) {
		List<House> houses = createHouses(in);

		for (House h: houses) {
			traceHouse(h);
		}

		return houses.stream().map(House::toString).collect(Collectors.joining("\n"));
	}

	private void traceHouse(House house) {
		Point pos = house.getStart();
		CardinalDirection currentDirection;

		if (pos.x == 0) {
			currentDirection = EAST;
		} else if (pos.y == 0) {
			currentDirection = SOUTH;
		} else if (pos.y == (house.matrix.size() - 1)) {
			currentDirection = NORTH;
		} else {
			currentDirection = WEST;
		}

		for (;;) {
			final Block block = house.getBlock(pos);
			if (block == Block.WALL) {
				house.setBlock(pos, Block.EXIT);
				break;
			}

			if (block == Block.SLASH) {
				if (currentDirection == EAST || currentDirection == WEST) {
					currentDirection = currentDirection.turn(LEFT);
				} else {
					currentDirection = currentDirection.turn(RIGHT);
				}
			}

			if (block == Block.BACKSLASH) {
				if (currentDirection == EAST || currentDirection == WEST) {
					currentDirection = currentDirection.turn(RIGHT);
				} else {
					currentDirection = currentDirection.turn(LEFT);
				}
			}

			final Point delta = new CardinalMove(currentDirection, 1).getDelta();
			pos.translate(delta.x, delta.y);
		}
	}

	private List<House> createHouses(Scanner in) {
		List<House> houses = new ArrayList<>();

		for (int idx = 1 ;; idx++) {
			House house = new House(idx);
			int x = in.nextInt();
			int y = in.nextInt();
			if (x == 0 || y == 0) {
				break;
			}
			in.nextLine();

			for (int i = 0 ; i < y ; i++) {
				house.addRow(createRow(in.nextLine()));
			}
			houses.add(house);
		}

		return houses;
	}

	private List<Block> createRow(String s) {
		List<Block> row = new ArrayList<>();
		for (char c: s.toCharArray()) {
			row.add(Block.of(c));
		}

		return row;
	}

	class House {
		final int index;
		List<List<Block>> matrix = new ArrayList<>();
		Point start;

		public House(int index) {
			this.index = index;
		}


		void addRow(List<Block> row) {
			matrix.add(row);
		}

		Point getStart() {
			if (start == null) {
				for (int i = 0 ; i < matrix.size() ; i++) {
					for (int j = 0 ; j < matrix.get(i).size() ; j++) {
						if (matrix.get(i).get(j).equals(Block.START)) {
							start = new Point(j, i);
						}
					}
				}
			}

			return start;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("HOUSE ").append(index).append("\n");

			builder.append(matrix.stream()
					.map(this::printRow)
					.collect(Collectors.joining("\n")));

			return builder.toString();
		}

		private String printRow(List<Block> blocks) {
			return blocks.stream().map(Block::asString).collect(Collectors.joining());
		}

		Block getBlock(Point pos) {
			return matrix.get(pos.y).get(pos.x);
		}

		void setBlock(Point pos, Block block) {
			matrix.get(pos.y).set(pos.x, block);
		}
	}

	enum Block {
		START('*'),
		WALL('x'),
		EMPTY('.'),
		SLASH('/'),
		BACKSLASH('\\'),
		EXIT('&');

		char c;

		Block(char c) {
			this.c = c;
		}

		String asString() {
			return String.valueOf(c);
		}

		static Block of(char c) {
			switch (c) {
				case 'x':
					return WALL;
				case '.':
					return EMPTY;
				case '/':
					return SLASH;
				case '\\':
					return BACKSLASH;
				case '&':
					return EXIT;
				case '*':
					return START;
				default:
					throw new IllegalArgumentException("char " + c + " is an illegal alien");
			}
		}
	}
}
