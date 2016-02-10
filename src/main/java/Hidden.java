import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Hidden {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Hidden().solve(in));
    }

    public String solve(Scanner in) {
        char[] password = in.next().toCharArray();
        char[] message = in.next().toCharArray();
        boolean pass = true;
        int index = 0;

        for (char c: message) {
            if (index == password.length) {
                break;
            }
            if (c == password[index]) {
                index++;
            } else {
                for (int i = index + 1; i < password.length; i++) {
                    if (password[index] != password[i] && password[i] == c) {
                        pass = false;
                        break;
                    }
                }
            }
        }

        return pass && index == password.length ? "PASS" : "FAIL";
    }
}
