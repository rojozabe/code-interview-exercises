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
     * @param root
     * @return
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
}