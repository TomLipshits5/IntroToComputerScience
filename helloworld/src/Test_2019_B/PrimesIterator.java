package Test_2019_B;

import com.Iterator;

import java.util.NoSuchElementException;

public class PrimesIterator implements Iterator<Integer> {
    private Integer nextValue;
    private MultiFilter<Integer> filter;
    private Integer maxValue;

    public PrimesIterator(int maxValue){
        this.maxValue = maxValue;
        this.nextValue = 2;
        this.filter = new MultiFilter<Integer>();
        filter.addFilter(new DoesNotDivideFilter(2));
    }

    @Override
    public boolean hasNext() {
        return nextValue<=maxValue;
    }

    @Override
    public Integer next() {
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        int output = nextValue;
        nextValue++;
        while(!filter.accept(nextValue)){
            nextValue++;
        }
        filter.addFilter(new DoesNotDivideFilter(nextValue));
        return output;
    }
}
