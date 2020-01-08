import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * TODO write documentation
 */
public class CaloriesTest extends AbstractTest {

	private Calories calories;

	@BeforeEach
	public void setUp() throws Exception {
		calories = new Calories();
	}

	@Test
	public void one() throws IOException {
		runTest(1, calories::solve);
	}

	@Test
	public void shouldParseLine() {
		Calories.Consumption c = calories.parseLine("1g 15% 20% 30% 1C");

		assertEquals(9, c.fat, 0.1);
		assertEquals(1, c.alcohol, 0.1);
		int i = c.percentFat();
		assertEquals(32, i);
	}

	@Test
	public void shouldCalculateCalories() {
		Calories.ConsumptionHolder c = new Calories.ConsumptionHolder();

		c.fat = new Calories.Holder("10C");
		c.sugar = new Calories.Holder("50%");

		Calories.Consumption consumption = calories.calories(c);

		assertEquals(10, consumption.fat, 0.1);
		assertEquals(10, consumption.sugar, 0.1);
		assertEquals(50, consumption.percentFat());

		c = new Calories.ConsumptionHolder();

		c.fat = new Calories.Holder("7C");
		c.sugar = new Calories.Holder("10%");
		c.starch = new Calories.Holder("10%");
		c.protein = new Calories.Holder("10%");

		consumption = calories.calories(c);

		assertEquals(7, consumption.fat, 0.1);
		assertEquals(1, consumption.sugar, 0.1);
		assertEquals(1, consumption.starch, 0.1);
		assertEquals(1, consumption.protein, 0.1);

		assertEquals(70, consumption.percentFat());
	}

	@Override
	protected String getDir() {
		return "calories";
	}
}