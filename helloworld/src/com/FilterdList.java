package com;

import Interfaces.Filter;
import Interfaces.Iterable;
import Interfaces.List;

public class FilterdList<T> {


    public List<T> filterList(Iterable<T> ds, Filter<T> f){
        List<T> ls = new LinkedList<T>();
        Iterator<T> it = ds.iterator();
        while(it.hasNext()){
            T next = it.next();
            if (f.accept(next)){
                ls.add(next);
            }
        }
        return ls;

    }
}
