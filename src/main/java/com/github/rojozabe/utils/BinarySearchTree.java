package utils;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {
    private BinarySearchTree<T> parent;

    public BinarySearchTree(T value) {
        super(value);
        this.parent = null;
    }

    public BinarySearchTree(T value, BinarySearchTree<T> parent) {
        super(value);
        this.parent = parent;
    }

    public BinarySearchTree<T> getParent() {
        return parent;
    }
    
    public void setParent(BinarySearchTree<T> parent) {
        this.parent = parent;
    }

    @Override
    public void setLeft(BinaryTree<T> left) {
        if(!(left instanceof BinarySearchTree<?>))
            throw new IllegalArgumentException("left child must also be a BinarySearchTree");
        super.setLeft(left);
    }

    @Override
    public BinarySearchTree<T> setLeft(T value) {
        setLeft((BinarySearchTree<T>) super.setLeft(value));
        return this;
    }

    @Override
    public void setRight(BinaryTree<T> right) {
        if(!(right instanceof BinarySearchTree<?>))
            throw new IllegalArgumentException("right child must also be a BinarySearchTree");
        super.setRight(right);
    }

    public BinarySearchTree<T> setRight(T value) {
        setRight((BinarySearchTree<T>) super.setRight(value));
        return this;
    }

    @Override
    public BinarySearchTree<T> getLeft() {
        return (BinarySearchTree<T>) super.getLeft();
    }
    
    @Override
    public BinarySearchTree<T> getRight() {
        return (BinarySearchTree<T>) super.getRight();
    }
}