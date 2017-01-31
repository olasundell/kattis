import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Mastermind {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Mastermind().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		String code = in.next();
		String guess = in.next();

		int white = 0;
		int black = 0;

		Map<Character, Integer> codeMap = new HashMap<>();
		Map<Character, Integer> guessMap = new HashMap<>();

		for (int i = 0 ; i < n ; i++) {
			char c = code.charAt(i);
			char g = guess.charAt(i);

			if (c == g) {
				white++;
			}

			codeMap.put(c, codeMap.getOrDefault(c, 0) + 1);
			guessMap.put(g, guessMap.getOrDefault(g, 0) + 1);
		}

		for (char c: codeMap.keySet()) {
			black += Math.min(codeMap.get(c), guessMap.getOrDefault(c, 0));
		}

		return white + " " + (black - white);
	}
}
