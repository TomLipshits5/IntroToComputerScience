<<<<<<< HEAD:helloworld/src/com/DynamicArray.java
package com;
import Interfaces.*;
=======
import java.util.NoSuchElementException;
>>>>>>> 9eb6263c9ee1997bca74e161df114adbff43051a:helloworld/src/DynamicArray.java

public class DynamicArray<T> implements List<T> {
    //Fields
    public static int DEFAULT_CAPACITY = 16;
    public static int INCREMENT_SIZE = 10;
    private Object[] a;
    private int size = 0;

    //Constructor
    public DynamicArray(Object[] a) {
        this.a = a;
        size = a.length;
    }

    public DynamicArray() {
        this.a = new Object[DEFAULT_CAPACITY];
    }

    public DynamicArray(int capacity) {
        a = new Object[10];
    }


    //Methods
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(T element) {
        if (element == null) {
            throw new IllegalArgumentException("element can't be null");
        }
        a[size] = element;
        size++;
        checkCapacity();
        return true;
    }

    @Override
    public void add(int index, T element) {
        if (element == null) {
            throw new IllegalArgumentException("element can't be null");
        }
        if (!rangeCheck(index)){
            throw new IllegalArgumentException("index out of range");
        }
        for (int i = size-1; i>= index;i--){
            a[i+1] = a[i];
        }
        a[index] = element;
        size++;
        checkCapacity();
    }

    @Override
    public T set(int index, T element) {
        if (element == null) {
            throw new IllegalArgumentException("element can't be null");
        }
        if (!rangeCheck(index)){
            throw new IllegalArgumentException("index out of range");
        }
        Object tmp = a[index];
        a[index] = element;
        size++;
        checkCapacity();
        return (T)tmp;
    }

    @Override
    public T get(int index) {
        return (T) a[index];
    }

    @Override
    public boolean remove(T element) {
        if (element==null){
            throw new IllegalArgumentException("element can't ce null");
        }
        int index = 0;
        boolean notFound = true;
        for (int i = 0 ; i<size && notFound ; i++){
            if (a[i].equals(element)){
                notFound = false;
                index = i;
            }
        }
        for (int j = index; j<size; j++){
            a[j] = a[j+1];
            size--;
        }
        return true;
    }


    @Override
    public boolean contains(T element) {
        if (element==null){
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (a[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        String s = "[";
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                s = s + a[i];
            } else
                s = s + ", " + a[i];
        }
        s = s + "]";
        return s;
    }

    private boolean rangeCheck(int index) {
        if (index < 0 || index > size) {
            return false;
        }
        return true;
    }

    private void checkCapacity() {
        if (size == a.length) {
            Object[] newArray = new Object[size + INCREMENT_SIZE];
            for (int i = 0; i < size; i++) {
                newArray[i] = a[i];
            }
            a = newArray;
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new DynamicArrayIterator<T>(this);
    }
}
