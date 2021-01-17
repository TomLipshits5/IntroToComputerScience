package com;
import java.util.NoSuchElementException;

public class PrimesIterator implements Iterator<Integer>{
    //Fields:
    private Integer nextValue;
    private MultiFilter<Integer> filter;
    private Integer maxValue;



    //Constructors:
    public PrimesIterator(int maxValue){
        this.maxValue = maxValue;
        nextValue =2;
        filter = new MultiFilter<>();
        filter.addFilter(new DoesNotDivideFilter(2));
    }




    @Override
    public boolean hasNext() {
        return nextValue !=null;
    }

    @Override
    public Integer next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        int ans = nextValue;
        boolean foundNext = false;
        while(!foundNext){
            nextValue++;
            if (filter.accept(nextValue)){
                foundNext = true;
            }
            filter.addFilter(new DoesNotDivideFilter(nextValue));
        }
        if (nextValue>maxValue){
            nextValue = null;
        }



        return ans;
    }
}
