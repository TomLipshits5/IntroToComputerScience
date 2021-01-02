

public class BinarySearchTree<T> extends BinaryTree<T> {
    //Fields:
    private Comparator<T> treeComperator;

    public BinarySearchTree(Comparator<T> comparator){
        treeComperator = comparator;
    }


    //Methods:
    public void insert(T element){
        if(element == null ){
            throw new IllegalArgumentException("can't insert null");
        }
        if (isEmpty()){
            root = new BinarySearchNode<T>(element,treeComperator);
        }
        else{
            root.insert(element);
        }
    }

    public void remove(T element){
        if(element == null){
            throw new IllegalArgumentException("can't remove null");
        }
        if(!isEmpty()){
            root = ((BinarySearchNode)root).remove(element);
        }

    }
    public boolean contains(T element){
        if(element == null){
            throw new IllegalArgumentException();
        }
        return root.contains(element);
    }

    public boolean equals(Object other){
        boolean ans = true;
        if (!(other instanceof BinarySearchTree<?>)){
            return false;
        }
        else {
            Iterator<?> thisIter = this.iterator();
            Iterator<?> otherIter = ((BinarySearchTree<?>)other).iterator();
            while(thisIter.hasNext() && otherIter.hasNext()){
                if(!thisIter.next().equals(otherIter.next())){
                    return false;
                }
            }
            ans = thisIter.hasNext() == otherIter.hasNext();
        }
        return ans;
    }

    public Comparator<T> getComparator(){
        return treeComperator;
    }



}
