package edu.uprm.cse.ds.hastable;

import edu.uprm.cse.ds.list.List;
import edu.uprm.cse.ds.list.SinglyLinkedList;
import edu.uprm.cse.ds.map.Map;

public class HashtableSC<K,V> implements Map<K,V> {

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
    private Object[] buckets;
    private int currentSize;
    private static final int DEFAULT_SIZE = 13;

    public HashtableSC(int numBucket) {
        if (numBucket < 1 ){
            throw new IllegalArgumentException("Number of buckets must be at least 1.");
        }
        this.currentSize = 0;
        this.buckets = new Object[numBucket];
        for (int i =0 ; i < this.buckets.length; ++i){
            this.buckets[i] = new SinglyLinkedList<MapEntry<K,V>>();
        }
    }

    public HashtableSC(){
        this(DEFAULT_SIZE);
    }

    private int hashFunction(K key){
        return key.hashCode() % this.buckets.length;
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
    public V get(K key) {
        int bucketNumber = this.hashFunction(key);
        List<MapEntry<K,V>> bucket = (List<MapEntry<K, V>>) this.buckets[bucketNumber];
        for (MapEntry<K,V> e : bucket){
            if (e.getKey().equals(key)){
                return e.getValue();

            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        V result = this.remove(key);

        int bucketNumber = this.hashFunction(key);
        List<MapEntry<K,V>> bucket = (List<MapEntry<K,V>>) this.buckets[bucketNumber];
        bucket.add(new MapEntry<>(key, value), 0);
        this.currentSize++;
        return result;
    }

    @Override
    public V remove(K key) {
        int bucketNumber = this.hashFunction(key);
        V result = null;
        List<MapEntry<K,V>> bucket = (List<MapEntry<K,V>>) this.buckets[bucketNumber];
        for (int i=0; i < bucket.size(); ++i){
            if (bucket.get(i).getKey().equals(key)){
                result = bucket.remove(i).getValue();
                this.currentSize--;
                return result;
            }
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return this.get(key) != null;
    }

    @Override
    public void clear() {
        List<MapEntry<K,V>> bucket = null;
        for (Object b : this.buckets){
            bucket = (List<MapEntry<K,V>>) b;
            bucket.clear();
        }
        this.currentSize = 0;
    }

    @Override
    public List<K> getKeys() {
        List<K> result  = new SinglyLinkedList<>();
        List<MapEntry<K,V>> bucket = null;
        for (Object b : this.buckets){
            bucket = (List<MapEntry<K,V>>) b;
            for (MapEntry<K,V> m: bucket){
                result.add(m.getKey());
            }
        }
        return result;
    }

    @Override
    public List<V> getValues() {
        List<V> result  = new SinglyLinkedList<>();
        List<MapEntry<K,V>> bucket = null;
        for (Object b : this.buckets){
            bucket = (List<MapEntry<K,V>>) b;
            for (MapEntry<K,V> m: bucket){
                result.add(m.getValue());
            }
        }
        return result;
    }
}
