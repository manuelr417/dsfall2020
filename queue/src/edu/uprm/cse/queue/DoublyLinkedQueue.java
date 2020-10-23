package edu.uprm.cse.queue;

import java.io.PrintStream;

public class DoublyLinkedQueue<E> implements Queue<E> {

    private static class Node<E> {
        private E element; // reference to value stored in the Node
        private Node<E> next;  // reference to next Node in the chain
        private Node<E> prev; // reference to previous Node in the chain

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;

        }

        public Node(){
            this.element = null;
            this.next = null;
            this.prev = null;

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
    private Node<E> tail;
    private int currentSize;

    public DoublyLinkedQueue() {
        this.currentSize = 0;
        this.header = new Node<>();
        this.tail = new Node<>();

        this.header.setNext(this.tail); // step 1
        this.tail.setPrev(this.header); // step 2

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
    public E front() {
        return (this.isEmpty() ? null : this.header.getNext().getElement());
    }

    @Override
    public void enqueue(E e) {
        Node<E> newNode = new Node<>(); // Step 1
        newNode.setElement(e); // Step 2
        newNode.setNext(this.tail); // Step 3
        newNode.setPrev(this.tail.getPrev()); //Step 4
        this.tail.getPrev().setNext(newNode); // Step 5
        this.tail.setPrev(newNode); // Step 6
        this.currentSize++; // Step 7
    }

    @Override
    public E dequeue() {
        Node<E> temp = null;
        E result = null;

        if (this.isEmpty()){
            return null;
        }
        else {
            temp = header.getNext();
            result = temp.getElement();
            temp.getNext().setPrev(this.header); // Step 1
            this.header.setNext(temp.getNext()); // Step 2
            temp.setElement(null); //Step 3
            temp.setNext(null); // Step 4
            temp.setPrev(null); // Step 5
            this.currentSize--; // Step 6
            return result;
        }
    }

    @Override
    public void clear() {

        while(this.dequeue() != null);

    }

    @Override
    public void print(PrintStream P) {
        Node<E> temp = this.header.getNext();
        while (temp != this.tail){
            P.println(temp.getElement());
            temp = temp.getNext();
        }
    }
}
