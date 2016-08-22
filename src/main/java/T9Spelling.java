import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class T9Spelling {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new T9Spelling().solve(in));
	}

	public String solve(Scanner in) {
		int n = Integer.valueOf(in.nextLine());
		List<String> result = new ArrayList<>();

		for (int i = 1 ; i <= n ; i++) {
			List<String> t9 = new ArrayList<>();
			String line = in.nextLine();
			for (char c: line.toCharArray()) {
				String current = forChar(c);
				if (!t9.isEmpty() && t9.get(t9.size() - 1).startsWith(current.substring(0, 1))) {
					t9.add(" ");
				}
				t9.add(current);
			}
			result.add(String.format("Case #%d: %s", i, t9.stream().collect(Collectors.joining())));
		}

		return result.stream().collect(Collectors.joining("\n"));
	}

	String forChar(char c) {
		StringBuilder builder = new StringBuilder();
		switch (c) {
			case 'c':
				builder.append(2);
			case 'b':
				builder.append(2);
			case 'a':
				builder.append(2);
				break;
			case 'f':
				builder.append(3);
			case 'e':
				builder.append(3);
			case 'd':
				builder.append(3);
				break;
			case 'i':
				builder.append(4);
			case 'h':
				builder.append(4);
			case 'g':
				builder.append(4);
				break;
			case 'l':
				builder.append(5);
			case 'k':
				builder.append(5);
			case 'j':
				builder.append(5);
				break;
			case 'o':
				builder.append(6);
			case 'n':
				builder.append(6);
			case 'm':
				builder.append(6);
				break;
			case 's':
				builder.append(7);
			case 'r':
				builder.append(7);
			case 'q':
				builder.append(7);
			case 'p':
				builder.append(7);
				break;
			case 'v':
				builder.append(8);
			case 'u':
				builder.append(8);
			case 't':
				builder.append(8);
				break;
			case 'z':
				builder.append(9);
			case 'y':
				builder.append(9);
			case 'x':
				builder.append(9);
			case 'w':
				builder.append(9);
				break;
			case ' ':
				builder.append(0);
				break;
		}

		return builder.toString();
	}
}
