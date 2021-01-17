package com;

import Interfaces.Comparable;

public class BNode<T extends Comparable<T>> {
    private T val;
    private BNode<T>left,right;
    public BNode(T val, BNode<T> left, BNode <T> right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public BNode<T> getLeft(){
        return left;
    }
    public BNode<T> getRight(){
        return right;
    }
    public void setLeft(BNode<T> element){
        this.left = element;
    }
    public void setRight(BNode<T> element){
        this.right = element;
    }
    public T getVal(){
        return val;
    }

}
