package hackerrank.thirtydaysofcode;

import java.io.BufferedReader;
import java.io.IOException;

import utils.FileHelper;

public class Day2_Operators {
    private static void solve(double meal_cost, int tip_percent, int tax_percent) {
        int totalExpense = (int) Math.round(meal_cost + meal_cost * tip_percent / 100 + meal_cost * tax_percent / 100);
        System.out.println(totalExpense);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/thirtydaysofcode/Day2_Operators.txt");
        double meal_cost = Double.parseDouble(br.readLine().trim());
        int tip_percent = Integer.parseInt(br.readLine().trim());
        int tax_percent = Integer.parseInt(br.readLine().trim());
        solve(meal_cost, tip_percent, tax_percent);
        br.close();
    }
}