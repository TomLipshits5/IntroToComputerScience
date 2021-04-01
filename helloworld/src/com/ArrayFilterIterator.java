package com;

import Interfaces.Filter;

public class ArrayFilterIterator<T> implements Iterator<T> {
    private T[] arr;
    private Filter<T> f;
    private int nextIndex;

    public ArrayFilterIterator(T[] array,Filter<T> f){
        if (array == null || array.length == 0){
            throw new IllegalArgumentException();
        }
        this.arr = array;
        this.f = f;
        prepareNext(0);
    }



    @Override
    public boolean hasNext() {
        return nextIndex>0;
    }

    @Override
    public T next() {
        T next = arr[nextIndex];
        prepareNext(nextIndex+1);
        return next;
    }

    private void prepareNext(int i){
        boolean found = false;
        for(int j =i; j<arr.length && !found;j++){
            if (f.accept(arr[j])){
                found = true;
                nextIndex = j;
            }
        }
        if (!found){
            nextIndex =-1;
        }
    }
}
