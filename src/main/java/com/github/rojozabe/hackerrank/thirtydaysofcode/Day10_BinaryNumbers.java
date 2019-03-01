package hackerrank.thirtydaysofcode;

import java.io.BufferedReader;
import java.io.IOException;

import utils.FileHelper;

public class Day10_BinaryNumbers {
    private static int getMaxConsecutiveOnes(int n) {
        String binaryInt = Integer.toBinaryString(n);
        int counterOnes = 0, maxOnes = 0;
        for (int i = 0; i < binaryInt.length(); i++) {
            if (binaryInt.charAt(i) == '1') {
                counterOnes++;
            } else {
                counterOnes = 0;
            }
            maxOnes = Math.max(maxOnes, counterOnes);
        }
        return maxOnes;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/thirtydaysofcode/Day10_BinaryNumbers.txt");
        Integer n = Integer.parseInt(br.readLine().trim());
        System.out.println(getMaxConsecutiveOnes(n));
        br.close();
    }
}