import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class BaconEggsAndSpamTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new BaconEggsAndSpam()::solve);
	}

	@Test
	public void listMapList() {
		List<SortedMap<String, SortedSet<String>>> result = new ArrayList<>();

		SortedMap<String, SortedSet<String>> listHashMap = new TreeMap<>();
		TreeSet<String> value = new TreeSet<>();
		value.add("bar");
		value.add("xyzzy");
		listHashMap.put("foo", value);

		value = new TreeSet<>();

		value.add("ladlas");
		value.add("fafa");

		listHashMap.put("baz", value);

		result.add(listHashMap);

		SortedMap<String, SortedSet<String>> listHashMap1 = new TreeMap<>();

		value = new TreeSet<>();
		value.add("asa");
		value.add("dgsdig");

		listHashMap1.put("fj", value);

		result.add(listHashMap1);

		StringBuilder builder = new StringBuilder();

		for (SortedMap<String, SortedSet<String>> map: result) {
			for (Map.Entry<String, SortedSet<String>> entry: map.entrySet()) {
				builder.append(entry.getKey())
						.append(" ")
						.append(entry.getValue().stream().collect(Collectors.joining(" ")))
						.append("\n");
			}

			builder.append("\n");
		}


//		String s = result.stream()
//				.map(Map::entrySet)
//				.map(set -> set.stream().map(e -> e.getKey() + " " + e.getValue().stream().collect(Collectors.joining(" ")));
//				.map(e -> e.getKey() + " " + e.getValue().stream().collect(Collectors.joining(" ")))
//				.collect(Collectors.joining("\n"));

		System.out.println(builder.toString());
	}

	@Override
	protected String getDir() {
		return "baconeggsandspam";
	}
}