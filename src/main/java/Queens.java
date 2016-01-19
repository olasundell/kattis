import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * TODO write documentation
 */
public class Queens {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Queens().solve(in));
    }

    public String solve(Scanner in) {
        int n = in.nextInt();
        boolean [][] board = new boolean[n][n];

        for (int i = 0 ; i < n ; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            if (board[x][y]) {
                return "INCORRECT";
            }

            for (int j = 0 ; j < n ; j++) {
                board[x][j] = true;
                board[j][y] = true;
                if (x - j >= 0 && y - j >= 0) {
                    board[x - j][y - j] = true;
                }
                if (x + j < n && y + j < n) {
                    board[x + j][y + j] = true;
                }
                if (x - j >= 0 && y + j < n) {
                    board[x - j][y + j] = true;
                }
                if (x + j < n && y - j >= 0) {
                    board[x + j][y - j] = true;
                }
            }
        }

        return "CORRECT";

    }

    public String solveMap(Scanner in) {
        int n = in.nextInt();

        Map<Integer, Set<Integer>> board = new HashMap<>();

        for (int i = 0 ; i < n ; i++) {
            board.put(i, new HashSet<>());
        }

        for (int i = 0 ; i < n ; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            if (board.get(x).contains(y)) {
                return "INCORRECT";
            }

            for (int j = 0 ; j < n ; j++) {
                board.get(x).add(j);
                board.get(j).add(y);
                if (x - j >= 0 && y - j >= 0) {
                    board.get(x - j).add(y -j);
                }
                if (x + j < n && y + j < n) {
                    board.get(x + j).add(y + j);
                }
                if (x - j >= 0 && y + j < n) {
                    board.get(x - j).add(y + j);
                }
                if (x + j < n && y - j >= 0) {
                    board.get(x + j).add(y - j);
                }
            }
        }

        return "CORRECT";
    }
}
