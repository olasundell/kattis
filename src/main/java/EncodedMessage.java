import util.Matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class EncodedMessage {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new EncodedMessage().solve(in));
	}

	public String solve(Scanner in) {
		List<String> solutions = new ArrayList<>();

		in.nextLine();
		while (in.hasNextLine()) {
			String encoded = in.nextLine();

			solutions.add(decode(encoded));
		}
		return solutions.stream().collect(Collectors.joining("\n"));
	}

	private String decode(String encoded) {
		int size = (int) Math.sqrt(encoded.length());
		byte[] d = new byte[encoded.length()];
		byte[] bytes = encoded.getBytes();

		for (int i = 0 ; i < size ; i++) {
			for (int j = 0 ; j < size ; j++) {
				int x = Matrix.translateX(i, j, size, Matrix.Direction.LEFT);
				int y = Matrix.translateY(i, j, size, Matrix.Direction.LEFT);

				byte b = bytes[y * size + x];
				d[(size -1 - i) * size + j] = b;
			}
		}

		return new String(d);
	}
}
