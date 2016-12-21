package util;

import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Unbounded knapsack solver
 */
public class UnboundedKnapsack {

	/**
	 * An item representation.
	 */
	public static final class Item {
		private final String name;
		private final Integer value;
		private final Integer size;

		public Item(String name, Integer value, Integer size) {
			this.name = name;
			this.value = value;
			this.size = size;
		}

		public String getName() {
			return name;
		}

		public Integer getSize() {
			return size;
		}

		public Integer getValue() {
			return value;
		}

		public Double getValueToSizeRatio() {
			return (double)value / (double) size;
		}
	}

	/**
	 * An item in a knapsack
	 */
	public static final class BaggedItem {
		private final Item item;
		private final Integer counter;

		BaggedItem(Item item, Integer counter) {
			this.item = item;
			this.counter = counter;
		}

		public Item getItem() {
			return item;
		}

		public Integer getCounter() {
			return counter;
		}

		public Integer getTotalValue() {
			return item.value * counter;
		}

		public Integer getTotalSize() {
			return item.size * counter;
		}
	}

	/**
	 * Knapsack problem solution.
	 */
	public static final class Solution {
		private final Collection<BaggedItem> baggedItems;

		Solution(Collection<BaggedItem> baggedItems) {
			this.baggedItems = baggedItems;
		}

		public Collection<BaggedItem> getBaggedItems() {
			return baggedItems;
		}

		public Integer getTotalValue() {
			return baggedItems.stream().map(BaggedItem::getTotalValue).reduce(0, Integer::sum);
		}

		public Integer getTotalSize() {
			return baggedItems.stream().map(BaggedItem::getTotalSize).reduce(0, Integer::sum);
		}

		public Integer getTotalItems() {
			return baggedItems.stream().map(BaggedItem::getCounter).reduce(0, Integer::sum);
		}

	}

	private UnboundedKnapsack() {}

	/**
	 * Solves the unbounded knapsack problem for a given collection of items.
	 *
	 * @param items available items
	 * @param capacity knapsack capacity (total)
	 */
	public static Solution solve(final List<Item> items, final Integer capacity) {
		final Integer normFactor = calculateNormalizationFactor(items, capacity);
		final List<Item> normItems = normalizedItemsCopy(items, normFactor);
		final Integer normCapacity = capacity / normFactor;

		final Solution solution = dynamicProgrammingSolution(normItems, normCapacity);

		return denormalizedSolution(solution, normFactor);
	}

	/**
	 * Dynamic programming implementation based on <a href="http://rosettacode.org/wiki/Knapsack_problem/Unbounded/Python_dynamic_programming#DP.2C_single_size_dimension">Rosetta Code</a>.
	 */
	private static Solution dynamicProgrammingSolution(final List<Item> items, final Integer capacity) {
		Collections.sort(items, (Item i1, Item i2) -> (i2.getValueToSizeRatio().compareTo(i1.getValueToSizeRatio())));

		//Keeps track of current sack value for given capacity
		final int[] sackValues = new int[capacity+1];

		//Keeps track of items that "completed" a given capacity. That is, lastItem[c] is the index of the item, that was
		//most recently added to the sack with capacity 'c'
		final int[] lastItem = new int[capacity+1];

		//There is no "last item" in a given capacity by default. We'll be using a negative index to distinguish this
		//case (clarity).
		Arrays.fill(lastItem, -1);

		for (int i=0; i<items.size(); i++) {
			final Item item = items.get(i);
			final int size = item.getSize();
			final int value = item.getValue();

			for (int c=size; c <= capacity; c++) {
				final int trial = sackValues[c-size] + value;

				if (sackValues[c] < trial) {
					sackValues[c] = trial;
					lastItem[c] = i;
				}
			}
		}

		final List<BaggedItem> baggedItems = new ArrayList<>();
		final int[] counters = collectItemCounters(items, capacity, lastItem);
		for (int i=0; i < items.size(); i++) {
			baggedItems.add(new BaggedItem(items.get(i), counters[i]));
		}
		return new Solution(Collections.unmodifiableCollection(baggedItems));
	}

	/**
	 * A helper method for the dynamic programming solution, which maps the lastItem array to an array of counters.
	 */
	private static int[] collectItemCounters(final List<Item> items, final Integer capacity, final int[] lastItem) {
		int counters[] = new int[items.size()];
		int c = capacity;
		while (c > 0) {
			int itemIndex = lastItem[c];

			//If no item was added in this capacity, move to the previous one.
			while (itemIndex < 0 && c > 0) {
				c--;
				itemIndex = lastItem[c];
			}

			//If an item was found, increment it's counter and move "down" by current item size.
			if (itemIndex >= 0 && c > 0) {
				counters[itemIndex]++;
				c = c - items.get(itemIndex).getSize();
			}
		};
		return counters;
	}

	/**
	 * Calculates the normalization factor for input data (to save memory during dp iterations)
	 */
	private static Integer calculateNormalizationFactor(final List<Item> items, final Integer capacity) {
		final BiFunction<Integer, Integer, Integer> gcd = (Integer a, Integer b) -> BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
		return items.stream().map((item) -> {
			return item.getSize() == 0 ? capacity : gcd.apply(item.getSize(), capacity);
		}).reduce(capacity, Integer::min);
	}

	/**
	 * Creates a normalized copy of input items.
	 */
	private static List<Item> normalizedItemsCopy(final List<Item> items, final int normFactor) {
		final List<Item> normItems = new ArrayList<>(items.size());
		for (Item i: items) {
			normItems.add(new Item(i.name, i.value, i.size / normFactor));
		}
		return normItems;
	}

	/**
	 * Creates a denormalized copy of the solution.
	 */
	private static Solution denormalizedSolution(final Solution solution, final Integer normFactor) {
		final List<BaggedItem> denormItems = solution.baggedItems.stream().map((baggedItem) -> {
			final Item item = baggedItem.item;
			return new BaggedItem(new Item(item.name, item.value, item.size * normFactor), baggedItem.counter);
		}).collect(Collectors.toList());

		return new Solution(Collections.unmodifiableCollection(denormItems));
	}

	public static void main(String []args) {
		final Scanner scanner = new Scanner(System.in);
		final Integer capacity = scanner.nextInt();
		final List<Item> items = new ArrayList<>();
		while (scanner.hasNextLine()) {
			final String line = scanner.nextLine();
			if (line.trim().isEmpty()) {
				continue;
			}
			final String[] fields = line.split(",");
			items.add(new Item(fields[0], Integer.parseInt(fields[2]), Integer.parseInt(fields[1])));
		}

		final Solution solution = solve(items, capacity);
		solution.baggedItems.forEach((bi) -> {
			System.out.println(MessageFormat.format("{0},{1,number,#},{2,number,#},{3,number,#}", bi.getItem().getName(), bi.getCounter(), bi.getTotalSize(), bi.getTotalValue()));
		});

		System.out.println(MessageFormat.format("{0,number,#},{1,number,#}", solution.getTotalSize(), solution.getTotalValue()));
	}
}