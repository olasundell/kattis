import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Ptice {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Ptice().solve(in));
	}

	public String solve(Scanner in) {
		Integer adrian = 0;
		Integer bruno = 0;
		Integer goran = 0;

		PriorityQueue<Integer> answers = new PriorityQueue<>();

		answers.add(adrian);
		answers.add(bruno);
		answers.add(goran);

		return "";
	}
}
