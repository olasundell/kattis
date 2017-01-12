package hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * TODO write documentation
 */
class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}

}

public class LinkedLists {

	public static Node removeDuplicates(Node head) {
		//Write your code here
		if (head == null) {
			return null;
		}

		Set<Integer> set = new HashSet<>();
		Node n = head;
		set.add(n.data);

		while (n.next != null) {
			while (n.next != null && set.contains(n.next.data)) {
				n.next = n.next.next;
			}

			if (n.next == null) {
				break;
			}

			set.add(n.next.data);
			n = n.next;

		}

		return head;
	}

	public static  Node insert(Node head,int data) {
		Node p=new Node(data);
		if(head==null)
			head=p;
		else if(head.next==null)
			head.next=p;
		else
		{
			Node start=head;
			while(start.next!=null)
				start=start.next;
			start.next=p;

		}
		return head;
	}
	public static void display(Node head) {
		System.out.println(createStr(head));
	}

	public static String createStr(Node head) {
		Node start = head;
		StringBuilder builder = new StringBuilder();

		while (start != null) {
			builder.append(start.data).append(" ");
			start = start.next;
		}

		return builder.toString();
	}

	public String solve(Scanner sc) {
		Node head=null;
		int T=sc.nextInt();
		while(T-->0){
			int ele=sc.nextInt();
			head=insert(head,ele);
		}
		head=removeDuplicates(head);
		return createStr(head);
	}

	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);

		System.out.println(new LinkedLists().solve(sc));
	}
}