import util.Matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class SecretMessage {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new SecretMessage().solve(in));
    }

    public String solve(Scanner in) {
        int messages = in.nextInt();
        List<String> answers = new ArrayList<>();
        for (int i = 0 ; i < messages ; i++) {
            String unencrypted = in.next();
            StringBuilder encrypted = new StringBuilder();

            char[][] board = createBoard(unencrypted);

            for (int j = 0 ; j < board.length ; j++) {
                for (int k = 0 ; k < board[j].length ; k++) {
                    int x = Matrix.translateX(j, k, board[j].length, Matrix.Direction.RIGHT);
                    int y = Matrix.translateY(j, k, board[j].length, Matrix.Direction.RIGHT);

                    if (board[x][y] != 0) {
                        encrypted.append(board[x][y]);
                    }
                }
            }

            answers.add(encrypted.toString());
        }

        return answers.stream().collect(Collectors.joining("\n"));
    }

    protected char[][] createBoard(String s) {
        int size = (int) Math.ceil(Math.sqrt(s.length()));

        char[][] board = new char[size][size];

        for (int i = 0 ; i < s.length() ; i++) {
            board[i % size][i / size] = s.charAt(i);
        }

        return board;
    }
}
