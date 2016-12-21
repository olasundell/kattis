package juryjeopardy;

import org.junit.Assert;
import org.junit.Test;

/**
 * TODO write documentation
 */
public class MazeTest {
	@Test
	public void shouldBeInitedProperly() {
		Maze maze = new Maze();

		Assert.assertEquals(2, maze.maxX);
		Assert.assertEquals(3, maze.maxY);

		String s = "2 3\n" +
				"##\n" +
				".#\n" +
				"##";

		Assert.assertEquals(s, maze.prettyPrint());
	}
}