package com;

import Interfaces.MultiSet;
import Interfaces.List;




public class MultiSetAsList<T>  implements MultiSet {
    private List<MultiSetPair> multiset;

    public MultiSetAsList(){
        multiset = new LinkedList<MultiSetPair>();
    }


    public MultiSetPair  getPair(Object element){
        if (element == null){
            throw new IllegalArgumentException();
        }
        Iterator<MultiSetPair> it = multiset.iterator();
        while(it.hasNext()){
            MultiSetPair next = it.next();
            if(next.getElement().equals(element)){
                return next;
            }
        }
        return null;
    }
    @Override
    public int cardinality(Object element) {
        return 0;
    }

    @Override
    public void add(Object element) {
        if(element == null){
            throw new IllegalArgumentException();
        }
        MultiSetPair newPair = getPair(element);
        if (newPair != null){
            newPair.setCardinality(newPair.getCardinality()+1);
        }
        else{
            newPair = new MultiSetPair(element);
            multiset.add(newPair);
        }
    }

    @Override
    public void remove(Object element) {
        if(element == null){
            throw new IllegalArgumentException();
        }
        boolean found = false;
        Iterator<MultiSetPair> it = multiset.iterator();
        while(it.hasNext()&&!found){
            MultiSetPair next = it.next();
            if (element.equals(next.getElement())){
                next.setCardinality(next.getCardinality()-1);
                found = true;
            }
        }

    }

    @Override
    public int size() {
       int size = 0;
       Iterator<MultiSetPair> it = multiset.iterator();
       while(it.hasNext()){
           size = size + it.next().getCardinality();
       }
       return size;
    }


    public String toString(){
        Iterator<MultiSetPair> it = multiset.iterator();
        String ans = "{";
        while(it.hasNext()){
            ans = ans+ it.next().toString()+" ,";
        }
        return ans+"}";
    }
}
