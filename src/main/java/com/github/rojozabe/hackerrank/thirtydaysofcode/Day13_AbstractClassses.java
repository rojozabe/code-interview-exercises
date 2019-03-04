package hackerrank.thirtydaysofcode;

import java.io.BufferedReader;
import java.io.IOException;

import utils.FileHelper;

public class Day13_AbstractClassses {
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/thirtydaysofcode/Day13_AbstractClassses.txt");
        String title = br.readLine().trim();
        String author = br.readLine().trim();
        int price = Integer.parseInt(br.readLine().trim());
        Book book = new MyBook(title, author, price);
        book.display();
        br.close();
    }
}

abstract class Book {
    String title;
    String author;
    
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    abstract void display();
}

class MyBook extends Book {
    private final int price;

    MyBook(String title, String author, int price) {
        super(title, author);
        this.price = price;
    }

    @Override
    void display() {
        System.out.printf("Title: %s\nAuthor: %s\nPrice: %s\n", title, author, price);
    }
}