package src.my_collections;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T>{
    private static final int DEFAULT_CAPACITY = 16;
    private int size;
    private Object[] elements;

    public MyArrayList(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(T value){
        resize();
        elements[size] = value;
        size++;
    }

    public T remove(int index){
        Objects.checkIndex(index, size);
        T removedElement = (T)elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index);
        size--;
        return removedElement;
    }

    public void clear(){
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size(){
        return size;
    }

    public T get(int index){
        Objects.checkIndex(index, size);
        return (T) elements[index];
    }

    private void resize(){
        if (size == elements.length){
            elements = Arrays.copyOf(elements, size * 2);
        }
    }
}
