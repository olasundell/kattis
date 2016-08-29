package juryjeopardy;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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

//	@Test
//	public void executor() throws InterruptedException {
//		ExecutorService executor = Executors.newSingleThreadExecutor();
//
//		executor.submit(() -> {
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				System.err.println("Interrupted");
//			}
//			System.err.println("Finished");
//		});
//
//		executor.submit(() -> {
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				System.err.println("Interrupted");
//			}
//			System.err.println("Finished");
//		});
//
//		executor.shutdown();
//		executor.awaitTermination(2, TimeUnit.SECONDS);
//	}


}