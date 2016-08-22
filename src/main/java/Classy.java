import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Classy {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Classy().solve(in));
	}

	public String solve(Scanner in) {
		List<String> result = new ArrayList<>();

		int numOfTests = in.nextInt();

		for (int i = 0 ; i < numOfTests ; i++) {
			int currentLines = in.nextInt();
			in.nextLine();
			PriorityQueue<Person> persons = new PriorityQueue<>();

			for (int j = 0; j < currentLines; j++) {
				String name = in.next().replaceAll(":", "");
				String classes = in.next();

				Person e = new Person(name, classes.split("-"));
				persons.add(e);
				in.nextLine();
			}

			while (!persons.isEmpty()) {
				result.add(persons.poll().getName());
			}
//			result.addAll(persons.stream().map(Person::getName).collect(Collectors.toList()));
			result.add("==============================");
		}
		return result.stream().collect(Collectors.joining("\n"));
	}

	static class Person implements Comparable<Person> {
		final String name;
		final List<SocialClass> socialClasses = new ArrayList<>();

		public Person(String name, String[] classes) {
			this.name = name;
			for (int i = classes.length - 1; i >= 0; i--) {
				socialClasses.add(SocialClass.valueOf(classes[i].toUpperCase()));
			}
		}

		public String getName() {
			return name;
		}

		@Override
		public int compareTo(Person o) {
			int sign = 0;
			for (int i = 0 ; i < Math.max(o.socialClasses.size(), this.socialClasses.size()) ; i++) {
				SocialClass oClass;
				SocialClass thisClass;

				if (o.socialClasses.size() <= i + 1) {
					oClass = SocialClass.MIDDLE;
				} else {
					oClass = o.socialClasses.get(i);
				}

				if (this.socialClasses.size() <= i + 1) {
					thisClass = SocialClass.MIDDLE;
				} else {
					thisClass = this.socialClasses.get(i);
				}

				if (oClass != thisClass) {
					sign = thisClass.value - oClass.value;
					break;
				}
			}

			if (sign == 0) {
				return this.name.compareTo(o.name);
			}

			return sign;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Person person = (Person) o;

			return name != null ? name.equals(person.name) : person.name == null;

		}

		@Override
		public int hashCode() {
			return name != null ? name.hashCode() : 0;
		}

		@Override
		public String toString() {
			return "Person{" +
					"name='" + name + '\'' +
					", socialClasses=" + socialClasses +
					'}';
		}
	}

	enum SocialClass {
		UPPER(1),
		MIDDLE(2),
		LOWER(3);

		int value;

		SocialClass(int value) {
			this.value = value;
		}
	}
}
