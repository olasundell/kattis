import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Skener {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Skener().solve(in));
	}

	public String solve(Scanner in) {
		int sizeY = in.nextInt();
		int sizeX = in.nextInt();
		int scaleY = in.nextInt();
		int scaleX = in.nextInt();
		in.nextLine();

		List<String> results = new ArrayList<>();

		for (int i = 0 ; i < sizeY ; i++) {
			StringBuilder builder = new StringBuilder();
			char[] line = in.nextLine().toCharArray();
			for (char c: line) {
				for (int j = 0 ; j < scaleX ; j++) {
					builder.append(c);
				}
			}

			for (int j = 0 ; j < scaleY ; j++) {
				results.add(builder.toString());
			}
		}
		return results.stream().collect(Collectors.joining("\n"));
	}
}
