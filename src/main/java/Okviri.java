import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Okviri {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Okviri().solve(in));
	}

	public String solve(Scanner in) {
		char[] chars = in.next().toCharArray();

		List<StringBuilder> builders = new ArrayList<>();
		for (int i = 0 ; i < 5 ; i++) {
			builders.add(new StringBuilder());
		}

		for (int i = 0 ; i < chars.length ; i++) {
			if ((i + 1) % 3 == 0) {
				frame(chars[i], builders, '*');
			} else {
				frame(chars[i], builders, '#');
			}
		}

		return builders.stream().map(StringBuilder::toString).collect(Collectors.joining("\n"));
	}

	private void frame(char toFrame, List<StringBuilder> builders, char frameChar) {
		if (builders.get(0).length() == 0) {
			builders.get(0).append('.');
			builders.get(1).append('.');
			builders.get(2).append(frameChar);
			builders.get(3).append('.');
			builders.get(4).append('.');
		} else if (frameChar == '*') {
			builders.get(2).replace(builders.get(2).length() - 1, builders.get(2).length(), String.valueOf(frameChar));
		}

		builders.get(0).append('.').append(frameChar).append('.').append('.');
		builders.get(1).append(frameChar).append('.').append(frameChar).append('.');
		builders.get(2).append('.').append(toFrame).append('.').append(frameChar);
		builders.get(3).append(frameChar).append('.').append(frameChar).append('.');
		builders.get(4).append('.').append(frameChar).append('.').append('.');
	}
}
