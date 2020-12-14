public class SetAsLinkedList<T> implements Set<T> {

    
    //Fields:
    private LinkedList<T> set;


    //Constructors
    public SetAsLinkedList(){
        this.set = new LinkedList<T>();
    }


    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean add(T element) {
        if(!contains(element)){
            set.add(element);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(T element) {
        return set.contains(element);
    }

    @Override
    public boolean remove(T element) {
        return set.remove(element);
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }


    public Iterator<T> iterator() {
        return set.iterator();
    }


    public String toString() {
        String s = "[";
        for (int i = 0; i < set.size(); i++) {
            if (i == 0) {
                s = s + set.get(i);
            } else
                s = s + ", " + set.get(i);
        }
        s = s + "]";
        return s;
    }
}
