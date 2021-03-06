package hackerrank.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import utils.FileHelper;
import utils.MathHelper;

/**
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation
 * <p>
 * Given an array a of n integers and a number, d , perform d left rotations on the array.
 * <p>
 * Return the updated array to be printed as a single line of space-separated integers
 * 
 * @author rzapata
 */
public class ArrayRotation {

	public static void main(String[] args) throws IOException {
		BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/arrays/ArrayRotation.txt");
		String[] params = br.readLine().trim().split("\\s+");
		int n = Integer.parseInt(params[0]);
		int d = Integer.parseInt(params[1]);
		int[] a = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		br.close();
		
		rotateLeft(a, n, d);		
		System.out.println(Arrays.toString(a));
	}
	
	/**
	 * Rotate array d times to the left.
	 * <p>
	 * Topics to study:
	 * 1. Euclidean algorithm to find GCD: https://en.wikipedia.org/wiki/Euclidean_algorithm
	 * 2. LCM derived from GCD: https://stackoverflow.com/questions/4201860/how-to-find-gcd-lcm-on-a-set-of-numbers
	 * 3. A Juggling Algorithm: https://www.geeksforgeeks.org/array-rotation
	 * 4. Small explanation about Juggling algo: https://stackoverflow.com/questions/23321216/rotating-an-array-using-juggling-algorithm
	 * 5. Youtube explanation: https://youtu.be/viaha1SnpT4
	 * <p>
	 * Time complexity: O(n)
	 * <p>
	 * Space complexity: O(1)
	 * 
	 * @param a array of int
	 * @param n size of the array
	 * @param d number of rotations
	 * @return array rotated d times to the left
	 */
	private static int[] rotateLeft(int[] a, int n, int d) {
		for (int i = 0; i < MathHelper.gcd(n, d); i++) {
			int first = a[i];
			int j = i;
			
			while(true) {
				int k = j + d;
				if(k >= n) k -= n;				
				if(k == i) break;				
				a[j] = a[k];
			    j = k;				
			}
			a[j] = first;
		}
		
		return a;
	}

	/**
	 * Rotate array d times to the right.
	 * <p>
	 * Same juggling algorith used here, the difference
	 * rotating to the right is we go from the last element <code>n - 1 - i</code> to the first, 
	 * jumping <code>j - d</code> steps.
	 * <p>
	 * Time complexity: O(n)
	 * <p>
	 * Space complexity: O(1)
	 * 
	 * @param a array of int
	 * @param n size of the array
	 * @param d number of rotations
	 * @return array rotated d times to the right
	 */
	@SuppressWarnings("unused")
	private static int[] rotateRight(int[] a, int n, int d) {
		for (int i = 0; i < MathHelper.gcd(n, d); i++) {
			int last = a[n - 1 - i];
			int j = n - 1 - i;

			while(true) {
				int k = j - d;
				if(k < 0) k += n;
				if(k == n - 1 - i) break;
				a[j] = a[k];
				j = k;
			}

			a[j] = last;
		}

		return a;
	}
	
}
