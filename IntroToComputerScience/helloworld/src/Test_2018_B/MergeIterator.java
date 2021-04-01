package Test_2018_B;

import Interfaces.List;
import com.Iterator;

import java.util.NoSuchElementException;

public class MergeIterator<T extends Comparable<T>> implements Iterator {
    private Iterator<T> it1;
    private Iterator<T> it2;
    private T next1;
    private T next2;

    public MergeIterator(List<T> list1,List<T> list2){
        it1 = list1.iterator();
        it2 = list2.iterator();
        if (it1.hasNext()) next1 = it1.next();
        if (it2.hasNext()) next2 = it2.next();
    }



    @Override
    public boolean hasNext() {
        return next1!=null || next2!=null;
    }

    @Override
    public Object next() {
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        T output = null;
        if (next1 == null || next1.compareTo(next2)>0){
            output = next2;
            if (it2.hasNext()){
                next2 = it2.next();
            }else next2 =null;

        }
        else if (next1.compareTo(next2)<=0) {
            output = next1;
            if (it1.hasNext()) {
                next1 = it1.next();
            }else next1 = null;

        }
        return output;
    }




}
