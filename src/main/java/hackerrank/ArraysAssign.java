package hackerrank;

import java.util.Scanner;

/**
 * TODO write documentation
 */
public class ArraysAssign {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new ArraysAssign().solve(in));
	}

	public String solve(Scanner in) {
		int arr[][] = new int[6][6];
		for(int i=0; i < 6; i++){
			for(int j=0; j < 6; j++){
				arr[i][j] = in.nextInt();
			}
		}

		int max = Integer.MIN_VALUE;

		for(int i=0; i < 4; i++){
			for(int j=0; j < 4; j++){
				int s = arraySum(i, j, arr);
				if (s > max) {
					max = s;
				}
			}
		}

		return String.valueOf(max);
	}

	private void foo() {
		int[] arr = {1, 2, 3};
		java.util.Arrays.stream(arr).summaryStatistics().getAverage();
	}

	private int arraySum(int i, int j, int[][] arr) {
		return arr[i][j] + arr[i][j+1] + arr[i][j+2] +
				arr[i+1][j+1] +
				arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
	}
}
