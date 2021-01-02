package com;
import Interfaces.*;
import java.util.NoSuchElementException;

public class StackAsLinkedList<T> implements Stack<T> {
    //Fields:
    private List<T> array;


    //Constructors:
    public StackAsLinkedList(){
        this.array = new LinkedList<>();
    }





    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(T element) {
        if(element == null){
            throw new IllegalArgumentException("cant push null");
        }
        ((LinkedList)array).addFirst(element);

    }

    @Override
    public T pop() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        T top = array.get(0);
        array.remove(top);
        return top;

    }

    @Override
    public T peek() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return array.get(0);
    }
}
