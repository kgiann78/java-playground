package playground.lists;

import java.util.Hashtable;

public class RemoveDups {

    class Node {
        int data;
        Node next;

        @Override
        public String toString() {
            return "" +
                    " " + data +
                    " " +
                    "-> " + next +
                    "";
        }
    }

    public void removeDups(Node n) {

    }

    public Node createList() {
        Node root = new Node();
        root.data = 0;
        for (int i=1; i <= 5; i++) {
            Node n = new Node();
            n.data = i;
            Node m = root;
            while (m.next != null) m = m.next;
            m.next = n;
        }
        return root;
    }

    public void insertInto(Node root, int pos, int data) {
        Node n = root;
        int counter = 0;
        while (n.next != null && counter++ < pos) n = n.next;

        if (counter < pos) {
            System.out.println("Reached out of limits");
        } else {
            Node m = new Node();
            m.data = data;
            m.next = n.next;
            n.next = m;
        }
    }

    void removeDuplicatesWHash(Node root) {
        Hashtable<Integer, Boolean> hashtable = new Hashtable<>();
        Node current = root;
        Node previous = null;

        while (current != null) {
            if (hashtable.containsKey(current.data)) {
                previous.next = current.next;

            } else {
                hashtable.put(current.data, true);
                previous = current;
            }
            current = current.next;
        }
    }

    public void removeDuplicates(Node root) {
        if (root == null) return;
        Node previous = root;
        Node current = root.next;

        while (current != null) {
            Node running = root;
            while (running != current) {
                if (running.data == current.data) {
                    Node tmp = current.next;
                    current = tmp;
                    previous.next = tmp;
                    break;
                }
                running = running.next;
            }
            if (running == current) {
                previous = current;
                current = current.next;
            }

        }
    }

    public static void main(String[] args) {
        RemoveDups removeDups = new RemoveDups();
        Node root = removeDups.createList();
        System.out.println(root);
        removeDups.insertInto(root, 4, 3);
        System.out.println(root);
        removeDups.insertInto(root, 2, 3);
        System.out.println(root);
        removeDups.removeDuplicatesWHash(root);
        System.out.println(root);
    }
}
