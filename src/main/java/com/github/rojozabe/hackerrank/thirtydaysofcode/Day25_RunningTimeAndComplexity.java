package hackerrank.thirtydaysofcode;

import java.io.BufferedReader;
import java.io.IOException;

import utils.FileHelper;

public class Day25_RunningTimeAndComplexity {
    private static boolean isPrime(int n) {
        if (n == 1) 
            return false;
        else if (n == 2) 
            return true;
        else if (n % 2 == 0)
            return false;
        
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/thirtydaysofcode/Day25_RunningTimeAndComplexity.txt");
        int T = Integer.parseInt(br.readLine().trim());
        while(T --> 0) {
            int n = Integer.parseInt(br.readLine().trim());
            System.out.println(isPrime(n) ? "Prime": "Not prime");
        }
        br.close();
    }
}