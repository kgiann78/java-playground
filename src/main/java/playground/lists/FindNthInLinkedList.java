package playground.lists;

/*
Given a single linked list, write a function to find the Nth-to-last element of the list.

eg.

list: 1 -> 2 -> 3 -> 4 -> 5

input: 1 -> output: 4
input: 2 -> output: 3
input: 3 -> output: 2

*/

public class FindNthInLinkedList {



	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		int i = Integer.parseInt(args[0]);

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		// System.out.println(list);

		System.out.println(list.find(i));
	}
}

class SingleLinkedList {
	Node head = null;

	void add(int i) {
		Node node = new Node(i, null);
		if (head == null) head = node;
		else {
			Node pos = head;
			while (pos.next != null) {
				pos = pos.next;
			}
			pos.next = node;
		}
	}

	Node find(int i) {
		if (i < 0) return null;

		Node current = head;
		Node follower = head;
		int count = 0;
		int currentCounter = 0;

		while (current != null && current.next != null) {
			current = current.next;
			currentCounter++;
			if (count < i) count++;
			else if (count == i) {
				follower = follower.next;
			}
		}
		if (currentCounter < i) follower = null;
		return follower;
	}

	@Override
	public String toString() {
		if (head == null) return null;

		String output = "[" + String.valueOf(head) + ", ";

		Node node = head;
		while (node.next != null) {
			node = node.next;
			output += node.toString() + ", ";
		}

		return output.replaceAll(", $", "") + "]";
	}
}

class Node {
	int value;
	Node next;

	Node() {
		this.value = 0;
		this.next = null;
	}

	Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}

	@Override
	public String toString() {
		return String.valueOf(this.value);
	}
}