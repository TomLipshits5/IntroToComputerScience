package com;


import Interfaces.Stack;

import java.util.NoSuchElementException;

public class BinaryTreePostOrderIterator<T> implements Iterator<T>{
    private Stack<BinaryNode<T>> stack;

    public BinaryTreePostOrderIterator(BinaryNode<T> root){
        stack = new StackAsLinkedList<BinaryNode<T>>();
        prepareNext(root);
    }


    private void prepareNext(BinaryNode<T> node){
        stack.push(node);
        if (node.getRight()!=null){
            prepareNext(node.getRight());
        }
        if (node.getLeft()!=null){
            prepareNext(node.getLeft());
        }
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
