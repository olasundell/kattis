import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class RunningMoMTest extends AbstractTest {
	private final Logger logger = Logger.getLogger(this.getClass().getName());

	@Test
	public void one() throws IOException {
		runTest(1, new RunningMoM()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new RunningMoM()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new RunningMoM()::solve);
	}

	@Test
	public void four() throws IOException {
		runTest(4, new RunningMoM()::solve);
	}

	@Test
	public void longChain() {
		final StringBuilder builder = new StringBuilder();

		builder.append("5000\n");

		for (int i = 0 ; i < 4_999 ; i++) {
			builder.append(i).append(" ").append(i + 1).append("\n");
		}
		builder.append(4_999).append(" ").append(0);


		builder.append("4444");

		new RunningMoM().solve(new Scanner(builder.toString()));
	}

	@Test
	public void manual() {
		logger.info("Creating string");
		final String source = constructString();
		logger.info("Creating scanner");
		final Scanner in = new Scanner(source);
		logger.info("Solving");
		new RunningMoM().solve(in);
	}

	private String constructString() {
		Random random = new Random(0);
		List<UUID> list = new ArrayList<>();
		Map<UUID, Set<UUID>> map = new HashMap<>();

		for (int i = 0 ;i  < 1_000 ; i++) {
			list.add(UUID.randomUUID());
		}

		while (findSize(map) <= 5_000) {
			logger.info("Map size " + findSize(map));
			int from = random.nextInt(list.size());
			int to = from;

			while (to == from) {
				to = random.nextInt(list.size());
			}

			map.computeIfAbsent(list.get(from), (k) -> new HashSet<>()).add(list.get(to));
		}

		final StringBuilder builder = new StringBuilder();

		builder.append(map.size());
		builder.append("\n");

		builder.append(map.entrySet()
				.stream()
				.map(e -> e.getKey().toString() + " " + e.getValue().toString())
				.collect(Collectors.joining("\n")));

		builder.append("\n");

		builder.append(list.stream()
				.map(UUID::toString)
				.collect(Collectors.joining("\n")));

		return builder.toString();
	}

	private int findSize(Map<UUID,Set<UUID>> map) {
		final AtomicInteger c = new AtomicInteger(0);

		map.forEach((k, v) -> c.addAndGet(v.size()));

		return c.get();
	}

	@Override
	protected String getDir() {
		return "runningmom";
	}
}