package com;
import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements Iterator<T> {

    //Fields:

    private Link current;


    //Constructors:
    public LinkedListIterator(Link<T> current){
        this.current = current;

    }


    @Override
    public boolean hasNext() {
        return current!=null;
    }

    @Override
    public T next() {
        if (!hasNext()){
         throw new NoSuchElementException();
        }
        T next = (T)current.getData();
        current = current.getNext();
        return next;
    }
}
