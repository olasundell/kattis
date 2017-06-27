import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class HelpMe {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new HelpMe().solve(in));
	}

	public String solve(Scanner in) {
		in.nextLine();

		PriorityQueue<PiecePos> white = new PriorityQueue<>();
		PriorityQueue<PiecePos> black = new PriorityQueue<>();

		for (int i = 8 ; i >= 1 ; i--) {
			String line = in.nextLine();
			String[] parts = line.split("[|]");

			for (int j = 1 ; j <= 8 ; j++) {
				Optional<PiecePos> optional = createPiecePos(parts[j], i, j);

				if (optional.isPresent()) {
					PiecePos pos = optional.get();
					if (pos.color == Color.WHITE) {
						white.add(pos);
					} else {
						black.add(pos);
					}
				}
			}

			in.nextLine();
		}

		StringBuilder builder = new StringBuilder();
		builder.append("White: ").append(stringify(white));

		builder.append("\n");

		builder.append("Black: ").append(stringify(black));

		return builder.toString();
	}

	private Optional<PiecePos> createPiecePos(String part, int row, int col) {
		Character p = part.charAt(1);

		String name;
		if (p.equals('p') || p.equals('P')) {
			name = "";
		} else if (p.equals(':') || p.equals('.')){
			return Optional.empty();
		} else {
			name = String.valueOf(Character.toUpperCase(p));
		}

		Color color;

		if (Character.isUpperCase(p)) {
			color = Color.WHITE;
		} else {
			color = Color.BLACK;
		}

		return Optional.of(new PiecePos(Piece.from(name), color, row, (char)('a' + col - 1)));
	}

	private String stringify(PriorityQueue<PiecePos> queue) {
		return queue.stream()
				.sorted()
				.map(PiecePos::toString)
				.collect(Collectors.joining(","));
	}

	class PiecePos implements Comparable<PiecePos> {
		final Piece piece;
		final Color color;
		final int row;
		final char col;

		PiecePos(Piece piece, Color color, int row, char col) {
			this.piece = piece;
			this.color = color;
			this.row = row;
			this.col = col;
		}

		public String toString() {
			return String.format("%s%s%d", piece.s, col, row);
		}

		@Override
		public int compareTo(PiecePos o) {
			if (o.color != this.color) {
				return this.color == Color.WHITE ? 1 : -1;
			}

			if (o.piece.compareTo(this.piece) != 0) {
				return - o.piece.compareTo(this.piece);
			}

			if (o.row != this.row) {
				if (o.color == Color.WHITE) {
					return this.row - o.row;
				} else {
					return o.row - this.row;
				}
			}

			return this.col - o.col;
		}
	}

	enum Piece {
		KING("K"), QUEEN("Q"), ROOK("R"), BISHOP("B"), KNIGHT("N"), PAWN("");

		String s;

		Piece(String s) {
			this.s = s;
		}

		public static Piece from(String name) {
			switch (name) {
				case "K":
					return KING;
				case "Q":
					return QUEEN;
				case "R":
					return ROOK;
				case "B":
					return BISHOP;
				case "N":
					return KNIGHT;
				case "":
				default:
					return PAWN;
			}
		}
	}

	enum Color {
		BLACK, WHITE
	}
}
