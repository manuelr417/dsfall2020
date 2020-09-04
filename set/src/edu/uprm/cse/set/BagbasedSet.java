package edu.uprm.cse.set;

import edu.uprm.cse.bag.Bag;
import edu.uprm.cse.bag.DynamicBag;

import java.io.PrintStream;

public class BagbasedSet<E> implements Set<E> {
    private Bag<E> elements;

    public BagbasedSet() {
        this.elements = new DynamicBag<E>();

    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    @Override
    public boolean isMember(E obj) {
        return this.elements.isMember(obj);
    }

    @Override
    public boolean add(E obj) {
        if (!this.isMember(obj)){
            this.elements.add(obj);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(E obj) {
        return this.elements.remove(obj);
    }

    @Override
    public void clear() {
        this.elements.clear();
    }

    @Override
    public Set<E> union(Set<E> S2) {
        Set<E> result = new BagbasedSet<E>();
        E[] temp = (E[]) this.elements.toArray();

        for (int i=0; i < this.size(); ++i){
            result.add(temp[i]);
        }

        temp = (E[]) S2.toArray();
        for (int i=0; i < S2.size(); ++i){
            result.add(temp[i]);
        }

        return result;
    }

    @Override
    public Set<E> difference(Set<E> S2) {
        Set<E> result = new BagbasedSet<E>();

        E[] temp = (E[]) this.elements.toArray();
        for (int i=0; i < this.size(); ++i){
            if (!S2.isMember(temp[i])){
                result.add(temp[i]);
            }
        }
        return result;
    }

    @Override
    public Set<E> intersection(Set<E> S2) {
        return this.difference(this.difference(S2));
    }

    @Override
    public boolean isSubset(Set<E> S2) {
        return this.difference(S2).isEmpty();
    }

    @Override
    public Object[] toArray() {
        return this.elements.toArray();
    }

    @Override
    public void print(PrintStream out) {
        Object [] temp = this.toArray();

        for (int i=0; i < this.size(); ++i){
            out.print(temp[i]);
            out.print(" ");
        }
        out.println();
    }
}
