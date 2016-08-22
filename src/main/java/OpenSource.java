import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class OpenSource {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new OpenSource().solve(in));
	}

	public String solve(Scanner in) {
		Map<String, Project> projects = new HashMap<>();
		Map<String, User> users = new HashMap<>();

		Project currentProject = null;

		List<String> results = new ArrayList<>();

		while (in.hasNextLine()) {
			String line = in.nextLine();
			if ("0".equals(line)) {
				break;
			} else if ("1".equals(line)) {
				results.add(summarise(users, projects));
				users.clear();
				projects.clear();
			} else if (line.toUpperCase().equals(line)) {
				// project
				currentProject = new Project(line);
				projects.put(line, currentProject);
			} else {
				// user
				if (!users.containsKey(line)) {
					users.put(line, new User(line));
				}

				User user = users.get(line);

				user.projects.add(currentProject);
				projects.get(currentProject.name).users.add(user);
			}
		}
		return results.stream().collect(Collectors.joining("\n"));
	}

	private String summarise(Map<String, User> users, Map<String, Project> projects) {
		// iterate over users and remove all where number of projects > 1, cascade to projects as well
		for (User u: users.values()) {
			if (u.projects.size() > 1) {
				u.projects.forEach(p -> p.users.remove(u));
			}
		}

		return projects.values()
				.stream()
				.sorted((p1, p2) -> {
					if (p1.users.size() == p2.users.size()) {
						return p1.name.compareTo(p2.name);
					} else {
						return p2.users.size() - p1.users.size();
					}
				})
				.map(p -> String.format("%s %d", p.name, p.users.size()))
				.collect(Collectors.joining("\n"));
	}

	class User {
		final String name;
		Set<Project> projects = new HashSet<>();

		User(String name) {
			this.name = name;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}

			User user = (User) o;

			return name.equals(user.name);

		}

		@Override
		public int hashCode() {
			return name.hashCode();
		}

		@Override
		public String toString() {
			return "User{" +
					"name='" + name + '\'' +
					", projects=" + projects +
					'}';
		}
	}

	class Project {
		final String name;
		Set<User> users = new HashSet<>();

		Project(String name) {
			this.name = name;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}

			Project project = (Project) o;

			return name.equals(project.name);

		}

		@Override
		public int hashCode() {
			return name.hashCode();
		}
	}
}
