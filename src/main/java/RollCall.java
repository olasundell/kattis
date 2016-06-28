import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class RollCall {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new RollCall().solve(in));
	}

	public String solve(Scanner in) {
		SortedSet<Person> people = new TreeSet<>();
		Map<String, Boolean> firstNames = new HashMap<>();

		while (in.hasNextLine()) {
			Person p = new Person(in.next(), in.next());

			if (firstNames.containsKey(p.firstName)) {
				firstNames.put(p.firstName, true);
			} else {
				firstNames.put(p.firstName, false);
			}

			people.add(p);

			in.nextLine();
		}

		return people.stream().map(p -> printName(p, firstNames)).collect(Collectors.joining("\n"));
	}

	protected String printName(Person person, Map<String, Boolean> firstNames) {
		if (firstNames.get(person.firstName).booleanValue()) {
			return person.firstName + " " + person.lastName;
		} else{
			return person.firstName;
		}
	}

	protected static class Person implements Comparable<Person> {
		final String firstName;
		final String lastName;

		public Person(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		@Override
		public int compareTo(Person o) {
			if (lastName.equals(o.lastName)) {
				return firstName.compareTo(o.firstName);
			} else {
				return lastName.compareTo(o.lastName);
			}
		}
	}
}
