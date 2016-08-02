import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Bela {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Bela().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		char dominant = in.next().charAt(0);
		in.nextLine();
		int val = 0;

		while (in.hasNextLine()) {
			String line = in.nextLine();
			val += parseLine(line, dominant);
		}

		return String.valueOf(val);
	}

	int parseLine(String line, char dominant) {
		char[] arr = line.toCharArray();

		switch (arr[0]) {
			case 'A':
				return 11;
			case 'K':
				return 4;
			case 'Q':
				return 3;
			case 'J':
				if (arr[1] == dominant) {
					return 20;
				} else {
					return 2;
				}
			case 'T':
				return 10;
			case '9':
				if (arr[1] == dominant) {
					return 14;
				}
		}

		return 0;
	}
}
