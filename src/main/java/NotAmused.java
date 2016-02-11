import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class NotAmused {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new NotAmused().solve(in));
    }

    public String solve(Scanner in) {
        List<Day> days = new ArrayList<>();
        Day currentDay = null;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            System.err.println(line);

            String[] split = line.split(" ");
            switch (split[0]) {
                case "OPEN":
                    currentDay = new Day(days.size() + 1);
                    break;
                case "CLOSE":
                    days.add(currentDay);
                    break;
                case "ENTER":
                    currentDay.enter(split[1], Integer.parseInt(split[2]));
                    break;
                case "EXIT":
                    currentDay.exit(split[1], Integer.parseInt(split[2]));
                    break;
                default:
                    throw new IllegalStateException("Line not syntactically correct: " + line);
            }
        }
        return days.stream().map(Day::toString).collect(Collectors.joining("\n\n"));
    }

    private void sum() {

    }

    protected static class Day {
        final int num;
        final Map<String, Person> persons = new HashMap<>();

        public Day(int num) {
            this.num = num;
        }

        public void addPerson(Person person) {
            persons.put(person.name, person);
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();

            builder.append(String.format("Day %d\n", num));
            builder.append(persons.values().stream().map(Person::toString).sorted().collect(Collectors.joining("\n")));

            return builder.toString();
        }

        public void enter(String name, int time) {
            if (!persons.containsKey(name)) {
                persons.put(name, new Person(name));
            }

            persons.get(name).enter(time);
        }

        public void exit(String name, int time) {
            persons.get(name).exit(time);
        }
    }

    protected static class Person {
        final List<Visit> visits = new ArrayList<>();
        final String name;

        public Person(String name) {
            this.name = name;
        }

        public void addVisit(Visit visit) {
            this.visits.add(visit);
        }

        public double sum() {
            return visits.stream().mapToDouble(Visit::sum).sum();
        }

        public String toString() {
            return String.format("%s $%.2f", name, this.sum());
        }

        public void enter(int time) {
            Visit e = new Visit();
            e.enter = time;
            visits.add(e);
        }

        public void exit(int time) {
            visits.get(visits.size() - 1).exit = time;
        }
    }

    protected static class Visit {
        int enter;
        int exit;

        public double sum() {
            return (exit - enter) / 10.0;
        }
    }
}
