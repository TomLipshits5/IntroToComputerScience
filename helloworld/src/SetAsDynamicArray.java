public class SetAsDynamicArray<T> implements Set<T> {
    //Fields:
    private List<T> array;





    //Constructors:
    public SetAsDynamicArray(){
        array = new DynamicArray<>();
    }


    //Methods:
    @Override
    public int size() {
        return array.size();
    }

    @Override
    public boolean add(T element) {
        if(!contains(element)){
            array.add(element);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(T element) {
        return array.contains(element);
    }

    @Override
    public boolean remove(T element) {
        return array.remove(element);
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }


    public Iterator<T> iterator() {
        return new DynamicArrayIterator<T>((DynamicArray<T>)array);
    }


    public String toString() {
        String s = "[";
        for (int i = 0; i < array.size(); i++) {
            if (i == 0) {
                s = s + array.get(i);
            } else
                s = s + ", " + array.get(i);
        }
        s = s + "]";
        return s;
    }

}
