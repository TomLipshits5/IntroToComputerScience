package com;

import Interfaces.Comparator;

import java.util.NoSuchElementException;

public class BSTPathIterator<T> implements Iterator<T> {
    //Fields:
    private BinarySearchNode<T> current;
    private  T findMe;

    public BSTPathIterator(BinarySearchNode<T> node, T findMe){
        this.current = node;
        this.findMe = findMe;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        T next = current.data;
        if (current.getComparator().compare(next,findMe)==0){
            current =null;
            return next;
        }
        if (current.getComparator().compare(next,findMe)>0){
            current = (BinarySearchNode<T>) current.left;
        }
        if (current.getComparator().compare(next,findMe)<0){
            current = (BinarySearchNode<T>) current.right;
        }
        return next;
    }
}
