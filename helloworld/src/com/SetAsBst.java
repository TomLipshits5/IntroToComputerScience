package com;


import Interfaces.Comparable;
import Interfaces.Queue;
import Interfaces.Set;
import Interfaces.Stack;

public class SetAsBst<T extends Comparable<T>> implements Set<T> {

    private BNode<T> head;


    public SetAsBst() {
        head = null;
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean add(T element) {
        return false;
    }

    @Override
    public boolean contains(T element) {
        if (element == null){
            throw new IllegalArgumentException("cant accept null as input");
        }
        BNode<T> root = head;
        boolean found = false;
        while(!found&&root!=null){
            if (root.getVal().compareTo(element) == 0){
                found= true;
            }else if(root.getVal().compareTo(element)>0){
                root = root.getLeft();
            }else if(root.getVal().compareTo(element)<0){
                root = root.getRight();
            }
        }
        return found;
    }

    public void intersect(Set<T> other){
        if(other == null){
            throw new IllegalArgumentException();
        }
        SetAsBst<T> newSet = new SetAsBst<T>();
        Queue<BNode<T>> q = new QueueAsLinkedList<>();
        travel(head,q);
        while(!q.isEmpty()){
            BNode<T> next = q.dequeue();
            if (other.contains(next.getVal())){
                newSet.add(next.getVal());
            }
            travel(next,q);
        }
        head = newSet.head;

    }
    private void travel(BNode<T> root, Queue<BNode<T>> q){
        if (root.getLeft()!=null){
            q.enqueue(root.getLeft());
        }
        if (root.getRight()!= null){
            q.enqueue(root.getRight());
        }
    }

    @Override
    public boolean remove(T element) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
