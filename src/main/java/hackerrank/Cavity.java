package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Cavity {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Cavity().solve(in));
	}

	public String solve(Scanner in) {
		String s;
		int n = in.nextInt();
		in.nextLine();

		int[][] board = readBoard(in, n);

		char[][] cavitated = cavitySearch(board);

		return toString(cavitated);
	}

	private char[][] cavitySearch(int[][] board) {
		char[][] cavitated = new char[board.length][board.length];
		for (int i = 0 ; i < board.length ; i++) {
			cavitated[i][0] = Integer.toString(board[i][0]).toCharArray()[0];
			cavitated[0][i] = Integer.toString(board[0][i]).toCharArray()[0];

			cavitated[i][board.length - 1] = Integer.toString(board[i][board.length - 1]).toCharArray()[0];
			cavitated[board.length - 1][i] = Integer.toString(board[board.length - 1][i]).toCharArray()[0];
		}

		for (int i = 1 ; i < board.length - 1 ; i++) {
			for (int j = 1 ; j < board[i].length - 1 ; j++) {
				if (isCavity(i, j, board)) {
					cavitated[i][j] = 'X';
				} else {
					cavitated[i][j] = Integer.toString(board[i][j]).toCharArray()[0];
				}
			}
		}

		return cavitated;
	}

	private boolean isCavity(int i, int j, int[][] board) {
		int c = board[i][j];

		return (
				board[i-1][j] < c &&
				board[i][j-1] < c &&
				board[i][j+1] < c &&
				board[i+1][j] < c
				);
	}

	private int[][] readBoard(Scanner in, int n) {
		int[][] board = new int[n][n];

		for (int i = 0 ; i < n ; i++) {
			char[] arr = in.nextLine().toCharArray();
			for (int j = 0 ; j < n ; j++) {
				board[i][j] = Character.getNumericValue(arr[j]);
			}
		}
		return board;
	}

	private String toString(char[][] board) {
		StringBuilder builder = new StringBuilder();

		for (int i = 0 ; i < board.length ; i++) {
			for (int j = 0; j < board[i].length ; j++) {
				builder.append(board[i][j]);
			}
			if (i + 1 < board.length) {
				builder.append("\n");
			}
		}
		return builder.toString();
	}
}
