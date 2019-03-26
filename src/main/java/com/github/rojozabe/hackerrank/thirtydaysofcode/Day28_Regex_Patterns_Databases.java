package hackerrank.thirtydaysofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

import utils.FileHelper;

public class Day28_Regex_Patterns_Databases {
    private static class Person {
        final String name, email;
        public Person(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    private static void printEmails(Person[] people) {
        Arrays.sort(people, (a, b) -> a.name.compareTo(b.name));

        final Pattern pattern = Pattern.compile(".+@gmail.com");
        for (Person p : people) {
            if (pattern.matcher(p.email).matches()) {
                System.out.println(p.name);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/thirtydaysofcode/Day28_Regex_Patterns_Databases.txt");
        int N = Integer.parseInt(br.readLine().trim());
        Person[] people = new Person[N];
        for (int i = 0; i < N; i++) {
            String[] firstNameEmailID = br.readLine().trim().split("\\s+");
            String firstName = firstNameEmailID[0];
            String emailID = firstNameEmailID[1];
            people[i] = new Person(firstName, emailID);
        }
        printEmails(people);
        br.close();
    }
}