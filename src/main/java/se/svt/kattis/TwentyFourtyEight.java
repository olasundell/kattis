package se.svt.kattis;

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
        Direction direction = findDirection(in);
        List<List<Integer>> board = createBoardFromTemp(tempBoard, direction);
        List<List<Integer>> boardAfterMoves = new ArrayList<>();

        board.stream().forEach((l) -> boardAfterMoves.add(moveAndCombine(l)));

        return printBoard(boardAfterMoves, direction);
    }

    protected List<List<Integer>> createBoardFromTemp(int[][] tempBoard, Direction direction) {
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

    protected int getTile(int[][] tempBoard, int i, int j, Direction direction) {
        return tempBoard[translateX(i, j, direction)][translateY(i, j, direction)];
    }


    protected int translateX(int i, int j, Direction direction) {
        switch (direction) {
            case LEFT:
            case RIGHT:
                return i;
            case UP:
                return j;
            case DOWN:
                return 3 - j;
        }

        return -1;
    }
    protected int translateY(int i, int j, Direction direction) {
        switch (direction) {
            case LEFT:
                return j;
            case RIGHT:
                return 3 - j;
            case UP:
                return i;
            case DOWN:
//                return i;
                return 3 - i;

        }

        return -1;
    }

    // TODO this is a very hacky method, should be improved upon considerably
    protected String printBoard(List<List<Integer>> board, Direction direction) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0 ; i < 4 ; i++) {
            for (int j = 0; j < 3; j++) {
                int x = translateX(i, j, direction);
                int y = translateY(i, j, direction);
                builder.append(board.get(x).get(y));
                builder.append(" ");
            }
            builder.append(board.get(translateX(i, 3, direction)).get(translateY(i, 3, direction)));
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

    private Direction findDirection(Scanner in) {
        int i = in.nextInt();
        switch (i) {
            case 0:
                return Direction.LEFT;
            case 1:
                return Direction.UP;
            case 2:
                return Direction.RIGHT;
            case 3:
                return Direction.DOWN;
            default:
                throw new IllegalArgumentException("Expected a number between 0-3 but got " + i);
        }
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

    protected enum Direction {
        LEFT,
        UP,
        RIGHT,
        DOWN;

        Direction opposite() {
            switch (this) {
                case LEFT:
                    return RIGHT;
                case RIGHT:
                    return LEFT;
                case UP:
                    return DOWN;
                case DOWN:
                    return UP;
            }

            return null;
        }
    }
}
