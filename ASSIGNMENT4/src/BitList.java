import java.util.LinkedList;
import java.util.Iterator;

public class BitList extends LinkedList<Bit> {
    //Fields:
    private int numberOfOnes;




    //Constructors:
    // Do not change the constructor
    public BitList() {
        numberOfOnes = 0;
    }




    //Methods:
    // Do not change the method
    public int getNumberOfOnes() {
        return numberOfOnes;
    }


//=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.1 ================================================

    public void addLast(Bit element) {
        if(element == null){
            throw new IllegalArgumentException("addLast can't except null as input");
        }
        if(element.equals(Bit.ONE)){
            numberOfOnes++;
        }
        super.addLast(element);
    }

    public void addFirst(Bit element) {
        if(element == null) {
            throw new IllegalArgumentException("addFirst can't except null as input");
        }
        if(element.equals(Bit.ONE)){
            numberOfOnes++;
        }
        super.addFirst(element);


    }

    public Bit removeLast() {
        if(super.size() == 0){
            throw new IllegalArgumentException("List is empty, can't removeLast");
        }
        Bit removed = super.removeLast();
        if (removed.equals(Bit.ONE)){
            numberOfOnes--;
        }
        return removed;
    }

    public Bit removeFirst() {
        if(super.size() == 0){
            throw new IllegalArgumentException("List is empty, can't removeFirst");
        }
        Bit removed = super.removeFirst();
        if(removed.equals(Bit.ONE)){
            numberOfOnes--;
        }
        return removed;
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.2 ================================================
    public String toString() {
        String s =">";
        Iterator<Bit> it = super.iterator();
        while(it.hasNext()){
            s = it.next() + s;
        }
        s = "<" + s;
        return s;
    }
    
    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.3 ================================================
    public BitList(BitList other) {
        super(checkForNull(other));
    }

    //Check input for exception before passing it to super.
    private static BitList checkForNull(BitList other){
        if (other == null){
            throw new IllegalArgumentException("Constructor can't except null as input");
        }
        return other;

    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.4 ================================================
    public boolean isNumber() {
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }
    
    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.5 ================================================
    public boolean isReduced() {
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    public void reduce() {
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.6 ================================================
    public BitList complement() {
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.7 ================================================
    public Bit shiftRight() {
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    public void shiftLeft() {
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.8 ================================================
    public void padding(int newLength) {
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    

    //----------------------------------------------------------------------------------------------------------
    // The following overriding methods must not be changed.
    //----------------------------------------------------------------------------------------------------------
    public boolean add(Bit e) {
        throw new UnsupportedOperationException("Do not use this method!");
    }

    public void add(int index, Bit element) {
        throw new UnsupportedOperationException("Do not use this method!");
    }

    public Bit remove(int index) {
        throw new UnsupportedOperationException("Do not use this method!");
    }

    public boolean offer(Bit e) {
        throw new UnsupportedOperationException("Do not use this method!");
    }

    public boolean offerFirst(Bit e) {
        throw new UnsupportedOperationException("Do not use this method!");
    }

    public boolean offerLast(Bit e) {
        throw new UnsupportedOperationException("Do not use this method!");
    }

    public Bit set(int index, Bit element) {
        throw new UnsupportedOperationException("Do not use this method!");
    }

    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Do not use this method!");
    }
}
