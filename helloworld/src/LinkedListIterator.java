public class LinkedListIterator<T> implements Iterator<T> {

    //Fields:

    private LinkedList<T> list;
    private int index;

    //Constructors:
    public LinkedListIterator(LinkedList<T> list){
        this.list = list;
        index = 0;
    }


    @Override
    public boolean hasNext() {
        return index<list.size();
    }

    @Override
    public T next() {
        if (!hasNext()){
         throw new IllegalArgumentException("index out of range");
        }
        T next = list.get(index);
        index++;
        return next;
    }
}
