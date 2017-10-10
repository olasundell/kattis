import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class RockScissorsPaper {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new RockScissorsPaper().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		List<Board> boards = new ArrayList<>();

		for (int i = 0 ; i < n ; i++) {
			final Board board = readBoard(in);
			iterateBoard(board);
			boards.add(board);
		}

		return boards.stream().map(
				b -> b.moves.stream()
						.map(row -> row.stream()
								.map(Move::toString).collect(Collectors.joining()))
						.collect(Collectors.joining("\n")))
				.collect(Collectors.joining("\n\n"));
	}

	private void iterateBoard(Board init) {
		Board board = init;

		for (int i = 0 ; i < init.iterations ; i++) {
			Board newBoard = new Board(board.iterations - 1);
			for (int y = 0 ; y < board.moves.size() ; y++) {
				for (int x = 0 ; x < board.moves.get(0).size() ; x++) {
					board.moves.get(y).get(x);
				}
			}
		}
	}

	private Board readBoard(Scanner in) {

		int rows = in.nextInt();
		int cols = in.nextInt();
		int iterations = in.nextInt();

		final Board board = new Board(iterations);

		in.nextLine();

		for (int i = 0 ; i < rows ; i++) {
			final List<Move> m = new ArrayList<>();
			board.moves.add(m);
			char[] chars = in.nextLine().toCharArray();

			for (int j = 0 ; j < cols ; j++) {
				m.add(Move.of(chars[j]));
			}
		}

		return board;
	}

	class Board {
		final List<List<Move>> moves = new ArrayList<>();
		final int iterations;

		public Board(int iterations) {
			this.iterations = iterations;
		}
	}

	enum MoveType {
		ROCK,
		SCISSORS,
		PAPER
	}

	static class Move {
		static Move ROCK = new Move(MoveType.ROCK, MoveType.SCISSORS);
		static Move SCISSORS = new Move(MoveType.SCISSORS, MoveType.PAPER);
		static Move PAPER = new Move(MoveType.PAPER, MoveType.ROCK);

		MoveType beats;
		MoveType move;

		Move(MoveType move, MoveType beats) {
			this.move = move;
			this.beats = beats;
		}

		static Move of(char c) {
			switch (c) {
				case 'R':
					return ROCK;
				case 'S':
					return SCISSORS;
				case 'P':
					return PAPER;
			}
			return null;
		}

		Move fight(Move m) {
			if (m.beats == this.move) {
				return m;
			}

			return this;
		}

		@Override
		public String toString() {
			switch (move) {
				case ROCK:
					return "R";
				case SCISSORS:
					return "S";
				case PAPER:
					return "P";
			}

			return "";
		}
	}
}
