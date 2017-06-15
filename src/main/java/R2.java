import java.util.Scanner;

/**
 * TODO write documentation
 */
public class R2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new R2().solve(in));
	}

	public String solve(Scanner in) {
		int r1 = in.nextInt();
		int s = in.nextInt();
		int r2 = s * 2 - r1;
		return String.valueOf(r2);
	}
}
