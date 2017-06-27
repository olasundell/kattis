import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Peragrams {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Peragrams().solve(in));
	}

	public String solve(Scanner in) {
		Map<Character, Integer> charCount = new HashMap<>();

		for (char c: in.next().toCharArray()) {
			charCount.put(c, charCount.getOrDefault(c, 0) + 1);
		}

		long count = charCount.values().stream().filter(i -> i % 2 == 1).count();

		return String.valueOf(Math.max(0, count - 1));
	}

//	public String solve(Scanner in) {
//		String s = in.next();
//		List<Character> chars = new ArrayList<>();
//
//		for (char c: s.toCharArray()) {
//			chars.add(c);
//		}
//
//		int x = permute(chars);
//
//		return String.valueOf(s.length() - x);
//	}
//
//	private int permute(List<Character> chars) {
//		long l = Permutations.factorial(chars.size());
//
//		for (long i = 0 ; i < l ; i++) {
//			if (isAnagram(Permutations.permutation(i, chars))) {
//				return chars.size();
//			}
//		}
//
//		if (chars.size() == 2) {
//			return 1;
//		}
//
//		for (int i = 0 ; i < chars.size() ; i++) {
//			List<Character> newChars = new ArrayList<>(chars);
//			newChars.remove(i);
//			int x;
//
//			if ((x = permute(newChars)) >= 0) {
//				return x;
//			}
//		}
//
////		return -1;
//		throw new IllegalStateException("We should have reached a solution by now");
//	}
//
//	private boolean isAnagram(List<Character> chars) {
//		final long halfLength = Math.round(Math.floor(chars.size() / 2));
//		for (int i = 0; i < halfLength; i++) {
//			final Character fromBeginning = chars.get(i);
//			final Character fromEnd = chars.get(chars.size() - (i + 1));
//
//			if (!fromBeginning.equals(fromEnd)) {
//				return false;
//			}
//		}
//
//		return true;
//	}
}
