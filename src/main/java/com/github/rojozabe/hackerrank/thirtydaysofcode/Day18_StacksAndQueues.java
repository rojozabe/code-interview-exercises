package hackerrank.thirtydaysofcode;

//import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

//import utils.FileHelper;

public class Day18_StacksAndQueues {
    private Deque<Character> queue = new ArrayDeque<>();
    private Deque<Character> stack = new ArrayDeque<>();
    
    private void pushCharacter(Character c) {
        stack.push(c);
    }

    private void enqueueCharacter(Character c) {
        queue.offer(c);
    }

    private char popCharacter() {
        return stack.pop();
    }

    private char dequeueCharacter() {
        return queue.poll();
    }
    
    public static void main(String[] args) throws IOException {
        //BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/thirtydaysofcode/Day17_MoreExceptions.txt");
        String s = "racecar";//br.readLine().trim();

        Day18_StacksAndQueues p = new Day18_StacksAndQueues();

        for (char c : s.toCharArray()) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        boolean isPalindrome = true;
        for (int i = 0; i < s.length()/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;                
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + s + ", is " + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );

        //br.close();
    }
}