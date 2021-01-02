
public class IntegerComparator<T extends Comparable<T>> implements Comparator<T> {
    @Override
    public int compare(T e1, T e2) {
        return e1.compareTo(e2);
    }
}
