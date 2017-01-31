import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Stockbroker {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Stockbroker().solve(in));
	}

	public String solve(Scanner in) {
		State state = new State();
		state.priceOverTime = readPriceOverTime(in);

		for (; state.currentDay < state.priceOverTime.size() ; state.currentDay++) {
			state.currentDay = findLocalMin(state);
			buy(state);

			state.currentDay = findLocalMax(state);
			sell(state);
		}

		if (state.currentStocks > 0) {
			state.currentDay = state.priceOverTime.size() - 1;
			sell(state);
		}

		return String.valueOf(state.money);
	}

	private void buy(State state) {
		state.boughtFor = state.priceOverTime.get(state.currentDay);
		state.currentStocks = Math.min((int) Math.floor(state.money / state.boughtFor), 100_000);

		System.err.println(String.format("+++ %6d stocks for %3d, total %9d cur %9d",
				state.currentStocks,
				state.boughtFor,
				state.money - state.money % state.boughtFor,
				state.money % state.boughtFor));

		// TODO max 100_000 stocks
		state.money = state.money % state.boughtFor;

	}

	private void sell(State state) {
		int sellPrice = state.priceOverTime.get(state.currentDay);
		state.money += state.currentStocks * sellPrice;

		System.err.println(String.format("--- %6d stocks for %3d, total %9d cur %9d",
				state.currentStocks,
				sellPrice,
				state.currentStocks * sellPrice,
				state.money));

		state.currentStocks = 0;
	}

	protected int findLocalMin(State state) {
		int currentMin = state.priceOverTime.get(state.currentDay);

		for (int i = state.currentDay + 1; i < state.priceOverTime.size() ; i++) {
			if (state.priceOverTime.get(i) < currentMin) {
				currentMin = state.priceOverTime.get(i);
			} else {
				return i - 1;
			}
		}

		return state.priceOverTime.size() - 1;
	}

	protected int findLocalMax(State state) {
		int currentMax = state.priceOverTime.get(state.currentDay);

		for (int i = state.currentDay + 1; i < state.priceOverTime.size() ; i++) {
			if (state.priceOverTime.get(i) > currentMax) {
				currentMax = state.priceOverTime.get(i);
			} else {
				return i - 1;
			}
		}

		return state.priceOverTime.size() - 1;
	}

	private List<Integer> readPriceOverTime(Scanner in) {
		int n = in.nextInt();
		List<Integer> priceOverTime = new ArrayList<>();

		for (int i = 0 ; i < n ; i++) {
			priceOverTime.add(in.nextInt());
		}

		return priceOverTime;
	}

	static class State {
		long money = 100;
		int currentStocks = 0;
		int currentDay = 0;
		int boughtFor = Integer.MAX_VALUE;
		List<Integer> priceOverTime;
	}
}
