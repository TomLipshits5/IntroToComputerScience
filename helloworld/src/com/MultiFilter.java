package com;
import Interfaces.*;
public class MultiFilter<T> implements Filter<T> {

    //Fields:
    private List<Filter<T>> listOfFilters;


    //Constructor:
    public MultiFilter(){
        listOfFilters = new LinkedList<Filter<T>>();
    }







    //Methods

    public void addFilter(Filter<T> element){
        listOfFilters.add(element);


    }
    @Override
    public boolean accept(T object) {
        Iterator<Filter<T>> it = listOfFilters.iterator();
        while(it.hasNext()){
            if(!(it.next().accept(object))){
                return false;
            }
        }
        return true;
    }
}
