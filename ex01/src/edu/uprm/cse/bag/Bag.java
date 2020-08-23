package edu.uprm.cse.bag;

public interface Bag {

    public int size();

    public boolean isEmpty();

    public boolean isMember(Object obj);

    public void clear();

    public void add(Object obj);

    public int count(Object obj);

    public boolean remove(Object obj);

    public int removeAll(Object obj);

    public Object[] toArray();
}
