package com;
import Interfaces.*;


public class LinkedList<T> implements List<T> {

    //Fields:
    private Link<T> first;
    private int size = 0;


    //Constructors:
    public LinkedList(T element, Link<T> next) {
        if (element == null) {
            throw new IllegalArgumentException("element cant be null");
        }
        first = new Link<T>(element, next);
        size = size + 2;
    }

    public LinkedList(T element) {
        if (element == null) {
            throw new IllegalArgumentException("element cant be null");
        }
        first = new Link<T>(element, null);
        size++;
    }

    public LinkedList() {
        first = null;

    }


    //Methods
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(T element) {
        if (element == null) {
            throw new IllegalArgumentException("element can't be null");
        }

        if (isEmpty()) {
            first = new Link<>(element);

        } else {
            Link<T> current = first;
            Link<T> newLink = new Link<T>(element);
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newLink);

        }
        size++;
        return true;
    }

    public void addFirst(T element) {
        if (element == null) {
            throw new IllegalArgumentException("element can't be null");
        }
        first = new Link<>(element, first);

        size++;
    }

    @Override
    public void add(int index, T element) {
        if (element == null) {
            throw new IllegalArgumentException("element can't be null");
        }
        if (!rangeCheck(index)) {
            throw new IllegalArgumentException("index out of range");
        }
        if (index == 0) {
            this.addFirst(element);
            size++;
        } else {
            int counter = 0;
            Link<T> prev = first;
            while (counter < index - 1) {
                prev = prev.getNext();
                counter++;
            }
            Link<T> newLink = new Link<T>(element, prev.getNext());
            prev.setNext(newLink);
            size++;
        }
    }

    @Override
    public T set(int index, T element) {
        if (element == null) {
            throw new IllegalArgumentException("element can't be null");
        }
        if (!rangeCheck(index)) {
            throw new IllegalArgumentException("index out of range");
        }
        Link<T> current = first;
        Link<T> prev = null;
        int counter = 0;
        while (counter != index) {
            if (counter == index - 1) {
                prev = current;
            }
            current = current.getNext();
            counter++;
        }
        Link<T> newLink = new Link<>(element, current.getNext());
        prev.setNext(newLink);
        return current.getData();
    }

    @Override
    public T get(int index) {
        if (!rangeCheck(index)) {
            throw new IllegalArgumentException("index out of range");
        }
        Link<T> current = first;
        int counter = 0;
        while (counter != index) {
            current = current.getNext();
            counter++;
        }
        return (T)current.getData();
    }

    @Override
    public boolean remove(Object toRemove) {
        Link<T> current = first;
        Link<T> prev = current;
        boolean removed = false;
        while (current != null & !removed) {
            if ((current.getData()).equals(toRemove)) {
                // if the first link should be removed
                if (current == first) {
                    first = first.getNext();
                }
                else {
                    prev.setNext(current.getNext());
                }
                removed = true;
            }
            else {
                prev = current;
                current = current.getNext();
            }
        }
        size--;
        return removed;
    }

    @Override
    public boolean contains(T element) {
        Link<T> current = first;
        while (current != null) {
            if (current.getData().equals(element)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    public String toString() {
        String s = "[";
        for (Link<T> current = first; current != null; current = current.getNext()) {
            s = s + current.getData() + ", ";
        }
        s = s.substring(0,s.length()-2) + "]";
        return s;
    }


    private boolean rangeCheck(int index) {
        return (index >= 0 && index < size);
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<T>(first);
    }
}
