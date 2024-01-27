package src.my_collections;

import java.util.Arrays;
import java.util.HashMap;

public class MyHashMap<K,V> {
    private Node<K, V>[] table;
    private static final float LOAD_FACTOR = 0.75f;
    private static final int DEFAULT_CAPACITY = 16;
    private int size;

    public MyHashMap() {
        table = new Node[DEFAULT_CAPACITY];
    }

    public V put(K key, V value){
        resize();
        return putOnTable(key, value);
    }

    public V remove(K key){
        int index = calculateIndex(key, table.length);
        var current = table[index];
        if (current != null) {
            if (current.key.equals(key)){
                var removed = current.value;
                table[index] = current.next;
                size--;
                return removed;
            }
            while (current.next != null) {
                if (current.next.key.equals(key)){
                    var removed = current.next.value;
                    current.next = current.next.next;
                    size--;
                    return removed;
                }
                current = current.next;
            }
        }
        return null;
    }

    public V get(K key){
        int index = calculateIndex(key, table.length);
        var current = table[index];
        while (current != null){
            if (current.key.equals(key)){
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void clear(){
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size(){
        return size;
    }

    private void resize(){
        if (size / (float)table.length > LOAD_FACTOR){
            table = Arrays.copyOf(this.table, table.length * 2);
        }
    }

    private V putOnTable(K key, V value){
        int index = calculateIndex(key, table.length);
        var newNode = new Node<>(key, value);;
        if (table[index] == null){
            table[index] = newNode;
        }
        else {
            var current = table[index];
            while (current.next != null){
                if (current.key.equals(key)){
                    var prev = current.value;
                    current.value = value;
                    return prev;
                }
                current = current.next;
            }
            if (current.key.equals(key)){
                var prev = current.value;
                current.value = value;
                return prev;
            }
            current.next = newNode;
        }
        size++;
        return null;
    }

    private int calculateIndex(K key, int tableCapacity){
        var hash = key.hashCode() ^ (key.hashCode() >> 16);
        return hash & (tableCapacity - 1);
    }

    private static class Node<K, V>{
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
