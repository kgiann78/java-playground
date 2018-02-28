package playground.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TriesContacts {

    static Node root = new Node();

    private static class Node {
        Map<Character, Node> children = new HashMap<>();
        int size = 0;

        private Node getNode(char c) {
            if (children.containsKey(c))
                return children.get(c);
            else
                return null;
        }

        private void setNode(char c, Node node) {
            children.put(c, node);
        }

        private void add(String s, int index) {
            size++;
            if (index == s.length()) return;
            char c = s.charAt(index);
            Node child = getNode(c);
            if (child == null) {
                child = new Node();
                setNode(c, child);
            }
            child.add(s, index + 1);
        }

        public void add(String s) {
            add(s, 0);
        }

        public int findCount(String s) {
            return findCount(s, 0);
        }

        public int findCount(String s, int index) {
            if (index == s.length())
                return this.size;

            Node child = this.getNode(s.charAt(index));

            if (child == null)
                return 0;

            return child.findCount(s, index + 1);
        }

    }

    private static void manageContacts(String op, String contact) {
        if (isAddOperation(op))
            root.add(contact);
        else
            System.out.println(root.findCount(contact));
    }

    private static boolean isAddOperation(String op) {
        return op.equals("add");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of lines that will follow:");
        int n = in.nextInt();
        for (int a0 = 0; a0 < n; a0++) {
            System.out.print("Enter command and contact (i.e. add Hack, find Hack etc): ");
            String op = in.next();
            String contact = in.next();

            manageContacts(op, contact);
        }
        in.close();
    }
}
