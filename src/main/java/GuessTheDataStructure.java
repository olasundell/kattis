import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class GuessTheDataStructure {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new GuessTheDataStructure().solve(in));
	}

	public String solve(Scanner in) {
		Deque<Integer> stack = new ArrayDeque<>();
		Deque<Integer> queue = new ArrayDeque<>();
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
		Set<Type> types = new HashSet<>();
		List<String> result = new ArrayList<>();

		while (in.hasNextLine()) {
			int n = in.nextInt();
			in.nextLine();

			stack.clear();
			queue.clear();
			priorityQueue.clear();

			types.addAll(Arrays.asList(Type.values()));

			for (int i = 0 ; i < n ; i++) {
				int command = in.nextInt();
				int value = in.nextInt();
				in.nextLine();

				if (command == 1) {
					stack.addFirst(value);
					queue.addFirst(value);
					priorityQueue.add(value);
				} else {
					if (stack.isEmpty() || stack.pop() != value) {
						types.remove(Type.STACK);
					}

					if (queue.isEmpty() || queue.pollLast() != value) {
						types.remove(Type.QUEUE);
					}

					if (priorityQueue.isEmpty() || priorityQueue.poll() != value) {
						types.remove(Type.PRIOQ);
					}
				}
			}

			result.add(determine(types));
		}

		return result.stream().collect(Collectors.joining("\n"));
	}

	private String determine(Set<Type> types) {
		if (types.size() > 1) {
			return "not sure";
		} else if (types.isEmpty()) {
			return "impossible";
		} else {
			return types.iterator().next().typeName;
		}
	}

	private enum Type {
		STACK("stack"),
		QUEUE("queue"),
		PRIOQ("priority queue");

		String typeName;

		Type(String s) {
			typeName = s;
		}
	}
}
