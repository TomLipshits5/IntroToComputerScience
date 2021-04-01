package com;
import Interfaces.*;
import Interfaces.Comparable;

import java.util.NoSuchElementException;

public class MergeIterator <T extends Comparable<T>> implements Iterator<T>{
    //Fields:
    private Iterator<T> iterA;
    private Iterator<T> iterB;
    private T nextA;
    private T nextB;


    public MergeIterator(List<T> A,List<T> B){
        iterA = A.iterator();
        iterB = B.iterator();
        if (iterA.hasNext()){
            nextA = iterA.next();

        }
        if (iterB.hasNext()){
            nextB = iterB.next();

        }

    }
    @Override
    public boolean hasNext() {
        return (nextA != null || nextB !=null);
    }

    @Override
    public T next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        T next;
        if(nextA !=null && nextB!= null){
            if (nextA.compareTo(nextB)<=0){
                next = nextA;
                if (iterA.hasNext()){
                    nextA = iterA.next();
                }else{
                    nextA = null;
                }
            }else{
                next = nextB;
                if(iterB.hasNext()){
                    nextB = iterB.next();
                }else{
                    nextB = null;
                }
            }
        }else if(nextA!=null){
            next = nextA;
            if (iterA.hasNext()){
                nextA = iterA.next();
            }else{
                nextA = null;
            }
        }else{
            next =nextB;
            if (iterB.hasNext()){
                nextB = iterB.next();
            }else{
                nextB = null;
            }
        }
        return next;
    }
}
