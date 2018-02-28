package playground;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    Node root = new Node();

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] keywords = {"a", "ab", "abc"};
//        String[] keywords = {"a", "bc", "ab", "aab", "aac", "bd"};
        trie.buildTree(keywords);
        String text = "ab";

        System.out.println(trie.search(text));
    }

    void buildTree(String[] array) {
        for (String word : array) {
            root.insert(word);
        }

        System.out.println(root);
    }

    boolean search(String text) {
        return root.search(text);
    }

    class Node {
        boolean isLeaf = false;
        Map<String, Node> children = new HashMap<>();

        void insert(String key) {
            Node crawl = this;

            for (String index : key.split("")) {
                if (!crawl.children.containsKey(index)) {
                    crawl.children.put(index, new Node());
                }
                crawl = crawl.children.get(index);
                crawl.isLeaf = false;
            }
            crawl.isLeaf = true;
        }

        boolean search(String key) {
            Node crawl = this;

            for (String index : key.split("")) {
                if (crawl.children.containsKey(index)) {
                    crawl = crawl.children.get(index);
                } else {
                    return false;
                }
            }

            return crawl.isLeaf;
        }

        @Override
        public String toString() {
            String print = "Node{" +
                    "isLeaf=" + isLeaf +
                    ", children=";
            StringBuilder stringBuilder = new StringBuilder(print);

            for (String key : children.keySet()) {
                if (children.get(key) != null) {
                    stringBuilder.append(key).append(" : ").append(children.get(key).toString()).append(", ");
                }
            }

            stringBuilder.replace(0, stringBuilder.length(), stringBuilder.toString().replaceAll(", $", "")).append("}");
            return stringBuilder.toString();
        }
    }
}
