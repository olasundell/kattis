import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class ParsingHex {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new ParsingHex().solve(in));
	}

	public String solve(Scanner in) {
		List<String> results = new ArrayList<>();
		Pattern pattern = Pattern.compile("0[xX][a-fA-F0-9]+");

		while (in.hasNextLine()) {
			String line = in.nextLine();
			Matcher matcher = pattern.matcher(line);
			while (matcher.find()) {
				String s = line.substring(matcher.start(), matcher.end());

				results.add(String.format("%s %s", s, Long.parseLong(s.substring(2), 16)));
			}
		}
		return results.stream().collect(Collectors.joining("\n"));
	}
}
