package src.my_collections;

import java.util.NoSuchElementException;

public class MyQueue<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T value){
        Node<T> newNode = new Node<>(value);
        if (size == 0){
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    public void clear(){
        head = tail = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public T peek(){
        if (size != 0){
            return head.value;
        }
        else {
            throw new NoSuchElementException("Queue is empty");
        }
    }

    public T poll(){
        if (size != 0){
            var deletedValue = head.value;
            head = head.next;
            size--;
            return deletedValue;
        }
        else {
            throw new NoSuchElementException("Queue is empty");
        }
    }

    private static class Node<T>{
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
