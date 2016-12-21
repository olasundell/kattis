import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.counting;

/**
 * TODO write documentation
 */
public class DiceCup {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new DiceCup().solve(in));
	}

	public String solve(Scanner in) {
		int f1 = in.nextInt();
		int f2 = in.nextInt();

		Map<Integer, Pair> map = new HashMap<>();

		for (int i = 1 ; i <= f1 ; i++) {
			for (int j = 1 ; j <= f2 ; j++) {
				int result = i + j;

				if (!map.containsKey(result)) {
					Pair pair = new Pair(result, 1L);
					map.put(result, pair);
				} else {
					map.get(result).inc();
				}
			}
		}

		PriorityQueue<Pair> queue = new PriorityQueue<>((o1, o2) -> {
			if (o1.count == o2.count) {
				return o1.n - o2.n;
			}

			return Math.toIntExact(o2.count - o1.count);
		});

		map.forEach((key, value) -> queue.add(value));

		List<Pair>  results = new ArrayList<>();

		Pair p = queue.poll();
		results.add(p);

		while (queue.peek().count == p.count) {
			results.add(queue.poll());
		}

		return results.stream()
				.map(Pair::getN)
				.map(String::valueOf)
				.collect(Collectors.joining("\n"));
	}

	public String solveSomethingElseEntirely(Scanner in) {
		int numberOfDice = in.nextInt();
		int faces = in.nextInt();
		Map<Integer, Integer> outcomes = new HashMap<>();

		long noOfComb = (long)Math.pow(faces, numberOfDice);

		System.err.println(noOfComb);
		List<Integer> masks = new ArrayList<>();

		for (int i = 0 ; i < numberOfDice ; i++) {
			masks.add((int)Math.pow(faces, i));
		}

		System.err.println(masks);

		Map<Integer, Pair> map = new HashMap<>();
		PriorityQueue<Pair> queue = new PriorityQueue<>((o1, o2) -> {
			if (o1.count == o2.count) {
				return o2.n - o1.n;
			}

			return Math.toIntExact(o1.count - o2.count);
		});

		for (int i = 0 ; i < noOfComb ; i++) {
			int result = 0;

			for (Integer mask : masks) {
				result += (i / mask) % faces + 1;
			}

			if (!map.containsKey(result)) {
				Pair pair = new Pair(result, 1L);
				queue.add(pair);
				map.put(result, pair);
			} else {
				map.get(result).inc();
			}
		}

		List<Pair>  results = new ArrayList<>();

		Pair p = queue.poll();
		results.add(p);

		while (queue.peek().count == p.count) {
			results.add(queue.poll());
		}

		return results.stream()
				.map(Pair::getN)
				.map(String::valueOf)
				.collect(Collectors.joining("\n"));
	}

	private static class Pair {
		final int n;
		long count;

		private Pair(int n, Long count) {
			this.n = n;
			this.count = count;
		}

		public Pair inc() {
			count++;
			return this;
		}

		public int getN() {
			return n;
		}
	}
}
