import org.junit.Assert;
import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;
import java.util.PriorityQueue;

/**
 * TODO write documentation
 */
public class BusyScheduleTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new BusySchedule()::solve);
	}

	@Test
	public void shouldSortProperly() {
		PriorityQueue<BusySchedule.Time> queue = new PriorityQueue<>();

		BusySchedule.Time e = new BusySchedule.Time(1, 0, true);
		BusySchedule.Time e1 = new BusySchedule.Time(1, 1, true);
		BusySchedule.Time e2 = new BusySchedule.Time(1, 1, false);

		queue.add(e);
		queue.add(e1);
		queue.add(e2);

		Assert.assertEquals(e, queue.peek());
	}

	@Override
	protected String getDir() {
		return "busyschedule";
	}
}