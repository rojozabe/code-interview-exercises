package hackerrank.thirtydaysofcode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Day23_BST_LevelTraversal {
    private static class Node {
        Node left = null, right = null;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    private static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    private static void levelOrder(Node root) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(root);

        while (deque.peek() != null) {
            Node node = deque.poll();
            System.out.printf("%d ", node.data);

            if (node.left != null) deque.add(node.left);
            if (node.right != null) deque.add(node.right);
        }
        System.out.println();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("./src/test/java/com/github/rojozabe/hackerrank/thirtydaysofcode/Day23_BST_LevelTraversal.txt"));
        int T = sc.nextInt();
        Node root = null;
        while (T --> 0) {
            int data = sc.nextInt();
            root = insert(root,data);
        }
        levelOrder(root);
        sc.close();
    }
}