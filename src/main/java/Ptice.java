import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Ptice {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Ptice().solve(in));
	}

	public String solve(Scanner in) {
		Person adrian = new Person("Adrian", "ABC");
		Person bruno = new Person("Bruno", "BABC");
		Person goran = new Person("Goran", "CCAABB");

		// we'll need to sort this one later
		List<Person> person = new ArrayList<>(Arrays.asList(adrian, bruno, goran));

		in.nextLine();

		String input = in.nextLine();


		char[] chars = input.toCharArray();
		for (AtomicInteger i = new AtomicInteger(0); i.get() < chars.length ; i.incrementAndGet()) {
			person.forEach(p -> p.check(chars[i.get()], i.get()));
		}

		person.sort((p1, p2) -> {
			if (p1.correct == p2.correct) {
				return p1.name.compareTo(p2.name);
			} else {
				return p2.correct - p1.correct;
			}
		});

		return person.get(0).correct + "\n" + person.stream()
				.filter(p -> person.get(0).correct == p.correct)
				.map(p -> p.name)
				.collect(Collectors.joining("\n"));
	}

	public static class Person {
		final String name;
		final char[] seq;
		int correct = 0;

		public Person(String name, String seq) {
			this.name = name;
			this.seq = seq.toCharArray();
		}

		void check(char c, int pos) {
			if (seq[pos % seq.length] == c) {
				correct++;
			}
		}
	}
}
