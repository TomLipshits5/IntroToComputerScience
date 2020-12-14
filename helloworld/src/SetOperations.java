public class SetOperations<T> {
    public static <T> boolean subset(Set<T> setA, Set<T> setB){
        Iterator<T> setAIterator = setA.iterator();
        while(setAIterator.hasNext()){
            if(!setB.contains(setAIterator.next())){
                return false;
            }
        }
        return true;
    }

    public static <T> Set<T> union(Set<T> setA, Set<T> setB){
        Iterator<T> setAIterator = setA.iterator();
        while (setAIterator.hasNext()){
            setB.add(setAIterator.next());
        }
        return setB;
    }

    public static <T> Set<T> intersection(Set<T> setA, Set<T> setB){
        Set<T> newSet = new SetAsDynamicArray<T>();
        Iterator<T> setAIterator = setA.iterator();
        while(setAIterator.hasNext()){
            if (setB.contains(setAIterator.next())){
                newSet.add(setAIterator.next());
            }
        }
        return newSet;
    }
}
