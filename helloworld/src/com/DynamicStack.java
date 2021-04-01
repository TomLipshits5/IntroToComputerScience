package com;

import java.util.NoSuchElementException;

public class DynamicStack {
    private int[] storage;
    private int topElementIndex;

    public DynamicStack(int capaity){
        storage = new int[capaity];
        topElementIndex = -1;
    }


    public boolean isEmpty(){
        return topElementIndex==-1;
    }

    public int pop(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        int toReturn = storage[topElementIndex];
        topElementIndex= topElementIndex-1;
        return  toReturn;
    }

    public void push(int element){
        topElementIndex= topElementIndex+1;
        if (topElementIndex==storage.length-1){
            increaseCap();
        }
        storage[topElementIndex] = element;

    }
    private void increaseCap(){
        int[] newStorage = new int[storage.length+10];
        for (int i = 0;i<storage.length;i++){
            newStorage[i] = storage[i];
        }
        storage=newStorage;
    }



}
