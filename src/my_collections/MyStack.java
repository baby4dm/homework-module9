package src.my_collections;

import java.util.EmptyStackException;
import java.util.Objects;
import java.util.Stack;

public class MyStack<T> {

    private Node<T> head;
    private int size;

    public void push(T value){
        Node<T> newNode = new Node<>(value);
        Node<T> current = head;
        if (size == 0){
            head = newNode;
        }
        else{
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;

    }

    public T remove(int index){
        Objects.checkIndex(index, size);
        T deletedValue;
        if (index == 0){
            if (size == 1){
                deletedValue = head.value;;
                head = null;

            }
            else {
                deletedValue = head.value;;
                head = head.next;
            }
            size--;
            return deletedValue;
        }
        else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            deletedValue = current.next.value;
            current.next = current.next.next;
            size--;
            return deletedValue;
        }
    }


    public void clear(){
        head = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public T peek(){
        if (size > 1){
            return head.value;
        }
        else {
            throw new EmptyStackException();
        }
    }

    public T pop(){
        if (size != 0){
            T deletedValue = head.value;
            head = head.next;
            size--;
            return deletedValue;
        }
        else {
            throw new EmptyStackException();
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
