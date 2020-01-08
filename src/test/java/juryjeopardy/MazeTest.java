package juryjeopardy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * TODO write documentation
 */
public class MazeTest {
	@Test
	public void shouldBeInitedProperly() {
		Maze maze = new Maze();

		assertEquals(2, maze.maxX);
		assertEquals(3, maze.maxY);

		String s = "2 3\n" +
				"##\n" +
				".#\n" +
				"##";

		assertEquals(s, maze.prettyPrint());
	}
}