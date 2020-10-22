package edu.uprm.cse.ds.list;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
    public class ArrayListIterator<E> implements Iterator<E>{
        private int currentPosition;

        public ArrayListIterator(){
            this.currentPosition = 0;
        }

        @Override
        public boolean hasNext() {
            return this.currentPosition < currentSize;
        }

        @Override
        public E next() {
            if (this.hasNext()){
                E result = (E) elements[this.currentPosition++];
                return result;

            }
            else {
                throw new NoSuchElementException();
            }
        }
    }
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
//        for (int i=0; i < this.size(); ++i){
//            if (this.elements[i].equals(e)){
//                return true;
//            }
//        }
//        return false;
        return this.firstIndex(e) >=0;

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
        return this.elements[index];// O(1)
    }

    @Override
    public E remove(int index) {
        if ((index < 0) || (index >= this.currentSize)){
            throw new IndexOutOfBoundsException("Illegal Position");
        }
        E result = this.elements[index]; // el q se borra
        for (int i=index; i < this.size() -1; ++i){  // i in range [0, currenSize-1]
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[this.size()-1] = null;
        this.currentSize--;
        return result;
    }

    @Override
    public boolean remove(E e) {
        int targetIndex = this.firstIndex(e);
        if (targetIndex < 0){
            return false;
        }
        else {
            this.remove(targetIndex);
            return true;
        }
    }

    @Override
    public int removeAll(E e) {
        int counter = 0;
        while(this.remove(e)){
            counter++;
        }
        return counter;
    }

    @Override
    public E replace(int index, E newElement) {
        // valid values [0, this.currentSize-1]
        // same as [0, this.size() -1]
        // && both case are True
        // || at least one is true

        if ((index < 0) || (index >= this.currentSize)){
            throw new IndexOutOfBoundsException("Illegal Position");
        }
        E result = this.elements[index]; // the old one
        this.elements[index] = newElement; // put the new one
        return result; // return old one
    }

    @Override
    public void clear() {
        while(!this.isEmpty()){
            // empty body
            this.remove(0) ;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] result  = new Object[this.size()];
        for (int i=0; i < this.size(); ++i){
            result[i] = this.elements[i];
        }
        return result;
    }

    @Override
    public void print(PrintStream out) {
        for (int i=0; i < this.size(); ++i){
            out.print(this.elements[i]);
            out.print(" ");
        }
        out.println();
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator<>();
    }

    public E set(int index, E newElement){
        if ((index < 0) || (index >= this.size())){
            throw new IndexOutOfBoundsException("index is out of range.");
        }
        E result = this.elements[index];
        this.elements[index] = newElement;
        return result;
    }
}
