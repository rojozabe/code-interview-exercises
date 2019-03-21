package hackerrank.thirtydaysofcode;

import java.io.BufferedReader;
import java.io.IOException;

import utils.FileHelper;

public class Day19_Interfaces {
    private interface AdvancedArithmetic {
        int divisorSum(int n);
    }
    
    private static class Calculator implements AdvancedArithmetic {
        public int divisorSum(int n) {
            int sum = 0;

            for (int i = 1; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    sum += i;
                    if (n / i != i) {
                        sum += n / i;
                    }
                }
            }
    
            return sum;
        }
    }

    public static void main(String[] args) throws IOException {
        //BufferedReader br = FileHelper.readFile(System.in);
        int n = 6;//Integer.parseInt(br.readLine().trim());        
        //br.close();
        
        AdvancedArithmetic myCalculator = new Calculator(); 
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
        System.out.println(sum);
    }
}