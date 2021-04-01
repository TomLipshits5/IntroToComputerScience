package com;

import Interfaces.Filter;

public class FibonaciFilter implements Filter<Integer> {
    @Override
    public boolean accept(Integer object) {
        if(object == null){
            throw new IllegalArgumentException();
        }
        Integer first = 1;
        Integer second = 1;
        Integer next = first+second;
        while(next.compareTo(object)<=0){
            if (next.compareTo(object) == 0){
                return true;
            }
            first = second;
            second = next;
            next = first+second;
        }
        return false;
    }
}
