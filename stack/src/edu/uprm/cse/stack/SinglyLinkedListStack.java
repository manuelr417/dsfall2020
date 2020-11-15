package edu.uprm.cse.stack;

import java.io.PrintStream;

public class SinglyLinkedListStack<E> implements Stack<E> {

    private static class Node<E> {
        private E element; // reference to value stored in the Node
        private Node<E> next;  // reference to next Node in the chain

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public Node(){
            this.element = null;
            this.next = null;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            // this is a  Node
            ///this.next = next - next of this is the parameter
            this.next = next;
        }
    }

    private Node<E> header;
    private int currentSize;

    public SinglyLinkedListStack(){
        this.header = new Node<>();
        this.currentSize = 0;
    }
    @Override
    public int size() {
        return this.currentSize;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public E top() { // O(1)
        return this.isEmpty() ? null : this.header.getNext().getElement();
    }

    @Override
    public E pop() { // O(1)
        if (this.isEmpty()){
            return null;
        }
        else {
            Node<E> temp = this.header.getNext(); // O(1)
            E result = temp.getElement(); // O(1)
            this.header.setNext(temp.getNext()); // O(1)
            temp.setNext(null); // O(1)
            temp.setElement(null); // O(1)
            this.currentSize--; // O(1)
            return result; // O(1)
        }
    }

    @Override
    public void push(E e) {
        Node<E> newNode = new Node<>(); // O(1)
        newNode.setElement(e); //O(1)
        newNode.setNext(this.header.getNext()); // O(1)
        this.header.setNext(newNode); // O(1)
        this.currentSize++; // O(1)
    }

    @Override
    public void clear() {
        while (this.pop() != null);
    }

    @Override
    public void print(PrintStream P) {
        for (Node<E> temp= this.header.getNext(); temp != null; temp = temp.getNext()){
            P.println(temp.getElement());
        }
    }
}
