package edu.uprm.cse.ds.bst;

import edu.uprm.cse.ds.list.List;
import edu.uprm.cse.ds.map.Map;

import java.util.Comparator;

public class BinarySearchTree<K,V> implements Map<K,V> {
    public static class MapEntry<K,V> implements KeyValuePair<K,V>{
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
    private BinaryTreeNode<MapEntry<K,V>> root;
    private Comparator<K> keyComparator;

    public BinarySearchTree(Comparator<K> keyComparator) {
        this.keyComparator = keyComparator;
        this.root = null;
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
    public V get(K key) {
        return this.getAux(key, this.root);

    }

    private V getAux(K key, BinaryTreeNode<MapEntry<K,V>> N) {
        if (N == null){
            return null;
        }
        else {
            int comparison = this.keyComparator.compare(key, N.getValue().getKey());
            if (comparison == 0 ){ // are equal
                return N.getValue().getValue();
            }
            else if (comparison < 0){ //key < Node.key
                return this.getAux(key, N.getLeftChild());
            }
            else {//key >= Node.key
                return this.getAux(key, N.getRightChild());
            }
        }
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public List<K> getKeys() {
        return null;
    }

    @Override
    public List<V> getValues() {
        return null;
    }
}
