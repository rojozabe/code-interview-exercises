package interviewcake;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import utils.BinaryTree;
import utils.TreeHelper;

public class Cake227_BalancedBinaryTree {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Cake227_BalancedBinaryTree.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }

    @Test
    public void fullTreeTest() {
        final BinaryTree<Integer> root = new BinaryTree<Integer>(5);
        final BinaryTree<Integer> a = root.setLeft(8);
        final BinaryTree<Integer> b = root.setRight(6);
        a.setLeft(1);
        a.setRight(2);
        b.setLeft(3);
        b.setRight(4);
        final boolean result = TreeHelper.isBalanced(root);
        assertTrue(result);
    }

    @Test
    public void bothLeavesAtTheSameDepthTest() {
        final BinaryTree<Integer> root = new BinaryTree<Integer>(3);
        root.setLeft(4).setLeft(1);
        root.setRight(2).setRight(9);
        final boolean result = TreeHelper.isBalanced(root);
        assertTrue(result);
    }

    @Test
    public void leafHeightsDifferByOneTest() {
        final BinaryTree<Integer> root = new BinaryTree<Integer>(6);
        root.setLeft(1);
        root.setRight(0).setRight(7);
        final boolean result = TreeHelper.isBalanced(root);
        assertTrue(result);
    }

    @Test
    public void leafHeightsDifferByTwoTest() {
        final BinaryTree<Integer> root = new BinaryTree<Integer>(6);
        root.setLeft(1);
        root.setRight(0).setRight(7).setRight(8);
        final boolean result = TreeHelper.isBalanced(root);
        assertFalse(result);
    }

    @Test
    public void bothSubTreesSuperbalancedTest() {
        final BinaryTree<Integer> root = new BinaryTree<Integer>(1);
        root.setLeft(5);
        final BinaryTree<Integer> b = root.setRight(9);
        b.setLeft(8).setLeft(7);
        b.setRight(5);
        final boolean result = TreeHelper.isBalanced(root);
        assertFalse(result);
    }

    @Test
    public void onlyOneNodeTest() {
        final BinaryTree<Integer> root = new BinaryTree<Integer>(1);
        final boolean result = TreeHelper.isBalanced(root);
        assertTrue(result);
    }

    /**
     * I changed this test to assertFalse, according to interview cake a super balanced
     * binary tree is a tree which different between left and right node heights can be 2.
     * But according to GeeksforGeeks and cracking the interview code is no more than 1.
     */
    @Test
    public void treeIsLinkedListTest() {
        final BinaryTree<Integer> root = new BinaryTree<Integer>(1);
        root.setRight(2).setRight(3).setRight(4);
        final boolean result = TreeHelper.isBalanced(root);
        assertFalse(result);
    }
}