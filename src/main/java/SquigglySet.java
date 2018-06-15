import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class SquigglySet {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new SquigglySet().solve(in));
	}

	public String solve(Scanner in) {
		List<Card> cards = new ArrayList<>();

		Map<Integer, Set<Integer>> byValue = new HashMap<>();
		Map<Shape, Set<Integer>> byShape = new HashMap<>();
		Map<Fill, Set<Integer>> byFill = new HashMap<>();
		Map<Colour, Set<Integer>> byColour = new HashMap<>();

		for (int i = 0 ; i < 12 ; i++) {
			final Card e = readCard(in.next());
			byValue.computeIfAbsent(e.value, (k) -> new HashSet<>()).add(i);
			byShape.computeIfAbsent(e.shape, (k) -> new HashSet<>()).add(i);
			byFill.computeIfAbsent(e.fill, (k) -> new HashSet<>()).add(i);
			byColour.computeIfAbsent(e.colour, (k) -> new HashSet<>()).add(i);

			cards.add(e);
		}

//		byValue.values().stream().filter(s -> s.size() >= 3).

//		if (set.isEmpty()) {
//			return "no set";
//		} else {
//			return set.stream().map(CardSet::toString).collect(Collectors.joining("\n"));
//		}
		return "";
	}

	private Card readCard(String s) {
		char[] arr = s.toCharArray();

		return new Card(
				Integer.valueOf(s.substring(0, 1)),
				Shape.find(arr[1]),
				Fill.find(arr[2]),
				Colour.find(arr[3])
		);
	}

	class CardSet implements Comparable<CardSet> {
		final Integer first;
		final Integer second;
		final Integer third;

		public CardSet(int first, int second, int third) {
			this.first = first;
			this.second = second;
			this.third = third;
		}

		@Override
		public int compareTo(@NotNull CardSet o) {
			int fC = this.first.compareTo(o.first);

			if (fC != 0) {
				return fC;
			} else {
				int sC = this.second.compareTo(o.second);
				if (sC != 0) {
					return sC;
				} else {
					return this.third.compareTo(o.third);
				}
			}
		}

		@Override
		public String toString() {
			return first + " " + second + " " + third;
		}
	}

	class Card {
		final Integer value;
		final Shape shape;
		final Fill fill;
		final Colour colour;

		public Card(Integer value, Shape shape, Fill fill, Colour colour) {
			this.value = value;
			this.shape = shape;
			this.fill = fill;
			this.colour = colour;
		}
	}

	enum Shape {
		DIAMONDS,
		SQUIGGLES,
		OVALS;

		static Shape find(Character c) {
			switch (c) {
				case 'D':
					return DIAMONDS;
				case 'S':
					return SQUIGGLES;
				case 'O':
					return OVALS;
			}
			throw new IllegalArgumentException(c + " is wrong");
		}
	}

	enum Fill {
		SOLID,
		STRIPED,
		OPEN;

		static Fill find(Character c) {
			switch (c) {
				case 'S':
					return SOLID;
				case 'T':
					return STRIPED;
				case 'O':
					return OPEN;
			}
			throw new IllegalArgumentException(c + " is wrong");
		}
	}

	enum Colour {
		RED,
		GREEN,
		PURPLE;

		static Colour find(Character c) {
			switch (c) {
				case 'R':
					return RED;
				case 'G':
					return GREEN;
				case 'P':
					return PURPLE;
			}
			throw new IllegalArgumentException(c + " is wrong");
		}
	}
}
