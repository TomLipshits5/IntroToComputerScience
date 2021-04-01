package Test_2020_A;

import com.BinarySearchNode;
import com.Iterator;

import java.util.NoSuchElementException;

public class BSTPathIterator<T> implements Iterator<T> {
    private BinarySearchNode<T> current;
    private T findMe;

    public BSTPathIterator(BinarySearchNode<T> node, T findMe){
        this.current = node;
        this.findMe = findMe;
    }


    @Override
    public boolean hasNext() {
        return current!=null;
    }

    @Override
    public T next() {
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        T output = current.getData();
        if (current.getComparator().compare(output,findMe)==0){
            current = null;

        }
        else if (current.getComparator().compare(output,findMe)>0){
            current = (BinarySearchNode<T>)current.getLeft();
        }else{
            current = (BinarySearchNode<T>)current.getRight();
        }
        return output;
    }
}
