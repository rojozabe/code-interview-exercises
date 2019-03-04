package hackerrank.thirtydaysofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import utils.FileHelper;

public class Day12_Inheritance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/thirtydaysofcode/Day12_Inheritance.txt");
        String[] s = br.readLine().trim().split("\\s+");
        String firstName = s[0];
        String lastName = s[1];
        int id = Integer.parseInt(s[2]);
        int[] testScores = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Student student = new Student(firstName, lastName, id, testScores);
        student.printPerson();
        System.out.println("Grade: " + student.calculate());
        br.close();
    }
}

class Person {
	protected String firstName;
	protected String lastName;
	protected int idNumber;
	
	// Constructor
	Person(String firstName, String lastName, int identification){
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}
	
    // Print person data
    public void printPerson(){
        System.out.println("Name: " + lastName + ", " + firstName + "\nID: " + idNumber); 
   }
}

class Student extends Person{
	private int[] testScores;

    Student(String firstName, String lastName, int identification, int[] testScores) {
        super(firstName, lastName, identification);
        this.testScores = testScores;
    }

    public String calculate() {
        int average = (int) Arrays.stream(testScores).average().getAsDouble();

        if (average <= 100 && average >= 90) {
            return "O";
        } else if (average < 90 && average >= 80) {
            return "E";
        } else if (average < 80 && average >= 70) {
            return "A";
        } else if (average < 70 && average >= 55) {
            return "P";
        } else if (average < 55 && average >= 40) {
            return "D";
        } else {
            return "T"; 
        }
    }
}