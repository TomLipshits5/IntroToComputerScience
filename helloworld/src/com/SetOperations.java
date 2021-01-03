package com;
import Interfaces.*;

public class SetOperations {
    public static <T> boolean subset(Set<T> setA, Set<T> setB){
        Iterator<T> setAIterator = setA.iterator();
        while(setAIterator.hasNext()){
            if(!setB.contains(setAIterator.next())){
                return false;
            }
        }
        return true;
    }

    public static <T> Set<T> union(Set<T> setA, Set<T> setB){
        Set<T> newSet = new SetAsDynamicArray<T>();
        Iterator<T> setAIterator = setA.iterator();
        Iterator<T> setBIterator = setB.iterator();
        while (setAIterator.hasNext()){
            newSet.add(setAIterator.next());
        }
        while (setBIterator.hasNext()){
            newSet.add(setBIterator.next());
        }
        return newSet;
    }

    public static <T> Set<T> intersection(Set<T> setA, Set<T> setB){
        Set<T> newSet = new SetAsDynamicArray<T>();
        Iterator<T> setAIterator = setA.iterator();
        while(setAIterator.hasNext()){
            T next = setAIterator.next();
            if (setB.contains(next)){
                newSet.add(next);
            }
        }
        return newSet;
    }

    public static <T> Set<T> subtrction(Set<T> setA, Set<T> setB){
        Set<T> newSet = new SetAsDynamicArray<T>();
        Iterator<T> setAIterator = setA.iterator();
        while(setAIterator.hasNext()){
            T next = setAIterator.next();
            if(!setB.contains(next)){
                newSet.add(next);
            }
        }
        return newSet;
    }
}
