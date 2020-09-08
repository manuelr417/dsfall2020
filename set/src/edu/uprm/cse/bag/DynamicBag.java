package edu.uprm.cse.bag;

public class DynamicBag<E> implements Bag<E> {

    private static final int INITAL_SIZE = 10; // constant to give intial size

    // space for storage element
    private Object elements[];

    // current size
    private int currentSize;

    public DynamicBag(int initialSize){
        if (initialSize < 1){
            throw new IllegalArgumentException("Initial size must be at least 1.");
        }
        this.currentSize = 0;
        this.elements = new Object[initialSize];
    }

    public DynamicBag(){
        this(INITAL_SIZE);
    }

    @Override
    public int size() {
        return this.currentSize;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;

//            // Not cool
//        if (this.size == 0){
//            return true;
//        }
//        else {
//            return false;
//        }
    }

    @Override
    public boolean isMember(Object obj) {
        return this.count(obj) > 0;
    }

    @Override
    public void clear() {
        for (int i =0; i < this.size(); ++i){
            this.elements[i] = null;
        }
        this.currentSize = 0;
    }

    @Override
    public void add(Object obj) {
        if (obj == null){
            throw new IllegalArgumentException("Argument to add cannot be null");
        }

        if (this.size() == this.elements.length){
            this.reAllocate();

        }
        this.elements[this.currentSize++] = obj;
        // not cool
        //this.currentSize = this.currentSize + 1;
        // not cool 2
        //this.currentSize++;
    }

    private void reAllocate(){
        int newSize  = this.size() * 2;
        Object newElements[] = new Object[newSize];

        // Copy to new array
        for (int i=0; i < this.size(); ++i){
            newElements[i] = this.elements[i];
        }
        this.elements = newElements;
    }

    @Override
    public int count(Object obj) {
        int result = 0;

        for (int i=0; i < this.size(); ++i){
            if (this.elements[i].equals(obj)){
                ++result; // result++ is ok too - just want to increment, don't care about value
            }
        }
        return result;
    }

    @Override
    public boolean remove(Object obj) {
        for (int i=0; i < this.size(); ++i){
            if (this.elements[i].equals(obj)){
                // found it!
                this.elements[i] = this.elements[this.currentSize-1];
                this.elements[this.currentSize-1] = null;
                --this.currentSize; //this.currentSize-- is ok too -  just want to increment, don't care about value
                return true;
            }
        }
        return false;
    }

    @Override
    public int removeAll(Object obj) {
        int result = 0;

        while(this.remove(obj)){
            ++result;
        }
        return result;
    }
    public Object[] toArray(){
        Object[] result;
        // return new independent array
        result = new Object[this.size()];
        for (int i=0; i < this.size(); ++i){
            result[i] = this.elements[i];
        }
        return result;
    }


}
