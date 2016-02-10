import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class QuiteAProblem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new QuiteAProblem().solve(in));
    }

    public String solve(Scanner in) {
        List<String> results = new ArrayList<>();
        Pattern pattern = Pattern.compile(".*[pP][rR][oO][bB][lL][eE][mM].*");
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (pattern.matcher(s).find()) {
                results.add("yes");
            } else {
                results.add("no");
            }
        }
        return results.stream().collect(Collectors.joining("\n"));
    }
}
