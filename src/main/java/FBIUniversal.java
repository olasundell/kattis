import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * The FBI has recently changed its Universal Control Numbers (UCN) for identifying individuals who are in the FBI’s fingerprint database to an eight digit base 27
 *  value with a ninth check digit. The digits used are:
 *
 * 0123456789ACDEFHJKLMNPRTVWX
 * Some letters are not used because of possible confusion with other digits:
 *
 * B->8, G->C, I->1, O->0, Q->0, S->5, U->V, Y->V, Z->2
 * The check digit is computed as:
 *
 * (2*D1 + 4*D2 + 5*D3 + 7*D4 + 8*D5 + 10*D6 + 11*D7 + 13*D8) mod 27
 * Where Dn is the nth *  digit from the left.
 *
 * This choice of check digit detects any single digit error and any error transposing an adjacent pair of the original eight digits.
 *
 * For this problem, you will write a program to parse a UCN input by a user.
 * Your program should accept decimal digits and any capital letter as digits.
 * If any of the confusing letters appear in the input, you should replace them with the corresponding valid digit as
 * listed above. Your program should compute the correct check digit and compare it to the entered check digit.
 * The input is rejected if they do not match otherwise the decimal (base 10) value
 * corresponding to the first eight digits is returned.
 *
 * Input
 * The first line of input contains a single decimal integer P, (1≤P≤10000),
 * which is the number of data sets that follow. Each data set should be processed identically and independently.
 * Each data set consists of a single line of input. It contains the data set number, K, followed by a single space,
 * followed by 9 decimal digits or capital (alphabetic) characters.
 */
public class FBIUniversal {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new FBIUniversal().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		in.nextLine();
		List<String> results = new ArrayList<>();

		for (int i = 0 ; i < n ; i++) {
			results.add(String.valueOf(i + 1) + " " + checkLine(in.nextLine()));
		}
		return results.stream().collect(Collectors.joining("\n"));
	}

	private String checkLine(String s) {
		String[] parts = s.split(" ");
		int lineNo = Integer.valueOf(parts[0]);

		long sum = calcChecksum(parts[1]);
		char checksumDigit = parts[1].toCharArray()[parts[1].length() - 1];

		if (sum % 27 == findDigitValue(checksumDigit)) {
			return String.valueOf(toDecimal(parts[1].substring(0, parts[1].length() - 1)));
		} else {
			return "Invalid";
		}
	}

	private Long toDecimal(String number) {
		StringBuilder builder = new StringBuilder();

		for (char c: number.toCharArray()) {
			builder.append(findDigitChar(c));
		}

		return Long.parseLong(builder.toString(), 27);
	}

	private long calcChecksum(String part) {
		final char[] chars = part.toCharArray();
		long sum = 0;
		for (int i = 0 ; i < chars.length - 1; i++) {
			int v = findDigitValue(chars[i]);
			sum += v * findPosMultiplier(i);
		}

		return sum;
	}

	private int findPosMultiplier(int i) {
		switch (i) {
			case 0:
				return 2;
			case 1:
				return 4;
			case 2:
				return 5;
			case 3:
				return 7;
			case 4:
				return 8;
			case 5:
				return 10;
			case 6:
				return 11;
			case 7:
				return 13;
			default:
				throw new IllegalArgumentException(i + " is not a valid position");
		}
	}

	private int findDigitValue(char c) {
		return Integer.valueOf(String.valueOf(findDigitChar(c)), 27);
	}

	private char findDigitChar(char c) {
		if (Character.isAlphabetic(c)) {
			switch (c) {
				case 'A':
					return 'A';
				case 'C':
					return 'B';
				case 'D':
					return 'C';
				case 'E':
					return 'D';
				case 'F':
					return 'E';
				case 'H':
					return 'F';
				case 'J':
					return 'G';
				case 'K':
					return 'H';
				case 'L':
					return 'I';
				case 'M':
					return 'J';
				case 'N':
					return 'K';
				case 'P':
					return 'L';
				case 'R':
					return 'M';
				case 'T':
					return 'N';
				case 'V':
					return 'O';
				case 'W':
					return 'P';
				case 'X':
					return 'Q';
			}
		}

		return c;
	}
}
