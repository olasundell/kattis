import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class ANewAlphabet {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new ANewAlphabet().solve(in));
	}

	public String solve(Scanner in) {
		return translate(in.nextLine());
	}

	private String translate(String in) {
		Map<Character, String> map = translationMap();
		final char[] chars = in.toLowerCase().toCharArray();
		StringBuilder builder = new StringBuilder();
		for (char c: chars) {
			builder.append(map.getOrDefault(c, String.valueOf(c)));
		}
		return builder.toString();
	}

	private Map<Character, String> translationMap() {
		return new HashMap<Character, String>() {{
//		a @ at symbol
			put('a', "@");
//n []\[] brackets, backslash, brackets
			put('n', "[]\\[]");
//b 8 digit eight
			put('b', "8");
//o 0 digit zero
			put('o', "0");
//c ( open parenthesis
			put('c', "(");
//p |D bar, capital D
			put('p', "|D");
//d |) bar, close parenthesis
			put('d', "|)");
//q (,) parenthesis, comma, parenthesis
			put('q', "(,)");
//e 3 digit three
			put('e', "3");
//r |Z bar, capital Z
			put('r', "|Z");
//f # number sign (hash)
			put('f', "#");
//s $ dollar sign
			put('s', "$");
//g 6 digit six
			put('g', "6");
//t '][' quote, brackets, quote
			put('t', "']['");
//h [-] bracket, hyphen, bracket
			put('h', "[-]");
//u |_| bar, underscore, bar
			put('u', "|_|");
//i | bar
			put('i', "|");
//v \/ backslash, forward slash
			put('v', "\\/");
//j _| underscore, bar
			put('j', "_|");
//w \/\/ four slashes
			put('w', "\\/\\/");
//k |< bar, less than
			put('k', "|<");
//x }{ curly braces
			put('x', "}{");
//l 1 digit one
			put('l', "1");
//y `/ backtick, forward slash
			put('y', "`/");
//m []\/[] brackets, slashes, brackets
			put('m', "[]\\/[]");
//z 2 digit two
			put('z', "2");
		}};
	}
}
