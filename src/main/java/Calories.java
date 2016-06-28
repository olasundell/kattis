import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Calories {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Calories().solve(in));
	}

	public String solve(Scanner in) {
		List<String> result = new ArrayList<>();
		List<Consumption> calories = new ArrayList<>();

		while (in.hasNextLine()) {
			String line = in.nextLine();

			if ("-".equals(line)) {
				if (!calories.isEmpty()) {
					result.add(String.format("%.0f%%", calculateAverageUsingSum(calories)));
				}
				calories.clear();
				continue;
			}

			calories.add(parseLine(line));
		}
		return result.stream().collect(Collectors.joining("\n"));
	}

	private double calculateAverageUsingSum(List<Consumption> calories) {
		Consumption totalConsumption = new Consumption();
		calories.forEach(totalConsumption::add);

		return totalConsumption.percentFat();
	}

	private double calculateAverage(List<Consumption> calories) {
		return calories.stream()
				.mapToInt(c -> c.percentFat())
				.average()
				.getAsDouble();
	}

	protected Consumption parseLine(String line) {
		String[] parts = line.split(" ");
		ConsumptionHolder consumption = new ConsumptionHolder();

		consumption.fat = new Holder(parts[0]);
		consumption.protein = new Holder(parts[1]);
		consumption.sugar = new Holder(parts[2]);
		consumption.starch = new Holder(parts[3]);
		consumption.alcohol = new Holder(parts[4]);

		return calories(consumption);
	}

	protected Consumption calories(ConsumptionHolder c) {
		Equation eq = new Equation();

		decorate(eq, c.fat, 9);
		decorate(eq, c.sugar, 4);
		decorate(eq, c.starch, 4);
		decorate(eq, c.protein, 4);
		decorate(eq, c.alcohol, 6);

		Consumption consumption = new Consumption();

		consumption.fat = findValue(eq, c.fat, 9);
		consumption.sugar= findValue(eq, c.sugar, 4);
		consumption.starch = findValue(eq, c.starch, 4);
		consumption.protein = findValue(eq, c.protein, 4);
		consumption.alcohol = findValue(eq, c.alcohol, 6);

		return consumption;
	}

	private double findValue(Equation eq, Holder holder, int calorieValue) {
		if (holder == null) {
			return 0;
		} else if (holder.unit == Unit.PERCENT) {
			return (holder.value * eq.totalCalories()) / 100;
		} else if (holder.unit == Unit.GRAMME) {
			return holder.value * calorieValue;
		} else {
			return holder.value;
		}
	}

	private void decorate(Equation eq, Holder holder, double calorieValue) {
		if (holder == null) {
			return;
		}

		if (holder.unit == Unit.PERCENT) {
			eq.totalPercent += holder.value;
		} else if (holder.unit == Unit.GRAMME) {
			eq.totalCalories += holder.value * calorieValue;
		} else {
			eq.totalCalories += holder.value;
		}
	}

	protected static class Equation {
		double totalPercent;
		double totalCalories;

		private double totalCalories() {
			if (totalPercent == 0) {
				return totalCalories;
			}

			return 100.0 * totalCalories / (100.0 - totalPercent);
		}
	}

	protected static class Holder {
		final double value;
		final Unit unit;

		Holder(String s) {
			if (s.endsWith("g")) {
				unit = Unit.GRAMME;
			} else if (s.endsWith("C")) {
				unit = Unit.CALORIE;
			} else {
				unit = Unit.PERCENT;
			}

			value = Double.valueOf(s.substring(0, s.length() - 1));
		}
	}

	protected enum Unit {
		PERCENT,
		CALORIE,
		GRAMME
	}

	protected static class Consumption {
		double fat;
		double alcohol;
		double protein;
		double starch;
		double sugar;

		protected void add(Consumption c) {
			fat += c.fat;
			alcohol += c.alcohol;
			protein += c.protein;
			starch += c.starch;
			sugar += c.sugar;
		}

		protected int percentFat() {
			double v = 100 * fat;
			double v1 = fat + alcohol + protein + starch + sugar;

			double a = v / v1;

			return (int)Math.round(a);
		}
	}

	protected static class ConsumptionHolder {
		Holder fat;
		Holder alcohol;
		Holder protein;
		Holder starch;
		Holder sugar;
	}
}
