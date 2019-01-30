package utils;

/**
 * This class provides several implementations and solutions to problems related to Trees
 * @author rzapata
 */
public class TreeHelper {

    /**
     * Check if binary tree is balanced
     * <p>
     * Balanced means any two branches from a node have at most a height difference of 1. So it uses
     * an internal checker method which validates height between left and child nodes <= 1. If you don't
     * want to use another helper method to calculate the current visited height in-place there is another
     * solutions where can be used a wrapper class used to modify height across recursive calls.
     * <p>
     * Time complexity: O(n) for recursion
     * <p>
     * Space complexity: O(h) height of the tree
     * 
     * @param root node
     * @return if binary tree is balanced
     */
    public static <T> boolean isBalanced(BinaryTree<T> root) {
        return isBalancedHelper(root) > -1;
    }

    private static <T> int isBalancedHelper(BinaryTree<T> node) {
        if(node == null)
            return 0;
        
        int leftHeight = isBalancedHelper(node.getLeft());
        if(leftHeight == -1) return -1;

        int rightHeight = isBalancedHelper(node.getRight());
        if(rightHeight == -1) return -1;

        if(Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        else
            return 1 + Math.max(leftHeight, rightHeight);
    }

    /**
	 * From geeksforgeeks: Method Correct and Efficient solution looks at each node
	 * only once. The trick is to write a utility helper function isBSTUtil(BT Node,
	 * int min, int max) that traverses down the tree keeping track of the narrowing
	 * min and max allowed values as it goes, looking at each node only once. The
	 * initial values for min and max should be INT_MIN and INT_MAX — they narrow
	 * from there.
	 * 
	 * Time complexity: O(n).
	 * 
	 * @param root.
	 * @return if tree is Binary Search Tree.
	 */
	public static boolean isBinarySearchTree(BinaryTree<Integer> root) {
		return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	// Returns true if the given tree is a BST and its values are >= min and <= max.
    private static boolean isBinarySearchTree(BinaryTree<Integer> node, int min, int max) {
        if (node == null)
            return true;

        if (node.getValue() < min || node.getValue() > max)
            return false;

        return isBinarySearchTree(node.getLeft(), min, node.getValue() - 1) && isBinarySearchTree(node.getRight(), node.getValue() + 1, max);
    }
}