
public class DynamicArray <T> implements List <T> {
    //Fields
    private Object[] a;

    //Constructor
    public DynamicArray(Object[] a){
        this.a = a;
    }
    public DynamicArray(){
        this.a = new Object[0];
    }


    //Methods
    @Override
    public int size() {
        return a.length;
    }

    @Override
    public boolean add(T element) {
        Object[] newArray = new Object[a.length+1];
        for (int i = 0; i<a.length; i++){
            newArray[i] = a[i];
        }
        newArray[newArray.length-1] = element;
        a=newArray;
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
        return (T)a[index];
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

    public String toString(){
        String s = "[";
        for (int i = 0; i<a.length;i++){
            if (i == 0){
                s = s + a[i];
            }
            else
                s=s +", "+ a[i];
        }
        s=s+"]";
        return s;
    }




}
