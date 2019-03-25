package hackerrank.thirtydaysofcode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day22_BST {
    private static class Node {
        Node left = null, right = null;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int data) {
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

    public static int getHeight(Node root) {
        if (root == null) {
            return -1;
        }

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("./src/test/java/com/github/rojozabe/hackerrank/thirtydaysofcode/Day22_BST.txt"));
        int T = sc.nextInt();
        Node root = null;
        while(T --> 0){
            int data = sc.nextInt();
            root=insert(root, data);
        }
        int height = getHeight(root);
        System.out.println(height);
        sc.close();
    }
}