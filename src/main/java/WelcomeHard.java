import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class WelcomeHard {
    private static final char[] WELCOME = "welcome to code jam".toCharArray();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new WelcomeHard().solve(in));
    }

    public String solve(Scanner in) {
        int n = in.nextInt();
        List<Integer> cases = new ArrayList<>();

        for (int i = 0 ; i < n ; i++) {
            List<Node> nodes = new ArrayList<>();
            String line = in.nextLine();

            for (char c: line.toCharArray()) {
                if (c == 'w') {
                    nodes.add(new Node());
                }
            }
        }

        return "";
    }

    protected static class Node {
        List<Node> children = new ArrayList<>();
        String total;
        int wantedCharacter = 1;
        // TODO
    }
}
