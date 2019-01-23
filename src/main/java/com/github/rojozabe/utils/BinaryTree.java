package utils;

public class BinaryTree<T> {
    private T value;
    private BinaryTree<T> left, right;

    public BinaryTree(T value) {
        this.value = value;
    }

    public BinaryTree(T value, BinaryTree<T> left, BinaryTree<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
    
    public T getValue() {
        return value;
    }
    
    public void setValue(T value) {
        this.value = value;
    }
    
    public BinaryTree<T> getLeft() {
        return this.left;
    }
    
    public void setLeft(BinaryTree<T> left) {
        this.left = left;
    }

    public BinaryTree<T> setLeft(T left) {
        this.left = new BinaryTree<T>(left);
        return this.left;
    }
    
    public BinaryTree<T> getRight() {
        return this.right;
    }
    
    public void setRight(BinaryTree<T> right) {
        this.right = right;
    }

    public BinaryTree<T> setRight(T right) {
        this.right = new BinaryTree<T>(right);
        return this.right;
    }

}