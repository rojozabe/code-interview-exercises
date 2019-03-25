package hackerrank.thirtydaysofcode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day24_MoreLinkedLists {
    private static class Node {
        int data;
        Node next = null;

        Node(int d) {
            data = d;
        }
    }

    private static Node insert(Node head, int data) {
        Node p = new Node(data);
        if (head == null)
            head = p;
        else if (head.next == null)
            head.next = p;
        else {
            Node start = head;
            while (start.next != null)
                start = start.next;
            start.next = p;
        }
        return head;
    }

    private static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    private static Node removeDuplicates(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        removeDuplicates(head.next);
        if (head.data == head.next.data) {
            head.next = head.next.next;
        }

        return head;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("./src/test/java/com/github/rojozabe/hackerrank/thirtydaysofcode/Day24_MoreLinkedLists.txt"));
        Node head=null;
        int T = sc.nextInt();
        while (T --> 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        head = removeDuplicates(head);
        display(head);
        sc.close();
    }
}