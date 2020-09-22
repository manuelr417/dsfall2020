package edu.uprm.cse.set;


import java.io.PrintStream;

// Set<Integer> S = new ArraySet<Integer>();
public class ArraySet<E> implements Set<E> {

    private E[] elements;

    private int currentSize;

    private static final int DEFAULT_SIZE = 10;

    public ArraySet(int initialSize){
        if (initialSize < 1){
            throw new IllegalArgumentException("Set size must be at least 1.");
        }
        this.currentSize = 0;
        this.elements = (E[]) new Object[initialSize];
    }
    public ArraySet(){
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
    public boolean isMember(E obj) {
        for (int i=0; i < this.size(); ++i){
            if (this.elements[i].equals(obj)){
                // found
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(E obj) {
        if (this.isMember(obj)){
            return false;
        }
        else {
            // add it

            // check space
            if (this.size() == this.elements.length){
                // re-allocate
                this.reAllocate();
            }
            this.elements[this.currentSize++] = obj;
            return true;
        }

    }

    private void reAllocate() {
        int newSize = this.size() * 2;
        E[] newElements = (E[]) new Object[newSize];

        // copia pelo a pelo
        // tambien puede usar arrayCopy de System
        // para ser vago y no hacer el loop
        for (int i=0; i < this.size(); ++i){
            newElements[i] = this.elements[i];
        }

        // does not work
        //newElements = this.elements;

        this.elements = newElements;
        return;
    }

    @Override
    public boolean remove(E obj) {
        for (int i=0; i < this.size(); ++i){
            if (this.elements[i].equals(obj)){
                // found it!!
                this.elements[i] = this.elements[this.currentSize-1]; // replace with last one
                this.elements[this.currentSize-1] = null; // remove extra copy
                this.currentSize--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i=0; i < this.size(); ++i){
            this.elements[i] = null;
        }
        this.currentSize = 0;
        // this.elements = null;  // Danger - null pointer
    }


    @Override
    public Set<E> union(Set<E> S2) {
        // this -> S1
        // S2 -> S2
        // result -> S3


        // this is what I meant to be S1
        // result holds
        Set<E> result = new ArraySet<E>(this.size() + S2.size());
        for (int i=0; i < this.size(); ++i){
            result.add(this.elements[i]);
        }
        //E[] temp2 = ((ArraySet<E>)S2).elements;

        E[] temp = (E[]) S2.toArray();
        if (temp !=null) {
            for (int i = 0; i < S2.size(); ++i) {
                result.add(temp[i]);
                //result.add(((ArraySet<E>)S2).elements[i]);
                ///result.add((E) S2.toArray()[i]);

            }
        }
        return result; // S3
    }

    @Override
    public Set<E> difference(Set<E> S2) {
        Set<E> result = new ArraySet<E>();

        for (int i =0; i < this.size(); ++i){
            if (!S2.isMember(this.elements[i])){
                result.add(this.elements[i]);
            }
        }
        return result;
    }

    @Override
    public Set<E> intersection(Set<E> S2) {
//        Set<E> result = new ArraySet<E>();
//        for (int i =0; i < this.size(); ++i){
//            if (S2.isMember(this.elements[i])){
//                result.add(this.elements[i]);
//            }
//        }
//        return result; //Fo! too 4010/4015

        // in one line??

        return this.difference(this.difference(S2));
    }

    @Override
    public boolean isSubset(Set<E> S2) {

        // S1 = this
        // S2 = S2
        // If S1 is subset of S2
//        for (int i=0; i < this.size(); ++i){
//            if (!S2.isMember(this.elements[i])){
//                return false;
//            }
//        }
//        return true; // Not cool

        return this.difference(S2).isEmpty();
        //return this.difference(S2).size() == 0;
    }

    @Override
    public Object[] toArray() {
        if (this.size() == 0){
            return null;
        }
        else {
            Object[] result = new Object[this.size()];
            for (int i = 0; i < this.size(); ++i){
                result[i] = this.elements[i];
            }
            return result;
        }
    }

    @Override
    public void print(PrintStream out) {
        //for (E e: this.elements){
        for (int i=0 ; i < this.size(); ++i){
            out.print(this.elements[i]);
            out.print(" ");
        }
        out.println();
    }
}
