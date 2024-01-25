package src;

import src.my_collections.MyLinkedList;
import src.my_collections.MyQueue;
import src.my_collections.MyStack;

public class Demo {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();

        System.out.println("myStack.size() = " + myStack.size());
        System.out.println("myStack.pop() = " + myStack.pop());
        System.out.println("myStack.size() = " + myStack.size());

    }
}
