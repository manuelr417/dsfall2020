package edu.uprm.cse.ds.list;

import java.io.PrintStream;

public interface List<E> extends Iterable<E>{
    public int size();
    public boolean isEmpty();
    public boolean isMember(E e);
    public int firstIndex(E e);
    public int lastIndex(E e);
    public void add(E e); // at the end
    public void add(E e, int index);
    public E get(int index);
    public E remove(int index);
    public boolean remove(E e);
    public int removeAll(E e);
    public E replace(int index, E newElement);
    public void clear();
    public Object[] toArray();
    public void print(PrintStream out);

}
