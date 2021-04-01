package com;
import Interfaces.*;

public class BinarySearchNode<T> extends BinaryNode<T> {
    private Comparator<T> treeComparator;

    //Constructors:
    public BinarySearchNode(T data, Comparator<T> treeComparator){
        super(data);
        this.treeComparator = treeComparator;
    }


    //Methods:
    public void insert(T element){
        if (treeComparator.compare(element , data)<0){
            if(left!= null){
                left.insert(element);
            }
            else {
                left = new BinarySearchNode<T>(element,treeComparator);
            }
        }else if(treeComparator.compare(element,data)>0){
            if(right!= null){
                right.insert(element);
            }
            else{
                right = new BinarySearchNode<T>(element, treeComparator);
            }
        }
    }

    public Comparator<T> getComparator(){
        return treeComparator;
    }
    public T findMin(){
        BinaryNode<T> currentNode = this;
        while(currentNode.left!=null){
            currentNode = currentNode.left;
        }
        return ((T)currentNode.data);
    }

    public BinaryNode<T> remove(T element){
        if(treeComparator.compare(element, data)<0){
            if(left!= null){
                left = ((BinarySearchNode)left).remove(element);
            }
        }else if(treeComparator.compare(element,data)>0){
            if(right !=null){
                right = ((BinarySearchNode)right).remove(element);
            }
        }
        else {
            if(left == null || right == null){
                if(left == null){
                    return right;
                }
                else{
                    return left;
                }
            }
            else{
                data = ((BinarySearchNode<T>)right).findMin();
                right = ((BinarySearchNode)right).remove(data);
            }
        }
        return this;

    }
    public boolean contains(T element){
        int compRes = treeComparator.compare(data,element);
        if(compRes == 0){
            return true;
        }
        else if(compRes>0){
            return left != null && left.contains(element);
        }else{
            return right!=null && right.contains(element);
        }

    }

//    public void insert(T element){
//        int signum = treeComparator.compare(data,element);
//        if (signum>0){
//            if (left == null){
//                left = new BinarySearchNode(element,treeComparator);
//            }
//            else{
//                left.insert(element);
//            }
//        }
//        if(signum<0){
//            if (right == null){
//                right = new BinarySearchNode(element,treeComparator);
//            }
//            else {
//                right.insert(element);
//            }
//        }
//    }




}
