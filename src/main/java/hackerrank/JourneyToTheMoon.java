package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * TODO write documentation
 */
public class JourneyToTheMoon {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new JourneyToTheMoon().solve(in));
	}

	public String solve(Scanner in) {
		List<Set<Integer>> astros = new ArrayList<>();

		int numberOfAstronauts = in.nextInt();
		int lines = in.nextInt();

		for (int i = 0 ; i < lines ; i++) {
			int a = in.nextInt();
			int b = in.nextInt();

			Set<Integer> toMerge = null;
			Set<Integer> toAddTo = null;

			for (Set<Integer> set: astros) {
				if (set.contains(b)) {
					toMerge = set;
				}
				if (set.contains(a)) {
					toAddTo = set;
				}
			}

			if (toAddTo == null) {
				// we didn't find the first astronaut anywhere
				if (toMerge != null) {
					// but we -did- find the second astronaut.
					toMerge.add(a);
				} else {
					astros.add(new HashSet<>(Arrays.asList(a, b)));
				}
			} else {
				if (toMerge != null && toAddTo != toMerge) {
					// we found the referred astronaut in another set, which means we have loose connections to sweep up
					astros.remove(toMerge);
					toAddTo.addAll(toMerge);
				} else {
					// the original astronaut was found, but the referred astronaut is new to us
					toAddTo.add(b);
				}
			}
		}
		padAstros(astros, numberOfAstronauts);
		System.err.println(astros);

		assertAstros(astros);

		return String.valueOf(summate(astros));
	}

	private void padAstros(List<Set<Integer>> astros, int numberOfAstronauts) {
		int sum = astros.stream().mapToInt(Set::size).sum();
		Set<Integer> uniques = new HashSet<>();
		astros.forEach(uniques::addAll);
		int nextAvailableId = 0;

		// there might be singleton astronauts out there, add placeholders for them
		for (int i = sum ; i < numberOfAstronauts ; i++) {
			for (; nextAvailableId < numberOfAstronauts ; nextAvailableId++) {
				if (!uniques.contains(nextAvailableId)) {
					astros.add(Collections.singleton(nextAvailableId));
					nextAvailableId++;
					break;
				}
			}
		}
		int sumAfter = astros.stream().mapToInt(Set::size).sum();
	}

	private void assertAstros(List<Set<Integer>> astros) {
		Set<Integer> uniques = new HashSet<>();
		astros.stream().flatMap(Collection::stream).forEach(astro -> {
			if (uniques.contains(astro)) {
				System.err.println(astro + " is a duplicate!");
			} else {
				uniques.add(astro);
			}
		});
		long sum = astros.stream().mapToInt(Set::size).sum();
		if (uniques.size() != sum) {
			System.err.println("Astro size " + sum + ", uniques size " + uniques.size());
			assert false;
		}
	}

	private long summate(List<Set<Integer>> astros) {
		if (astros.size() <= 1) {
			return 0;
		}

		long product = astros.get(0).size() * astros.get(1).size();
		long sum = astros.get(0).size() + astros.get(1).size();

		for (int i = 2 ; i < astros.size() ; i++) {
			Set<Integer> set = astros.get(i);
			product += sum * set.size();
			sum += set.size();
		}

		return product;
	}
}
