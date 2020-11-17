package edu.uprm.cse.ds.bst;

public class BinaryTreeNodeImp<E> implements BinaryTreeNode<E> {
    private E value; // Lo que guardo el node!

    private BinaryTreeNode<E> parent; // Referencia al parent
    private BinaryTreeNode<E> leftChild; // Referencia a left child
    private BinaryTreeNode<E> rightChild; // Referencia a right child


    public BinaryTreeNodeImp(E value, BinaryTreeNode<E> parent, BinaryTreeNode<E> leftChild, BinaryTreeNode<E> rightChild) {
        this.value = value;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public BinaryTreeNode<E> getParent() {
        return this.parent;
    }

    @Override
    public BinaryTreeNode<E> getLeftChild() {
        return this.leftChild;
    }

    @Override
    public BinaryTreeNode<E> getRightChild() {
        return this.rightChild;
    }

    @Override
    public E getValue() {
        return this.value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public void setParent(BinaryTreeNode<E> parent) {
        this.parent = parent;
    }

    public void setLeftChild(BinaryTreeNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(BinaryTreeNode<E> rightChild) {
        this.rightChild = rightChild;
    }
}
