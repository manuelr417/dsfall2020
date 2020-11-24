package edu.uprm.cse.ds.bst;

public interface BinaryTreeNode<E> extends TreeNode<E> {
    public BinaryTreeNode<E> getParent();

    public BinaryTreeNode<E> getLeftChild();

    public BinaryTreeNode<E> getRightChild();

    public void setParent(BinaryTreeNode<E> parent);

    public void setLeftChild(BinaryTreeNode<E> leftChild);

    public void setRightChild(BinaryTreeNode<E> rightChild);
}
