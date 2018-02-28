package playground.search;

/**
 * Binary Search Tree
 */
public class BST  {

    private Node root;
    private class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public void put(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }

        put(root, value);
    }

    private void put(Node root, int value) {
        if (root == null) return;

        if (value < root.value) {
            if (root.left != null) put(root.left, value);
            else {
                root.left = new Node(value);
            }
        }
        else if (root.value < value) {
            if (root.right != null) put(root.right, value);
            else {
                root.right = new Node(value);
            }
        }
    }

    public Node search(int value) {
        if (root == null) return null;
        return search(root, value);
    }

    private Node search(Node root, int value) {

        if (root == null) return null;

        if (root.value > value) return search(root.left, value);
        if (root.value < value) return search(root.right, value);

        return root;

    }



    public static void main(String[] args) {
        BST bst = new BST();

        bst.put(104);
        bst.put(101);
        bst.put(102);
        bst.put(103);
        bst.put(105);
        bst.put(106);

        System.out.println(bst.search(104));

    }

}
