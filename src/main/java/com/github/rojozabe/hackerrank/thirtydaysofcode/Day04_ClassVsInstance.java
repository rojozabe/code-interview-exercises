package hackerrank.thirtydaysofcode;

import java.io.BufferedReader;
import java.io.IOException;

import utils.FileHelper;

public class Day04_ClassVsInstance {
    private static class Person {
        private int age;

        public Person(int age) {
            if (age < 0) {
                System.out.println("Age is not valid, setting age to 0.");
                this.age = 0;
            } else {
                this.age = age;
            }
        }

        public void amIOld() {
            String s = "";
            if (age < 13) {
                s = "You are young.";
            } else if (age >= 13 && age < 18) { 
                s = "You are a teenager.";
            }else {
                s = "You are old.";
            }
            System.out.println(s);
        }
  
        public void yearPasses() {
            age++;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/thirtydaysofcode/Day4_ClassVsInstance.txt");
        int T = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < T; i++) {
            int age = Integer.parseInt(br.readLine().trim());
            Person p = new Person(age);
            p.amIOld();
			for (int j = 0; j < 3; j++) {
				p.yearPasses();
            }
            p.amIOld();
        }
        br.close();
    }
}