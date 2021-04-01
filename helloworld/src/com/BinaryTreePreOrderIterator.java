package com;
import Interfaces.Stack;

import java.util.NoSuchElementException;

public class BinaryTreePreOrderIterator<T> implements Iterator<T> {
    private Stack<BinaryNode<T>> stack;

    public BinaryTreePreOrderIterator(BinaryNode<T> root){
        stack = new StackAsLinkedList<>();
        buildStack(root);
    }


    private void buildStack(BinaryNode<T> node){
        if (node.getRight() != null){
            buildStack(node.getRight());
        }
        if (node.getLeft()!=null){
            buildStack(node.getLeft());
        }
        stack.push(node);
    }


    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return stack.pop().getData();
    }
}
