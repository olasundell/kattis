import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class HumanCannonball2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new HumanCannonball2().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		in.nextLine();
		List<Boolean> results = new ArrayList<>();

		for (int i = 0 ; i < n ; i++) {
			State state = new State(in);
			double invTime = (state.velocity * Math.cos(state.angle)) / state.distanceToWall;
			double y = y(state, 1 / invTime);
			results.add(y < state.upperHeight && y > state.lowerHeight);
		}

		return results.stream()
				.map(b -> b ? "Safe" : "Not Safe")
				.collect(Collectors.joining("\n"));
	}

	private long x(State state, double time) {
//		x(t)= v0 t cos(θ);
		return Math.round(state.velocity * time * Math.acos(state.angle));
	}

	private double y(State state, double time) {
		// v0tsinθ−12gt2
		return state.velocity * Math.sin(state.angle) - (9.81 * time * time) / 2;
	}

	private static class State {

		private final double velocity;
		private final double angle;
		private final double distanceToWall;
		private final double lowerHeight;
		private final double upperHeight;

		State(Scanner in) {
			velocity = in.nextDouble();
			angle = Math.toRadians(in.nextDouble());
			distanceToWall = in.nextDouble();
			lowerHeight = in.nextDouble();
			upperHeight = in.nextDouble();
			in.nextLine();
		}

		@Override
		public String toString() {
			return "State{" +
					"velocity=" + velocity +
					", angle=" + angle +
					", distanceToWall=" + distanceToWall +
					", lowerHeight=" + lowerHeight +
					", upperHeight=" + upperHeight +
					'}';
		}
	}
}
