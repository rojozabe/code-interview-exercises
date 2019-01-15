/**
 * 
 */
package utils;

/**
 * @author rzapata
 *
 */
public class MathHelper {

	/**
	 * GCD based on the Euclidean algorithm: https://en.wikipedia.org/wiki/Euclidean_algorithm
	 * Time complexity: O(log(max(a,b)))
	 * @param a
	 * @param b
	 * @return gcd between a and b
	 */
	public static int gcd(int a, int b) {
		while(b > 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		
		return a;
	}
	
	/**
	 * Least common multiple is a little trickier, but probably the best approach is reduction by the GCD, which can be similarly iterated.
	 * https://en.wikipedia.org/wiki/Least_common_multiple#Reduction_by_the_greatest_common_divisor
	 * @param a
	 * @param b
	 * @return lcm between a and b
	 */
	public static int lcm(int a, int b) {
		return a * (b / gcd(a, b));
	}
}
