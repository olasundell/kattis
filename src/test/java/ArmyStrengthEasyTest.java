import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * TODO write documentation
 */
@Ignore("slooow")
public class ArmyStrengthEasyTest extends AbstractTest {

	private ArmyStrengthEasy armyStrengthEasy;
	private PriorityQueue<Integer> godzilla;
	private PriorityQueue<Integer> mecha;
	private SortedMap<Integer, Integer> godzillaMap;
	private SortedMap<Integer, Integer> mechaMap;
	private List<Integer> godzillaList;
	private List<Integer> mechaList;

	@Before
	public void setUp() throws Exception {
		armyStrengthEasy = new ArmyStrengthEasy();
		godzilla = new PriorityQueue<>();
		mecha = new PriorityQueue<>();
		godzillaMap = new TreeMap<>();
		mechaMap = new TreeMap<>();
		godzillaList = new ArrayList<>();
		mechaList = new ArrayList<>();
	}

	@Test
	public void one() throws IOException {
		runTest(1, armyStrengthEasy::solve);
	}

	@Test
	public void two() throws IOException {
		Instant start = Instant.now();
		runTest(2, armyStrengthEasy::solve);
		Instant end = Instant.now();

		System.out.println("Two took " + Duration.between(start, end).toMillis() + " ms");
	}

	@Test
	public void fightWithEmptySetsShouldWork() {
		String result = armyStrengthEasy.fight(godzilla, mecha);

		Assert.assertEquals(ArmyStrengthEasy.UNCERTAIN, result);
	}

	@Test
	public void fightWithGodzillaArmyShouldWork() {
		godzilla.add(1);
		String result = armyStrengthEasy.fight(godzilla, mecha);

		Assert.assertEquals(ArmyStrengthEasy.GODZILLA, result);
	}

	@Test
	public void fightWithMechaGodzillaArmyShouldWork() {
		mecha.add(1);
		String result = armyStrengthEasy.fight(godzilla, mecha);

		Assert.assertEquals(ArmyStrengthEasy.MECHA_GODZILLA, result);
	}

	@Test
	public void fightWithEqualsShouldFavourGodzilla() {
		godzilla.add(1);
		mecha.add(1);
		String result = armyStrengthEasy.fight(godzilla, mecha);

		Assert.assertEquals(ArmyStrengthEasy.GODZILLA, result);
	}

	@Test
	public void compareDatasetConstruction() {
		Random random = new Random(0);
		List<Dataset> dataset = new ArrayList<>();

		for (int j = 0 ; j < 50 ; j++) {
			dataset.add(new Dataset());
		}

		List<Integer> godzillaNums = new ArrayList<>();
		List<Integer> mechaNums = new ArrayList<>();

		for (int j = 0; j < 100_000; j++) {
			godzillaNums.add(random.nextInt(1_000_000_000));
			mechaNums.add(random.nextInt(1_000_000_000));
		}

		Instant startQueue = Instant.now();

		for (int i = 0 ; i < dataset.size() ; i++) {
			for (int j = 0; j < 100_000; j++) {
				dataset.get(i).godzilla.add(godzillaNums.get(j));
				dataset.get(i).mecha.add(mechaNums.get(j));
			}
		}

		Instant endQueue = Instant.now();

		Instant startSet = Instant.now();

		for (int i = 0 ; i < dataset.size() ; i++) {
			for (int j = 0; j < 100_000; j++) {
				dataset.get(i).godzillaSet.add(new MyInt(godzillaNums.get(j)));
				dataset.get(i).mechaSet.add(new MyInt(mechaNums.get(j)));
			}
		}

		Instant endSet = Instant.now();

		System.out.println("Queue: " + Duration.between(startQueue, endQueue).toMillis() + " ms, " +
				"Set: " + Duration.between(startSet, endSet).toMillis() + " ms");
	}

	private static class MyInt implements Comparable<MyInt> {
		int value;

		public MyInt(int value) {
			this.value = value;
		}

		@Override
		public int compareTo(MyInt o) {
			if (o.value == this.value) {
				return -1;
			} else {
				return value - o.value;
			}
		}
	}

	@Test
	@Ignore("too slow")
	public void fightShouldWorkWithMaxDataset() {
		Random random = new Random(0);
		List<Dataset> dataset = new ArrayList<>();

		for (int j = 0 ; j < 50 ; j++) {
			dataset.add(new Dataset());
			for (int i = 0; i < 100_000; i++) {
				dataset.get(j).godzilla.add(random.nextInt(1_000_000_000));
				dataset.get(j).mecha.add(random.nextInt(1_000_000_000));
			}
		}

		Instant start = Instant.now();

		for (int i = 0 ; i < 50 ; i++) {
			String result = armyStrengthEasy.fight(dataset.get(i).godzilla, dataset.get(i).mecha);
		}

		Instant end = Instant.now();

		Duration d = Duration.between(start, end);

		System.out.println("It took " + d.toMillis() + " ms");
	}

	@Test
	public void fightWithMap() {
		String result = armyStrengthEasy.fight(godzillaMap, mechaMap);

		Assert.assertEquals(ArmyStrengthEasy.UNCERTAIN, result);
	}


	@Test
	public void fightMapWithGodzillaArmyShouldWork() {
		godzillaMap.put(1, 1);
		String result = armyStrengthEasy.fight(godzillaMap, mechaMap);

		Assert.assertEquals(ArmyStrengthEasy.GODZILLA, result);
	}

