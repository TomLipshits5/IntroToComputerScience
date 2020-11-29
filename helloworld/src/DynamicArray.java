

public class DynamicArray <T> implements List <T> {
    //Fields
    T[] a;

    //Constructor
    public DynamicArray(T[] a){
        this.a = a;
    }

    //Methods
    @Override
    public int size() {
        return a.length;
    }

    @Override
    public boolean add(T element) {
        T[] newArray = new T[];
        return false;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T set(int index, T element) {
        a[index] = element;
        return null;
    }

    @Override
    public T get(int index) {
        return a[index];
    }

    @Override
    public boolean remove(T element) {
        return false;
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0 ; i<this.size(); i++){
            if (a[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (this.size() == 0){
            return true;
        }
        return false;
    }




}
