package Interfaces;

public interface MultiSet {
    public int cardinality(Object element);
    public void add(Object element);
    public void remove(Object element);
    public int size();
}