	@Test
	public void fightMapWithMechaGodzillaArmyShouldWork() {
		mechaMap.put(1, 1);
		String result = armyStrengthEasy.fight(godzillaMap, mechaMap);

		Assert.assertEquals(ArmyStrengthEasy.MECHA_GODZILLA, result);
	}

	@Test
	public void fightMapWithEqualsShouldFavourGodzilla() {
		godzillaMap.put(1, 1);
		mechaMap.put(1, 1);
		String result = armyStrengthEasy.fight(godzillaMap, mechaMap);

		Assert.assertEquals(ArmyStrengthEasy.GODZILLA, result);
	}

	@Test
	@Ignore("too slow")
	public void fightMapShouldWorkWithMaxDataset() {
		Random random = new Random(0);
		List<Dataset> dataset = new ArrayList<>();

		for (int j = 0 ; j < 50 ; j++) {
			Dataset e = new Dataset();
			dataset.add(e);
			for (int i = 0; i < 100_000; i++) {
				put(random, e.godzillaMap);
				put(random, e.mechaMap);
			}
		}

		Instant start = Instant.now();

		for (int i = 0 ; i < 50 ; i++) {
			String result = armyStrengthEasy.fight(dataset.get(i).godzillaMap, dataset.get(i).mechaMap);
		}

		Instant end = Instant.now();

		Duration d = Duration.between(start, end);

		System.out.println("It took " + d.toMillis() + " ms");
	}

	private void put(Random random, SortedMap<Integer, Integer> map) {
		int key = random.nextInt(1_000_000_000);
		if (!map.containsKey(key)) {
			map.put(key, 0);
		}

		map.put(key, map.get(key) + 1);
	}
	@Test
	public void fightWithList() {
		String result = armyStrengthEasy.fight(godzillaList, mechaList);

		Assert.assertEquals(ArmyStrengthEasy.UNCERTAIN, result);
	}


	@Test
	public void fightListWithGodzillaArmyShouldWork() {
		godzillaList.add(1);

		String result = armyStrengthEasy.fight(godzillaList, mechaList);

		Assert.assertEquals(ArmyStrengthEasy.GODZILLA, result);
	}

	@Test
	public void fightListWithMechaGodzillaArmyShouldWork() {
		mechaList.add(1);
		String result = armyStrengthEasy.fight(godzillaList, mechaList);

		Assert.assertEquals(ArmyStrengthEasy.MECHA_GODZILLA, result);
	}

	@Test
	public void fightListWithEqualsShouldFavourGodzilla() {
		godzillaList.add(1);
		mechaList.add(1);
		String result = armyStrengthEasy.fight(godzillaList, mechaList);

		Assert.assertEquals(ArmyStrengthEasy.GODZILLA, result);
	}

	@Test
	@Ignore("too slow")
	public void fightListShouldWorkWithMaxDataset() throws IOException {
		Random random = new Random(0);
		List<Dataset> dataset = new ArrayList<>();

		Instant before = Instant.now();

//		File f = new File("2.in");
//		FileWriter fw = new FileWriter(f);
//		fw.write("50\n");

		for (int j = 0 ; j < 50 ; j++) {
			Dataset e = new Dataset();
			dataset.add(e);
			for (int i = 0; i < 100_000; i++) {
				e.godzillaList.add(random.nextInt(1_000_000_000));
				e.mechaList.add(random.nextInt(1_000_000_000));
			}

//			fw.write("\n");
//			fw.write("100000 100000\n");
//			fw.write(e.godzillaList.stream().map(String::valueOf).collect(Collectors.joining(" ")));
//			fw.write("\n");
//			fw.write(e.mechaList.stream().map(String::valueOf).collect(Collectors.joining(" ")));
//			fw.write("\n");
		}

//		fw.close();

		Instant start = Instant.now();

		for (int i = 0 ; i < 50 ; i++) {
			Dataset e = dataset.get(i);

			Collections.sort(e.godzillaList);
			Collections.sort(e.mechaList);

			String result = armyStrengthEasy.fight(e.godzillaList, e.mechaList);
		}

		Instant end = Instant.now();

		Duration between = Duration.between(start, end);
		Duration beforeD = Duration.between(before, start);

		System.out.println("It took " + between.toMillis() + " ms, generating random took " + beforeD.toMillis() + " ms");
	}

	private static class Dataset {
		final PriorityQueue<Integer> godzilla = new PriorityQueue<>();
		final PriorityQueue<Integer> mecha = new PriorityQueue<>();
		final SortedMap<Integer, Integer> godzillaMap = new TreeMap<>();
		final SortedMap<Integer, Integer> mechaMap = new TreeMap<>();
		final List<Integer> godzillaList = new ArrayList<>();
		final List<Integer> mechaList = new ArrayList<>();
//		final SortedSet<MyInt> godzillaSet = new ConcurrentSkipListSet<>();
//		final SortedSet<MyInt> mechaSet = new ConcurrentSkipListSet<>();
		final SortedSet<MyInt> godzillaSet = new TreeSet<>();
		final SortedSet<MyInt> mechaSet = new TreeSet<>();
	}


	@Override
	protected String getDir() {
		return "armystrengtheasy";
	}
}