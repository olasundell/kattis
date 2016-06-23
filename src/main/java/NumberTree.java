import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class NumberTree {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new NumberTree().solve(in));
	}

	public String solve(Scanner in) {
		int height = in.nextInt();
		char[] path;
		if (!in.hasNext()) {
			path = new char[0];
		} else {
			path = in.next().toCharArray();
		}

		long max = (2 << height) - 1;
		long n = 0;

//		if index(parent) = N, index(left child) = 2*N+1
//				* if index(parent) = N, index(right child) = 2*N+2

//		Node tree = createTree(height);

		for (char c: path) {
			switch (c) {
				case 'L':
//					tree = tree.left;
					n = 2*n+1;
					break;
				case 'R':
//					tree = tree.right;
					n = 2*n+2;
					break;
			}
		}

		return String.valueOf(max - n);
//		return String.valueOf(tree.value);
	}

	protected Node createTree(int height) {
		Queue<Node> queue = new LinkedList<>();
		int v = (2 << height) - 1;
		Node root = new Node(v--);

		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			if (v > 0) {
				node.left = new Node(v--);
				node.right = new Node(v--);

				queue.add(node.left);
				queue.add(node.right);
			}
		}

		return root;
	}

	protected static class Node {
		Node left;
		Node right;
		final int value;


		public Node(int value) {
			this.value = value;
		}

	}
}
