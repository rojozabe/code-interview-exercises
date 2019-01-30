package interviewcake;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import utils.BinaryTree;
import utils.TreeHelper;

/**
 * We do a depth-first walk through the tree, testing each node for validity as we go.
 * If a node appears in the left subtree of an ancestor, it must be less than that ancestor.
 * If a node appears in the right subtree of an ancestor, it must be greater than that ancestor.
 * 
 * Instead of keeping track of every ancestor to check these inequalities, 
 * we just check the largest number it must be greater than (its lowerBound) 
 * and the smallest number it must be less than (its upperBound)
 */
public class Cake228_BinarySearchTreeChecker {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Cake228_BinarySearchTreeChecker.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }

    @Test
    public void validFullTreeTest() {
        final BinaryTree<Integer> root = new BinaryTree<Integer>(50);
        final BinaryTree<Integer> a = root.setLeft(30);
        a.setLeft(10);
        a.setRight(40);
        final BinaryTree<Integer> b = root.setRight(70);
        b.setLeft(60);
        b.setRight(80);
        final boolean result = TreeHelper.isBinarySearchTree(root);
        assertTrue(result);
    }

    @Test
    public void bothSubtreesValidTest() {
        final BinaryTree<Integer> root = new BinaryTree<Integer>(50);
        final BinaryTree<Integer> a = root.setLeft(30);
        a.setLeft(20);
        a.setRight(60);
        final BinaryTree<Integer> b = root.setRight(80);
        b.setLeft(70);
        b.setRight(90);
        final boolean result = TreeHelper.isBinarySearchTree(root);
        assertFalse(result);
    }

    @Test
    public void descendingLinkedListTest() {
        final BinaryTree<Integer> root = new BinaryTree<Integer>(50);
        root.setLeft(40).setLeft(30).setLeft(20).setLeft(10);
        final boolean result = TreeHelper.isBinarySearchTree(root);
        assertTrue(result);
    }

    @Test
    public void outOfOrderLinkedListTest() {
        final BinaryTree<Integer> root = new BinaryTree<Integer>(50);
        root.setRight(70).setRight(60).setRight(80);
        final boolean result = TreeHelper.isBinarySearchTree(root);
        assertFalse(result);
    }

    @Test
    public void oneNodeTreeTest() {
        final BinaryTree<Integer> root = new BinaryTree<Integer>(50);
        final boolean result = TreeHelper.isBinarySearchTree(root);
        assertTrue(result);
    }
}