import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class CaloriesTest extends AbstractTest {

	private Calories calories;

	@Before
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

		Assert.assertEquals(9, c.fat, 0.1);
		Assert.assertEquals(1, c.alcohol, 0.1);
		int i = c.percentFat();
		Assert.assertEquals(32, i);
	}

	@Test
	public void shouldCalculateCalories() {
		Calories.ConsumptionHolder c = new Calories.ConsumptionHolder();

		c.fat = new Calories.Holder("10C");
		c.sugar = new Calories.Holder("50%");

		Calories.Consumption consumption = calories.calories(c);

		Assert.assertEquals(10, consumption.fat, 0.1);
		Assert.assertEquals(10, consumption.sugar, 0.1);
		Assert.assertEquals(50, consumption.percentFat());

		c = new Calories.ConsumptionHolder();

		c.fat = new Calories.Holder("7C");
		c.sugar = new Calories.Holder("10%");
		c.starch = new Calories.Holder("10%");
		c.protein = new Calories.Holder("10%");

		consumption = calories.calories(c);

		Assert.assertEquals(7, consumption.fat, 0.1);
		Assert.assertEquals(1, consumption.sugar, 0.1);
		Assert.assertEquals(1, consumption.starch, 0.1);
		Assert.assertEquals(1, consumption.protein, 0.1);

		Assert.assertEquals(70, consumption.percentFat());
	}

	@Override
	protected String getDir() {
		return "calories";
	}
}