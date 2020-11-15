package edu.uprm.cse.queue;

import java.io.PrintStream;

public class CircularQueue<E> implements Queue<E> {

    private E elements[];

    private int front;

    private int tail;

    private int currentSize;

    private static final int DEFAULT_SIZE = 10;

    public CircularQueue(int initSize) {
        if (initSize < 1){
            throw new IllegalArgumentException("initSize must be at least 1.");
        }

        this.elements = (E[]) new Object[initSize];
        this.front = 0;
        this.tail = 0;
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
    public E front() {
        return (this.isEmpty() ? null : this.elements[this.front]);
    }

    @Override
    public void enqueue(E e) {
        if (this.size() == this.elements.length){
            throw new IllegalStateException("Queue is full");
        }
        else {
            this.elements[this.tail] = e;
            this.tail = (this.tail + 1) % this.elements.length; // N = this.elements.length
            this.currentSize++;
        }
    }

    @Override
    public E dequeue() {
        if (this.isEmpty()){
            return null;
        }
        else {
            //E result = this.elements[this.front];
            E result = this.front();
            this.elements[this.front] = null;
            this.front = (this.front + 1) % this.elements.length;// N = this.elements.length
            this.currentSize--;
            return result;
        }
    }

    @Override
    public void clear() {
        while (this.dequeue() !=null);
    }

    @Override
    public void print(PrintStream P) {
        int i = this.front;
        while (i != this.tail){
            P.println(this.elements[i]);
            i = (i + 1) % this.elements.length;
        }

    }
}
