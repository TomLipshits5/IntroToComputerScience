package com;
import Interfaces.*;
public class CircularQueue<T>  {

    //Fields:
    private Link<T> last;


    //Constructors:
    public CircularQueue() {
        last = null;
    }


    //Methods:
    public boolean isEmpty() {
        return last == null;
    }

    public T peek() {
        if (last == null) {
            throw new IllegalArgumentException("No one in line");
        } else {
            return last.getNext().getData();
        }

    }

    public void enqueue(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Element is null");

        }else if(last == null){
            last = new Link<T> (element);
            last.setNext(last);
        }else {
            Link<T> curr = new Link<T>(element, last.getNext());
            last.setNext(curr);
            last = curr;
        }


    }

    public T dequeue() {
        if (last == null) {
            throw new IllegalArgumentException("No one in line");
        } else {
            Link<T> first = last.getNext();
            if (last.getNext() == last){
                last = null;
            }else{
                last.setNext(first.getNext());
            }
            return first.getData();
        }

    }

    private static class Link<T> {

        private T data;
        private Link<T> next;


        public Link(T data, Link<T> next) {

            this.data = data;
            this.next = next;
        }


        public Link(T data) {
            this(data, null);
        }


        public Link<T> getNext() {
            return next;
        }

        public void setNext(Link<T> next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }


    }
}