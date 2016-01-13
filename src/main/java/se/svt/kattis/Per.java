package se.svt.kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Per {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    }

    public String solve(Scanner in) {
        String s = in.nextLine();
        String per = "";

        for (int i = 0 ; i < s.length() / 3 ; i++) {
            per += "PER";
        }

        int diff = 0;

        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) != per.charAt(i)) {
                diff++;
            }
        }

        return String.valueOf(diff);
    }
}
