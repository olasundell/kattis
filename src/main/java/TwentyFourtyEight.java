import util.Matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class TwentyFourtyEight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new TwentyFourtyEight().solve(in));
    }

    public String solve(Scanner in) {
        int[][] tempBoard = readBoard(in);
        Matrix.Direction direction = Matrix.findDirection(in.nextInt());
        List<List<Integer>> board = createBoardFromTemp(tempBoard, direction);
        List<List<Integer>> boardAfterMoves = new ArrayList<>();

        board.stream().forEach((l) -> boardAfterMoves.add(moveAndCombine(l)));

        return printBoard(boardAfterMoves, direction);
    }

    protected List<List<Integer>> createBoardFromTemp(int[][] tempBoard, Matrix.Direction direction) {
        List<List<Integer>> board = new ArrayList<>();

        for (int i = 0 ; i < tempBoard.length ; i++) {
            List<Integer> line = new ArrayList<>();
            for (int j = 0 ; j < tempBoard[i].length ; j++) {
                line.add(getTile(tempBoard, i, j, direction));
            }
            board.add(line);
        }
        return board;
    }

    protected int getTile(int[][] tempBoard, int i, int j, Matrix.Direction direction) {
        return tempBoard[Matrix.translateX(i, j, 4, direction)][Matrix.translateY(i, j, 4, direction)];
    }


    // TODO this is a very hacky method, should be improved upon considerably
    protected String printBoard(List<List<Integer>> board, Matrix.Direction direction) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0 ; i < 4 ; i++) {
            for (int j = 0; j < 3; j++) {
                int x = Matrix.translateX(i, j, 4, direction);
                int y = Matrix.translateY(i, j, 4, direction);
                builder.append(board.get(x).get(y));
                builder.append(" ");
            }
            builder.append(board.get(Matrix.translateX(i, 3, 4, direction)).get(Matrix.translateY(i, 3, 4, direction)));
            if (i < 3) {
                builder.append("\n");
            }
        }

        return builder.toString();
    }

    private int[][] readBoard(Scanner in) {
        int[][] board = new int[4][4];

        for (int i = 0 ; i < 4 ; i++) {
            for (int j = 0 ; j < 4 ; j++) {
                board[i][j] = in.nextInt();
            }
        }
        return board;
    }

    protected List<Integer> moveAndCombine(List<Integer> start) {
        List<Integer> move = new ArrayList<>();
        start.stream()
                .filter((i) -> i != 0)
                .forEach(move::add);

        List<Integer> result = new ArrayList<>();

        for (int i = 0 ; i < move.size() ; i++) {
            if (i != move.size() -1 &&
                    move.get(i).equals(move.get(i + 1))) {
                result.add(move.get(i) * 2);
                i++;
            } else {
                result.add(move.get(i));
            }
        }

        int size = result.size();
        for (int i = 0; i < start.size() - size; i++) {
            result.add(0);
        }

        return result;
    }

}
