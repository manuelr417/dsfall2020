package edu.uprm.cse.ds.list;

import java.io.PrintStream;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    private static final int DEFAULT_SIZE = 10;
    private E[] elements;
    private int currentSize;

    public ArrayList(int initSize) {
        if (initSize < 1){
            throw new IllegalArgumentException("Initial size must be at least 1.");
        }
        this.currentSize = 0;
        this.elements = (E[]) new Object[initSize];
    }
    public ArrayList(){
        this(DEFAULT_SIZE);
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
    public boolean isMember(E e) {
        return false;
    }

    @Override
    public int firstIndex(E e) {
        for (int i =0; i < this.size(); ++i){
            if (this.elements[i].equals(e)){
               return i;
            }
        }
        return -1;
        // == compares references or scalar values
    }

    @Override
    public int lastIndex(E e) {
        for (int i = this.currentSize -1; i >= 0; --i){
            if (this.elements[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void add(E e) {
        // add at the end
        if (this.size() == this.elements.length){
            this.reAllocate();
        }
        this.elements[this.currentSize++] = e;

    }

    private void reAllocate() {
        E[] newElements = (E[]) new Object[2*this.size()];

        for (int i=0; i < this.size(); ++i){
            newElements[i] = this.elements[i];
        }
        this.elements = newElements;
    }

    @Override
    public void add(E e, int index) {
        if ((index < 0 ) || (index > this.currentSize)){
            throw new IndexOutOfBoundsException("Illegal Position");
        }
        // special case: index == this.currentSize
        if (index == this.currentSize){
            this.add(e);
        }
        else {
            if (this.size() == this.elements.length){
                this.reAllocate();
            }
            for (int i = this.currentSize; i > index; --i){
                this.elements[i] = this.elements[i-1];
            }
            this.elements[index] = e;
            this.currentSize++;
        }
    }

    @Override
    public E get(int index) {
        if ((index < 0) || (index >= this.currentSize)){
            throw new IndexOutOfBoundsException("Illegal Position");
        }
        return this.elements[index];
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean remove(E e) {
        return false;
    }

    @Override
    public int removeAll(E e) {
        return 0;
    }

    @Override
    public E replace(int index, E newElement) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void print(PrintStream out) {

    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
