import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class MusicYourWay {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new MusicYourWay().solve(in));
	}

	public String solve(Scanner in) {
		String rawAttributes = in.nextLine();
		String[] attributes = rawAttributes.split(" ");

		Map<String, PriorityQueue<Entry>> entries = initEntries(attributes);

		populateEntries(in, attributes, entries);

		List<String> sortBy = findSortOrder(in);

		return sortBy.stream()
				.map(s -> getString(rawAttributes, entries, s))
				.collect(Collectors.joining("\n\n"));
	}

	private String getString(String rawAttributes, Map<String, PriorityQueue<Entry>> entries, String s) {
		PriorityQueue<Entry> lists = new PriorityQueue<>(entries.get(s).comparator());
		lists.addAll(entries.get(s));
		List<Entry> newL = new ArrayList<>();

		int i = 0;
		while (!lists.isEmpty()) {
			Entry poll = lists.poll();
			poll.currentPos = i;
			newL.add(poll);
			i++;
		}

		List<String> collect = newL.stream()
				.map(l -> l.list.stream().collect(Collectors.joining(" "))).collect(Collectors.toList());

		return rawAttributes + "\n" + collect.stream().collect(Collectors.joining("\n"));
	}

	private Map<String, PriorityQueue<Entry>> initEntries(String[] attributes) {
		Map<String, PriorityQueue<Entry>> entries = new HashMap<>();

		for (int i = 0 ; i < attributes.length ; i++) {
			entries.put(attributes[i], new PriorityQueue<>(new EntryComparator(i)));
		}
		return entries;
	}

	private void populateEntries(Scanner in, String[] attributes, Map<String, PriorityQueue<Entry>> entries) {
		int n = in.nextInt();
		in.nextLine();

		for (int i = 0 ; i < n ; i++) {
			String[] line = in.nextLine().split(" ");
			Entry entry = new Entry(Arrays.asList(line), i);

			for (int j = 0 ; j < attributes.length ; j++) {
				entries.get(attributes[j]).add(entry);
			}
		}
	}

	private List<String> findSortOrder(Scanner in) {
		List<String> sortBy = new ArrayList<>();
		int p = in.nextInt();
		in.nextLine();

		for (int i = 0 ; i < p ; i++) {
			sortBy.add(in.nextLine());
		}

		return sortBy;
	}

	static class Entry {
		final List<String> list;
		int currentPos;

		public Entry(List<String> list, int origPos) {
			this.list = list;
			this.currentPos = origPos;
		}

		public String get(int pos) {
			return list.get(pos);
		}
	}

	static class EntryComparator implements Comparator<Entry> {
		final int pos;

		public EntryComparator(int pos) {
			this.pos = pos;
		}

		@Override
		public int compare(Entry o1, Entry o2) {
			int i = o1.get(pos).compareTo(o2.get(pos));
			if (i == 0) {
				return o1.currentPos - o2.currentPos;
			}
//			System.err.println("Comparing " + o1.get(currentPos) + " with " + o2.get(currentPos) + " which yields " + i);
			return i;
		}
	}
}
