import java.util.Scanner;

/**
 * TODO write documentation
 */
public class SavingForRetirement {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new SavingForRetirement().solve(in));
	}

	public String solve(Scanner in) {
		int bobAge = in.nextInt();
		int bobRetireAge = in.nextInt();
		int bobSavePerYear = in.nextInt();

		int aliceAge = in.nextInt();
		int aliceSavePerYear = in.nextInt();

		long bobSavings = (bobRetireAge - bobAge) * bobSavePerYear;
		long aliceRetireAge = (bobSavings / aliceSavePerYear) + aliceAge + 1;

		return String.valueOf(aliceRetireAge);
	}
}
