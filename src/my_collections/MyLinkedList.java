package src.my_collections;

import java.util.Objects;

public class MyLinkedList<T> {
    private int size;
    private Node<T> firstNode;
    private Node<T> lastNode;
    private static class Node<T>{
        private T value;
        Node<T> next;
        Node<T> prev;

        public Node(T value) {
            this.value = value;
        }
    }

    public void add(T value){
        Node<T> newNode = new Node<>(value);
        if (size == 0){
            firstNode = lastNode = newNode;
        }
        else {
            Node<T> prev = lastNode;
            lastNode.next = newNode;
            lastNode = newNode;
            lastNode.prev = prev;
        }
        size++;
    }

    public T remove(int index){
        Objects.checkIndex(index, size);
        T deleted;
        if (index == 0 && size > 1){
            deleted = firstNode.value;
            firstNode = firstNode.next;
        }
        else {
            Node<T> current = firstNode;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            if (index == size - 1){
                deleted = lastNode.value;
                lastNode = lastNode.prev;
            }
            else {
                Node<T> prevNode;
                deleted = current.next.value;
                prevNode = current;
                current.next = current.next.next;
                current.next.prev = prevNode;
            }
        }
        size--;
        return deleted;
    }

    public void clear(){
        size = 0;
        firstNode = lastNode = null;
    }

    public int size(){
        return size;
    }

    public T get(int index){
        Objects.checkIndex(index, size);
        var current = firstNode;
        if (index == 0){
            return firstNode.value;
        }
        else {
            while (index > 0) {
                current = current.next;
                index--;
            }
            return current.value;
        }
    }
}
