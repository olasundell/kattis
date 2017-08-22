import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class HidingPlaces {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new HidingPlaces().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		in.nextLine();
		List<Solution> solution = new ArrayList<>();

		for (int i = 0 ; i < n ; i++) {
			solution.add(calcSolution(in.nextLine()));
		}
		return solution.stream().map(Solution::toString).collect(Collectors.joining("\n"));
	}

	private Solution calcSolution(String s) {
		Set<Position> positions = new HashSet<>();
		final Position current = new Position(s);
		positions.add(current);
		Set<Position> possibles = findPossibles(current, positions);
		Set<Position> prevPossibles;
		int i = 0;

		for (; ; i++) {
			prevPossibles = new HashSet<>(possibles);
			positions.addAll(possibles);

			possibles = possibles.stream()
					.map(p -> findPossibles(p, positions))
					.flatMap(Set::stream)
					.collect(Collectors.toSet());

			if (possibles.isEmpty()) {
				break;
			}
		}

		return new Solution(prevPossibles, i + 1);
	}

	private Set<Position> findPossibles(Position current, Set<Position> positions) {
		Set<Position> possibles = new HashSet<>();

		for (int i = 0 ; i < 8 ; i++) {
			possibles.add(translate(current, i));
		}

		return possibles.stream()
				.filter(Position::isLegal)
				.filter(p -> !positions.contains(p))
				.collect(Collectors.toSet());
	}

	private Position translate(Position p, int n) {
		switch (n) {
			case 0:
				// one left, down two
				return new Position((char) (p.col - 1), p.row - 2);
			case 1:
				// one right, down two
				return new Position((char) (p.col + 1), p.row - 2);
			case 2:
				// two left, down one
				return new Position((char) (p.col - 2), p.row - 1);
			case 3:
				// two right, down one
				return new Position((char) (p.col + 2), p.row - 1);
			case 4:
				// one left, up two
				return new Position((char) (p.col - 1), p.row + 2);
			case 5:
				// one right, up two
				return new Position((char) (p.col + 1), p.row + 2);
			case 6:
				// two left, up one
				return new Position((char) (p.col - 2), p.row + 1);
			case 7:
				// two right, up one
				return new Position((char) (p.col + 2), p.row + 1);
			default:
				// TODO scream and shout
				return p;
		}
	}

	class Position implements Comparable<Position> {
		final char col;
		final int row;

		Position(char col, int row) {
			this.col = col;
			this.row = row;
		}

		Position(String s) {
			final char[] chars = s.toCharArray();
			this.col = chars[0];
			this.row = chars[1] - '0';
		}

		boolean isLegal() {
			return row >= 1 && row <= 8 && col >= 'a' && col <= 'h';
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Position position = (Position) o;

			if (col != position.col) return false;
			return row == position.row;
		}

		@Override
		public int hashCode() {
			int result = (int) col;
			result = 31 * result + row;
			return result;
		}

		@Override
		public String toString() {
			return String.valueOf(col) + String.valueOf(row);
		}

		@Override
		public int compareTo(Position o) {
			if (this.equals(o)) {
				return 0;
			}

			if (o.row != this.row) {
				return o.row - this.row;
			}

			return this.col - o.col;
		}
	}

	class Solution {
		final Set<Position> positions;
		final int numberOfMoves;

		public Solution(Set<Position> positions, int numberOfMoves) {
			this.positions = positions;
			this.numberOfMoves = numberOfMoves;
		}

		@Override
		public String toString() {
			return numberOfMoves + " " + positions.stream().sorted().map(Position::toString).collect(Collectors.joining(" "));
		}
	}
}
