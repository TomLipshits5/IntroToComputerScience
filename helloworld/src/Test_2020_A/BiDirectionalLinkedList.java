package Test_2020_A;

import com.LinkedList;

public class BiDirectionalLinkedList<T> extends LinkedList<T> {

    public void addFirst(T element){
        if (element == null){
            throw new IllegalArgumentException();
        }
        if (first == null){
            first = new BiDirectionalLink<T>(element,null,null);
        }
        else{
            BiDirectionalLink<T> newLink = new BiDirectionalLink<>(element,first,null);
            ((BiDirectionalLink<T>)first).setPrev(newLink);
            first = newLink;
        }
    }

    public boolean remove(T element){
        if (element == null){
            throw new IllegalArgumentException();
        }
        if (isEmpty()){
            return false;
        }
        if (element == first.getData()){
            first = first.getNext();
            if (first!=null){
                ((BiDirectionalLink<T>)first).setPrev(null);
            }
            return true;
        }
        for (BiDirectionalLink<T> current = (BiDirectionalLink<T>) first; current != null; current = (BiDirectionalLink<T>) current.getNext()){
            if (current.getData().equals(element)){
                BiDirectionalLink<T> next = (BiDirectionalLink<T>)current.getNext();
                BiDirectionalLink<T> prev = (BiDirectionalLink<T>)current.getPrev();
                if (next!=null) next.setPrev(prev);
                if (prev!=null) prev.setNext(next);
                return true;
            }
        }
        return false;
    }

}
