package edu.uprm.cse.ds.map;

import edu.uprm.cse.ds.list.List;
import edu.uprm.cse.ds.list.SinglyLinkedList;

public class SinglyLinkedMap<K,V> implements Map<K, V> {


    public static class MapEntry<K,V> {
        private K key;
        private V value;

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int currentSize;

    private List<MapEntry<K,V>> elements;

    public SinglyLinkedMap() {

        this.elements = new SinglyLinkedList<>();
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
    public V get(K key) {
        if (this.isEmpty()){
            return null;
        }
        else {
            int position = findPosition(key);
            if (position < 0){
                return null;
            }
            else {
                MapEntry<K, V> entry = this.elements.get(position);
                return entry.getValue();
            }
        }
    }

    private int findPosition(K key) {
        int result = 0;
        for (MapEntry<K,V> e: this.elements){
            if (e.getKey().equals(key)){
                return result;
            }
            else {
                result++;
            }
        }
        return -1;
    }

    @Override
    public V put(K key, V value) {
        // erase old key
        V result = this.remove(key);

        MapEntry<K,V> newEntry = new MapEntry<>(key, value);
        this.elements.add(newEntry, 0);
        return result;
    }

    @Override
    public V remove(K key) {
        int target = findPosition(key);
        if (target < 0){
            return null;
        }
        else {
//            V result = this.elements.get(target).getValue();
//            this.elements.remove(target);
//            return result;

            return this.elements.remove(target).getValue();
        }
    }

    @Override
    public boolean contains(K key) {
        return this.get(key) != null;
    }

    @Override
    public void clear() {
        this.elements.clear();


    }

    @Override
    public List<K> getKeys() {
        List<K> result = new SinglyLinkedList<>();

        for (MapEntry<K,V> e : this.elements){
            result.add(e.getKey(), 0);
        }
        return result;
    }

    @Override
    public List<V> getValues() {
        List<V> result = new SinglyLinkedList<>();

        for (MapEntry<K,V> e : this.elements){
            result.add(e.getValue(), 0);
        }
        return result;
    }
}
