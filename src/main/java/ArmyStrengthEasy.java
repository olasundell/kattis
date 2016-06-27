import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class ArmyStrengthEasy {
	protected static final String UNCERTAIN = "uncertain";
	protected static final String MECHA_GODZILLA = "MechaGodzilla";
	protected static final String GODZILLA = "Godzilla";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new ArmyStrengthEasy().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		List<String> result = new ArrayList<>();

		in.nextLine();
		for (int i = 0 ; i < n ; i++) {
			in.nextLine();

			int nGod = in.nextInt();
			int nMech = in.nextInt();

			in.nextLine();

			if (nGod == 0 && nMech == 0) {
				result.add(UNCERTAIN);
				continue;
			}

			int hGod = Integer.MIN_VALUE;
			int hMech = Integer.MIN_VALUE;

			String[] l = in.nextLine().split(" ");
			String[] l2 = in.nextLine().split(" ");

			for (String s: l) {
				int t = Integer.valueOf(s);
				if (t > hGod) {
					hGod = t;
				}
			}

			for (String s: l2) {
				int t = Integer.valueOf(s);
				if (t > hMech) {
					hMech = t;
				}
			}

			if (hGod >= hMech) {
				result.add(GODZILLA);
			} else {
				result.add(MECHA_GODZILLA);
			}
		}

		return result.stream().collect(Collectors.joining("\n"));
	}

	public String solveDeprecated(Scanner in) {
		int n = in.nextInt();
		List<String> result = new ArrayList<>();

		in.nextLine();
		for (int i = 0 ; i < n ; i++) {
			in.nextLine();

			int nGod = in.nextInt();
			int nMech = in.nextInt();

			PriorityQueue<Integer> godzilla = new PriorityQueue<>();
			PriorityQueue<Integer> mecha = new PriorityQueue<>();
//			List<Integer> godzilla = new ArrayList<>();
//			List<Integer> mecha = new ArrayList<>();

			for (int j = 0; j < nGod; j++) {
				godzilla.add(in.nextInt());
			}

			for (int j = 0; j < nMech; j++) {
				mecha.add(in.nextInt());
			}

//			Collections.sort(godzilla);
//			Collections.sort(mecha);

			result.add(fight(godzilla, mecha));
		}
		return result.stream().collect(Collectors.joining("\n"));
	}

	protected String fight(SortedMap<Integer, Integer> godzilla, SortedMap<Integer, Integer> mecha) {
		SortedMap<Integer, Integer> g = new TreeMap<>(godzilla);
		SortedMap<Integer, Integer> m = new TreeMap<>(mecha);

		while (!g.isEmpty() && !m.isEmpty()) {
			if (g.firstKey() >= m.firstKey()) {
				reduce(m);
			} else {
				reduce(g);
			}
		}

		if (g.isEmpty() && m.isEmpty()) {
			return UNCERTAIN;
		} else if (g.isEmpty()) {
			return MECHA_GODZILLA;
		} else if (m.isEmpty()) {
			return GODZILLA;
		}

		return "";
	}

	private void reduce(SortedMap<Integer, Integer> map) {
		if (map.get(map.firstKey()) > 0) {
			map.put(map.firstKey(), map.get(map.firstKey()) - 1);
		} else {
			map.remove(map.firstKey());
		}
	}

	protected String fight(List<Integer> godzilla, List<Integer> mecha) {
		if (godzilla.size() == 0 && mecha.size() == 0) {
			return UNCERTAIN;
		}

		for (int i = 0, j = 0;  ; ) {
			if (i == godzilla.size()) {
				return MECHA_GODZILLA;
			} else if (j == mecha.size()) {
				return GODZILLA;
			}

			if (godzilla.get(i) >= mecha.get(j)) {
				j++;
			} else {
				i++;
			}
		}
	}

	protected String fight(PriorityQueue<Integer> godzilla, PriorityQueue<Integer> mecha) {
//		return fightQueue(godzilla, mecha);
		return fightIterator(godzilla, mecha);
	}

	private String fightIterator(PriorityQueue<Integer> godzilla, PriorityQueue<Integer> mecha) {
		if (godzilla.isEmpty() && mecha.isEmpty()) {
			return UNCERTAIN;
		} else if (godzilla.isEmpty()) {
			return MECHA_GODZILLA;
		} else if (mecha.isEmpty()) {
			return GODZILLA;
		}

		Iterator<Integer> g = godzilla.iterator();
		Iterator<Integer> m = mecha.iterator();

		int gSoldier = g.next();
		int mSoldier = m.next();

		while (g.hasNext() && m.hasNext()) {
			if (gSoldier >= mSoldier) {
				mSoldier = m.next();
			} else {
				gSoldier = g.next();
			}
		}

		if (!g.hasNext() && !m.hasNext()) {
			if (gSoldier >= mSoldier) {
				return GODZILLA;
			} else {
				return MECHA_GODZILLA;
			}
		} else if (!g.hasNext()) {
			return MECHA_GODZILLA;
		} else if (!m.hasNext()) {
			return GODZILLA;
		}

		return UNCERTAIN;
	}

	private String fightQueue(PriorityQueue<Integer> godzilla, PriorityQueue<Integer> mecha) {
		PriorityQueue<Integer> g = godzilla;
		PriorityQueue<Integer> m = mecha;
//		PriorityQueue<Integer> g = new PriorityQueue<>(godzilla);
//		PriorityQueue<Integer> m = new PriorityQueue<>(mecha);

		while (!g.isEmpty() && !m.isEmpty()) {
			if (g.peek() >= m.peek()) {
				m.poll();
			} else {
				g.poll();
			}
		}

		if (g.isEmpty() && m.isEmpty()) {
			return UNCERTAIN;
		} else if (g.isEmpty()) {
			return MECHA_GODZILLA;
		} else if (m.isEmpty()) {
			return GODZILLA;
		}

//		return fight(g, m);

		return UNCERTAIN;
	}
}
