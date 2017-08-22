import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Output the resulting image after convolution, consisting of H−N+1 lines, each with W−M+1 integers.
 */
public class ImageProcessing {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new ImageProcessing().solve(in));
	}

	public String solve(Scanner in) {
		int xSize = in.nextInt();
		int ySize = in.nextInt();
		int kxSize = in.nextInt();
		int kySize = in.nextInt();

		int[][] image = new int[ySize][xSize];
		int[][] kernel = new int[kySize][kxSize];

		for (int i = 0 ; i < ySize ; i++) {
			for (int j = 0 ; j < xSize ; j++) {
				image[i][j] = in.nextInt();
			}
		}

		for (int i = 1 ; i <= kySize ; i++) {
			for (int j = 1; j <= kxSize; j++) {
				kernel[kySize - i][kxSize - j] = in.nextInt();
			}
		}

		List<List<Integer>> result = createResult(image, kernel);

		return result.stream().map(l -> l.stream().map(String::valueOf).collect(Collectors.joining(" "))).collect(Collectors.joining("\n"));
	}

	private List<List<Integer>> createResult(int[][] image, int[][] kernel) {
		final int rySize = image.length - kernel.length + 1;
		final int rxSize = image[0].length - kernel[0].length + 1;

		List<List<Integer>> resultList = new ArrayList<>();

		for (int i = 0 ; i < rySize ; i++) {
			List<Integer> row = new ArrayList<>();
			for (int j = 0; j < rxSize ; j++) {
				row.add(calcPos(i, j, image, kernel));
			}

			resultList.add(row);
		}


		return resultList;
	}

	private Integer calcPos(int y, int x, int[][] image, int[][] kernel) {
		int r = 0;
		for (int i = 0 ; i < kernel.length ; i++) {
			for (int j = 0 ; j < kernel[0].length ; j++) {
				r += kernel[i][j] * image[i + y][j + x];
			}
		}

		return r;
	}
}
