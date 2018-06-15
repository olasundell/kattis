import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Ostrogoth {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Ostrogoth().solve(in));
	}

	public String solve(Scanner in) {
		String[] words = in.nextLine().split(" ");

		double with = 0;

		for (String w: words) {
			if (w.contains("ae")) {
				with++;
			}
		}

		if (words.length > 0 && (with / words.length) >= 0.4) {
			return "dae ae ju traeligt va";
		} else {
			return "haer talar vi rikssvenska";
		}
	}
}
