package com;
import Interfaces.*;
import java.util.NoSuchElementException;

public class QueueAsLinkedList<T> implements Queue<T> {

    //Fields
    private List<T> list;


    //Constructors:
    public QueueAsLinkedList(){
        list = new LinkedList<>();
    }



    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public T dequeue() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        T first = list.get(0);
        list.remove(first);
        return first;
    }

    @Override
    public void enqueue(T element) {
        if (element == null){
            throw new IllegalArgumentException("can't enqueue null");
        }
        list.add(element);
    }

    @Override
    public T peek() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return list.get(0);
    }
}
