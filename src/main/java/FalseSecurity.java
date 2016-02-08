import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 *
code.put('A', ".- ");
code.put('H', ".... ");
code.put('O', "--- ");
code.put('V', "...-");
code.put('B', "-... ");
code.put('I', ".. ");
code.put('P', ".--. ");
code.put('W', ".--");
code.put('C', "-.-. ");
code.put('J', ".--- ");
code.put('Q', "--.- ");
code.put('X', "-..-");
code.put('D', "-.. ");
code.put('K', "-.- ");
code.put('R', ".-. ");
code.put('Y', "-.--");
code.put('E', ". ");
code.put('L', ".-.. ");
code.put('S', "... ");
code.put('Z', "--..");
code.put('F', "..-. ");
code.put('M', "-- ");
code.put('T', "- ");
code.put('G', "--. ");
code.put('N', "-. ");
code.put('U', "..-");

 (“_”) ..--
 (“.”) ---.
 (“,”) .-.-
 mark (“?”) ----

 */
public class FalseSecurity {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new FalseSecurity().solve(in));
    }

    public String solve(Scanner in) {
        Map<Character, String> morseCode = setupMorseCode();
        Map<String, Character> reverseMorse = reverseMorseCode();
        List<String> resolved =new ArrayList<>();

        while (in.hasNext()) {
            String str = in.next();
            StringBuilder answer = new StringBuilder();
            StringBuilder asMorseBuilder = new StringBuilder();
            List<Integer> morseLengths = new ArrayList<>();

            for (char c: str.toCharArray()) {
                String morse = morseCode.get(c);
                asMorseBuilder.append(morse);
                morseLengths.add(morse.length());
            }

            Collections.reverse(morseLengths);
            String asMorse = asMorseBuilder.toString();

            int p = 0;
            for (int l: morseLengths) {
                String substring = asMorse.substring(p, p + l);
                answer.append(reverseMorse.get(substring));
                p += l;
            }

            resolved.add(answer.toString());
        }

        return resolved.stream().collect(Collectors.joining("\n"));
    }

    protected Map<Character, String> setupMorseCode() {
        Map<Character, String> code = new HashMap<>();

        code.put('A',".-");
        code.put('H',"....");
        code.put('O',"---");
        code.put('V',"...-");
        code.put('B',"-...");
        code.put('I',"..");
        code.put('P',".--.");
        code.put('W',".--");
        code.put('C',"-.-.");
        code.put('J',".---");
        code.put('Q',"--.-");
        code.put('X',"-..-");
        code.put('D',"-..");
        code.put('K',"-.-");
        code.put('R',".-.");
        code.put('Y',"-.--");
        code.put('E',".");
        code.put('L',".-..");
        code.put('S',"...");
        code.put('Z',"--..");
        code.put('F',"..-.");
        code.put('M',"--");
        code.put('T',"-");
        code.put('G',"--.");
        code.put('N',"-.");
        code.put('U',"..-");

        code.put('_',"..--");
        code.put('.',"---.");
        code.put(',',".-.-");
        code.put('?',"----");

        return code;
    }

    protected Map<String, Character> reverseMorseCode() {
        Map<String, Character> code = new HashMap<>();

        code.put(".-", 'A');
        code.put("....", 'H');
        code.put("---", 'O');
        code.put("...-", 'V');
        code.put("-...", 'B');
        code.put("..", 'I');
        code.put(".--.", 'P');
        code.put(".--", 'W');
        code.put("-.-.", 'C');
        code.put(".---", 'J');
        code.put("--.-", 'Q');
        code.put("-..-", 'X');
        code.put("-..", 'D');
        code.put("-.-", 'K');
        code.put(".-.", 'R');
        code.put("-.--", 'Y');
        code.put(".", 'E');
        code.put(".-..", 'L');
        code.put("...", 'S');
        code.put("--..", 'Z');
        code.put("..-.", 'F');
        code.put("--", 'M');
        code.put("-", 'T');
        code.put("--.", 'G');
        code.put("-.", 'N');
        code.put("..-", 'U');

        code.put("..--", '_');
        code.put("---.", '.');
        code.put(".-.-", ',');
        code.put("----", '?');

        return code;
    }
}
