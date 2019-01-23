package hackerrank.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

import utils.FileHelper;

/**
 * Sorting: Comparator
 * https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
 * <p>
 * Basically implement Quick Sorting to write a comparator that sorts them in
 * order of decreasing score. If 2 or more players have the same score, sort
 * those players alphabetically ascending by name.
 * <p>
 * Quick Sort 101 explanation:
 * <p>
 * https://youtu.be/SLauY6PpjW4
 */
public class QuickSortingComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/sorting/QuickSortingComparator.txt");
        int n = Integer.parseInt(br.readLine().trim());
        Player[] player = new Player[n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split("\\s+");
            player[i] = new Player(s[0], Integer.parseInt(s[1]));
        }
        Arrays.sort(player, new Checker());
        System.out.println(Arrays.toString(player));
        br.close();
    }

    private static class Checker implements Comparator<Player> {

        @Override
        public int compare(Player a, Player b) {
            int scoreCompare = b.getScore().compareTo(a.score);
            
            if(scoreCompare == 0)
                return a.getName().compareTo(b.getName());
            else
                return scoreCompare;
        }

    }

    private static class Player {
        private final String name;
        private final int score;

        public Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public Integer getScore() {
            return score;
        }

        @Override
        public String toString() {
            return name + " " + score;

        }
    }
}