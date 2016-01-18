import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *  * Luka is fooling around in chemistry class again!
 *  Instead of balancing equations he is writing coded sentences on a piece of paper.
 *  Luka modifies every word in a sentence by adding, after each vowel (letters ’a’, ’e’, ’i’, ’o’ and ’u’),
 *  the letter ’p’ and then that same vowel again.
 *  For example, the word “kemija” becomes “kepemipijapa” and the word “paprika” becomes “papapripikapa”.
 *  The teacher took Luka’s paper with the coded sentences and wants to decode them.
 *
 *  Write a program that decodes Luka’s sentence.
 *
 *  Input
 *  The coded sentence will be given on a single line. The sentence consists only of lowercase letters
 *  of the English alphabet and spaces. The words will be separated by exactly one space and there will be
 *  no leading or trailing spaces. The total number of character will be at most 100.
 *
 *  Output
 *
 *  Output the decoded sentence on a single line.
 */
public class Kemija {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Kemija().solve(in));
    }

    public String solve(Scanner in) {
        List<String> words = new ArrayList<>();
        while (in.hasNext()) {
            String regex = "([aeiou])[p][aeiou]";
            Pattern pattern = Pattern.compile(regex);
            StringBuffer result = new StringBuffer();

            Matcher m = pattern.matcher(in.next());

            while (m.find()) {
                m.appendReplacement(result, "$1");
            }

            m.appendTail(result);

            words.add(result.toString());
        }

        return words.stream().collect(Collectors.joining(" "));
    }
}
