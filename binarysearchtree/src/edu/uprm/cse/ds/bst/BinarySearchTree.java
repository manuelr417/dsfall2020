package edu.uprm.cse.ds.bst;

import edu.uprm.cse.ds.list.List;
import edu.uprm.cse.ds.list.SinglyLinkedList;
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
            return null; // base 1
        }
        else {
            int comparison = this.keyComparator.compare(key, N.getValue().getKey());
            if (comparison == 0 ){ // are equal
                return N.getValue().getValue(); // base case 2
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
        if (this.size() ==0){
            MapEntry<K,V>  M = new MapEntry<>(key, value);
            this.root = new BinaryTreeNodeImp<>(M, null,null, null);
            this.currentSize++;
            return null;
        }
        else {
            return this.putAux(key, value, this.root);
        }
    }

    private V putAux(K key, V value, BinaryTreeNode<MapEntry<K,V>> N) {
        int comparison = this.keyComparator.compare(key, N.getValue().getKey());
        if (comparison < 0 ){
            // voy pa' la izq
            if (N.getLeftChild() == null){
                // insert new node, base case 1
                MapEntry<K,V>  M = new MapEntry<>(key, value);
                BinaryTreeNodeImp<MapEntry<K,V>> newNode =
                        new BinaryTreeNodeImp<>(M, N, null,null);
                N.setLeftChild(newNode);
                this.currentSize++;
                return null;
            }
            else {
                return this.putAux(key, value, N.getLeftChild()); // recursion on the left
            }
        }
        else {
            // voy pa' la der
            if (N.getRightChild() == null){
                // insert new node. base case 2
                MapEntry<K,V>  M = new MapEntry<>(key, value);
                BinaryTreeNodeImp<MapEntry<K,V>> newNode =
                        new BinaryTreeNodeImp<>(M, N, null,null);
                N.setRightChild(newNode);
                this.currentSize++;
                return null;
            }
            else {
                return this.putAux(key,value, N.getRightChild());
            }
        }
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        return this.get(key) != null;
    }

    @Override
    public void clear() {
        while(this.size() != 0){
            this.remove(this.root.getValue().getKey());
        }
    }

    @Override
    public List<K> getKeys() {
        List<K> L = new SinglyLinkedList<>();
        if (this.size() == 0){
            return L;
        }
        else {
            this.getKeysAux(this.root, L);
            return L;
        }
    }

    private void getKeysAux(BinaryTreeNode<MapEntry<K,V>> N, List<K> L) {
        if (N == null){
            return;
        }
        else if (N.getLeftChild() == null && N.getRightChild() == null){
            L.add(N.getValue().getKey());
            return;
        }
        else {
            this.getKeysAux(N.getLeftChild(), L);
            L.add(N.getValue().getKey());
            this.getKeysAux(N.getRightChild(), L);
            return;
        }
    }

    @Override
    public List<V> getValues() {
        return null;
    }

}
