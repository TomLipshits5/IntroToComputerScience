package com;
import Interfaces.List;
import Interfaces.Iterable;

public class BinaryTree<T> implements Iterable<T> {
   //Fields:
    protected BinaryNode<T> root;

    //Constructor:
    public BinaryTree(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void insert(T element){
        if(element == null){
            throw new IllegalArgumentException("can't insert null");
        }
        if(root == null){
            root = new BinaryNode<T>(element);
        }else{
            root.insert(element);
        }
    }

//    public boolean contains(T element){
//        boolean ans;
//        if(element == null){
//            throw new IllegalArgumentException("can't contain null");
//        }
//        if(isEmpty()){
//            return false;
//        }
//        else{
//            ans = root.contains(element);
//        }
//        return ans;
//    }

    public void remove(T element){
        if (element == null){
            throw new IllegalArgumentException();
        }
        if (!isEmpty()) {
            root = root.remove(element);
        }
    }


    public int height(){
        if(isEmpty()){
            return -1;
        }
        else{
             return root.height();
        }
    }


    public int size(){
        if(isEmpty()){
            return 0;
        }
        return root.size();
    }


    public boolean equals(Object other){
        if(!(other instanceof BinaryTree)){
            return false;
        }
        BinaryTree otherTree = ((BinaryTree)other);
        if (isEmpty()){
            return otherTree.isEmpty();
        }
        return root.equals(otherTree.root);
    }
    public void inOrder(){
        if (!isEmpty()){
            root.inOrder();
        }

    }
    public void preOrder(){
        if (!isEmpty()){
            root.preOrder();
        }

    }
    public void postOrder(){
        if (!isEmpty()){
            root.postOrder();
        }

    }

    public int countNodesAtDepth(int depth){
        int ans = 0;
        if(!isEmpty()){
            ans = root.countNodesAtDepth(depth);
        }
        return ans;
    }

    public void mirror(){
        if(!isEmpty()){
            root.mirror();
        }
    }

    public boolean isEven(){
        if (isEmpty()){
            return true;
        }
        boolean isEven;
        isEven = root.isEven();
        return isEven;
    }

    public Integer evaluate(){
        if (isEmpty()){
            throw new IllegalArgumentException();
        }
        return root.evaluate();
    }

    public String toString(){
        String ans = "";
        if(!isEmpty()){
            ans = root.toString();
        }
        return ans;
    }

    public int numberOfLeaves(){
        if (isEmpty()){
            return 0;
        }
        return root.numberOfLeaves();
    }

    public List<T> listOfLeaves(){
        if (isEmpty()){
            return new LinkedList<T>();
        }
        List<T> list = new LinkedList<T>();
        root.listOfLeaves(list);
        return list;
    }

    public boolean isFullLevel(int i){
        if (isEmpty()){
            return false;
        }
        return root.isFullLevel(i);

    }

    public boolean isPerfectTree(){
        if (isEmpty()){
            return true;
        }
        int h = height();
        for(int i =0; i<=h; i++){
            if (!isFullLevel(i)){
                return false;
            }
        }
        return true;
    }

    public boolean isFullTree(){
        if (isEmpty())
            return true;
        return root.isFullTree();
    }


    public boolean hasPath(int sum){
        if (isEmpty()){
            return false;
        }
        return root.hasPath(sum);
    }
    public void printPath(int sum){
        if (!isEmpty()){
            String acc = "";
            root.printPath(sum,acc);
        }

    }



//    public boolean contains(Object element){
//        if(element == null){
//            throw new IllegalArgumentException();
//        }
//        Iterator it = iterator();
//        while(it.hasNext()){
//            if (it.next().equals(element)){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean contains(BinaryTree other){
//        if(other == null){
//            throw new IllegalArgumentException();
//        }
//        Iterator otherIt = other.iterator();
//        while(otherIt.hasNext()){
//            if(!contains(otherIt.next())){
//                return false;
//            }
//        }
//        return true;
//    }



    @Override
    public Iterator<T> iterator() {
        return new BinaryTreeInOrderIterator(root);
    }
    public Iterator<T> bfsIterator() {
        return new BinaryTreeBFSIterator(root);
    }
    public Iterator<T> postOrderIterator() {
        return new BinaryTreePostOrderIterator(root);
    }
    public Iterator<T> preOrderIterator() {
        return new BinaryTreePreOrderIterator(root);
    }
}
