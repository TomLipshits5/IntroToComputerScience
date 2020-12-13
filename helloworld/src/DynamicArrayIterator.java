public class DynamicArrayIterator<T> implements Iterator<T> {
    //Fields:
    private DynamicArray<T> array;
    private  int index;

    //Constructors:
    public  DynamicArrayIterator(DynamicArray<T> array){
        this.array = array;
        index = 0;
    }
    @Override
    public boolean hasNext() {
        return index<array.size();
    }

    @Override
    public T next() {
        if (!hasNext()){
            throw new IllegalArgumentException("index out of range");
        }
        T next = array.get(index);
        index++;
        return next;
    }
}
