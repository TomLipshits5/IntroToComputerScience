package com;
public class Link<E> {
    //Fields:
    protected E data;
    protected Link<E> next;



    //Constructors:
    public Link(E data, Link<E> next) {
        this.data = data;
        this.next = next;
    }
    public Link(E data) {
        this.data = data;
        this.next = null;
    }



    //Methods:
    public E getData(){
        return data;
    }
    public void setData(E element){
        if (element == null){
            throw new IllegalArgumentException("element can't be null");
        }
        data = element;

    }
    public Link<E> getNext(){
        return next;
    }
    public void setNext(Link<E> element){
        next = element;
    }
}
