import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class TextureAnalysis {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new TextureAnalysis().solve(in));
	}

	public String solve(Scanner in) {
		List<String> result = new ArrayList<>();

		for (int i = 1 ; in.hasNextLine() ; i++) {
			String line = in.nextLine();
			if ("END".equals(line)) {
				break;
			}

			result.add(i + " " + checkLine(line) + "EVEN");
		}
		return result.stream().collect(Collectors.joining("\n"));
	}

	private String checkLine(String line) {
		int maxDistance = 0;
		int numberSeen = 0;
		int currDistance = 0;

		for (char c: line.toCharArray()) {
			switch (c) {
				case '*':
					numberSeen++;

					if (numberSeen == 2) {
						maxDistance = currDistance;
					}

					if (currDistance != maxDistance) {
						return "NOT ";
					}
					currDistance = 0;
					break;
				case '.':
					currDistance++;
					break;
			}
		}

		return "";
	}
}
