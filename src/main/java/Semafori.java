import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Semafori {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Semafori().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		int distance = in.nextInt();
		Map<Integer, Light> lights = new HashMap<>();

		for (int i = 0 ; i < n ; i++) {
			lights.put(in.nextInt(), new Light(in.nextInt(), in.nextInt()));
		}

		int time = 0;
		for (int i = 1 ; i < distance ; i++) {
			if (lights.containsKey(i)) {
				while (lights.get(i).isRed(time)) {
					time++;
				}
			}
			time++;
		}

		return String.valueOf(time);
	}

	static class Light {
		final int redTime;
		final int greenTime;
		final int totalTime;

		public Light(int redTime, int greenTime) {
			this.redTime = redTime;
			this.greenTime = greenTime;

			this.totalTime = redTime + greenTime;
		}

		public boolean isRed(int currentTime) {
			return (currentTime % totalTime) < redTime;
		}
	}
}
