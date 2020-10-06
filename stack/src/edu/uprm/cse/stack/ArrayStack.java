package edu.uprm.cse.stack;

import java.io.PrintStream;

public class ArrayStack<E> implements Stack<E> {

    private E[] elements;
    private int top;
    private static final int DEFAULT_SIZE = 10;


    public ArrayStack(int initialSize){
        if (initialSize < 1) {
            throw new IllegalArgumentException("initialSize must be at least 1");
        }
        this.elements = (E[]) new Object[initialSize];
        this.top = 0;
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public E top() {
//        if (this.isEmpty()){
//            return null;
//        }
//        else{
//            return this.elements[this.top -1];
//        }
        return this.isEmpty() ? null : this.elements[this.top-1]; /// O(1)
    }

    @Override
    public E pop() { // O(1)
        if (this.isEmpty()){
            return null;
        }
        else {
            E result = this.top();
            this.elements[this.top -1] = null;
            this.top--;
            return result;
        }
    }

    @Override
    public void push(E e) { //O(n) n= this.size()
        if (this.size() == this.elements.length){ // (Comparison is O(1)
            this.reAllocate(); // O(n), n = this.size()
        }
        this.elements[this.top++] = e; // O(1)

    }

    private void reAllocate() { // O(N), N = this.size()
        E[] newElements = (E[]) new Object[2*this.size()];
        for (int i=0; i < this.size(); ++i){
            newElements[i] = this.elements[i];
        }
        this.elements = newElements;
    }

    @Override
    public void clear() { // O(n), n = this.size()
        while (this.pop() != null);
    }

    @Override
    public void print(PrintStream P) {
        for (int i= this.size() - 1; i >= 0; --i){
            P.println(this.elements[i]);
        }
    }
}
