package playground.microsoft;

import java.util.Stack;

public class LowestCommonAncestor {

    public static void main(String[] args) {

        //build the tree;
        Node leaf6 = new Node(6);
        Node leaf5 = new Node(5);
        Node leaf4 = new Node(4);
        Node node3 = new Node(3);
        Node leaf2 = new Node(2);
        Node root = new Node(1);

        node3.setParent(root);
        node3.setLeftChild(leaf4);
        node3.setRightChild(leaf6);

        leaf6.setParent(node3);
        leaf6.setLeftChild(leaf5);

        leaf5.setParent(leaf6);
        leaf4.setParent(node3);
        leaf2.setParent(root);

        root.setParent(null);
        root.setLeftChild(node3);
        root.setRightChild(leaf2);

        LCA(root, leaf2, leaf6);
    }

    public static void LCA(Node root, Node nodeA, Node nodeB) {

        Node tmp1 = nodeA.getParent();
        Node tmp2 = nodeB.getParent();
        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();

        stackA.push(nodeA.getValue());
        stackB.push(nodeB.getValue());

        while (tmp1 != root) {
            stackA.push(tmp1.getValue());
            tmp1 = tmp1.getParent();
        }

        while (tmp2 != root) {
            stackB.push(tmp2.getValue());
            tmp2 = tmp2.getParent();
        }

        int lca = root.getValue();
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            if (stackA.peek() == stackB.peek())
                lca = stackA.peek();
            stackA.pop();
            stackB.pop();
        }

        System.out.println(lca);
    }
}
