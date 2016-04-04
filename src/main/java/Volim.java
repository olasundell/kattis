import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Volim {
    private final static int GAME_END_IN_SECONDS = 3*60 + 30;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Volim().solve(in));
    }

    public String solve(Scanner in) {
        int currentPlayer = in.nextInt() - 1;
        int currentSeconds = 0;
        int numOfQuestions = in.nextInt();

        for (int i = 0 ; i < numOfQuestions ; i++) {
            currentSeconds += in.nextInt();
            if (currentSeconds > GAME_END_IN_SECONDS) {
                return String.valueOf(currentPlayer + 1);
            }

            if ("T".equals(in.next())) {
                currentPlayer = (currentPlayer + 1) % 8;
            }
        }

        return "FAIL";
    }
}
