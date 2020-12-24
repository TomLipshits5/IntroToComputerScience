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
    //Add Bit element to the end of the BitList.
    public void addLast(Bit element) {
        if (element == null) {              //Input Check.
            throw new IllegalArgumentException("addLast can't except null as input");
        }
        if (element.equals(Bit.ONE)) {          //numOfOnes maneging.
            numberOfOnes++;
        }
        super.addLast(element);
    }

    //Add Bit element to the beginning of the BitList.
    public void addFirst(Bit element) {
        if (element == null) {              //Input Check.
            throw new IllegalArgumentException("addFirst can't except null as input");
        }
        if (element.equals(Bit.ONE)) {          //numOfOnes maneging.
            numberOfOnes++;
        }
        super.addFirst(element);


    }

    //Remove Bit element from the end of the BitList.
    public Bit removeLast() {
        if (super.size() == 0) {            //Validating there is an object to remove.
            throw new IllegalArgumentException("List is empty, can't removeLast");
        }
        Bit removed = super.removeLast();
        if (removed.equals(Bit.ONE)) {          //numOfOnes maneging.
            numberOfOnes--;
        }
        return removed;
    }

    //Remove Bit element from the beginning of the BitList.
    public Bit removeFirst() {
        if (super.size() == 0) {                //Validating there is an object to remove.
            throw new IllegalArgumentException("List is empty, can't removeFirst");
        }
        Bit removed = super.removeFirst();
        if (removed.equals(Bit.ONE)) {              //numOfOnes maneging.
            numberOfOnes--;
        }
        return removed;
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.2 ================================================

    //Converting a BitList data structure  to String format.
    public String toString() {
        String s = ">";
        Iterator<Bit> it = super.iterator();         //Iterating and adding the next element while reversing the order.
        while (it.hasNext()) {
            s = it.next() + s;
        }
        s = "<" + s;
        return s;
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.3 ================================================
    //Constructor that copy Other ans manage the new numOfOnes.
    public BitList(BitList other) {
        super(checkForNull(other));
        numberOfOnes = other.getNumberOfOnes();
    }

    //Check input for exception before passing it to super.
    private static BitList checkForNull(BitList other) {
        if (other == null) {
            throw new IllegalArgumentException("Constructor can't except null as input");
        }
        return other;

    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.4 ================================================
    //Check if the BitLIst represents a valid number.
    public boolean isNumber() {
        if(super.size() == 0){          //Length check
            return false;
        }
        Bit last = super.getLast();
        boolean ans = true;
        if(last.toInt() == 1 && numberOfOnes == 1){         //Value check.
            ans = false;
        }
        return ans;


    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.5 ================================================
    //Check if the number is represented in its reduced way.
    public boolean isReduced() {
        if(!this.isNumber()){               //check if the number is a valid number.
            return false;
        }
        String number = this.toString();
        number = number.substring(1, number.length() - 1);
        if (number.length() <= 2) {                     //check for string in length 2 or less.
            if (!(number.equals("11") || number.equals("01") || number.equals("0"))) {
                return false;
            }

        }

        else if (number.length()>2){                 //check two last bits to see if they are equals.
            Character last = number.charAt(0);
            Character bLast = number.charAt(1);
            if(last.equals(bLast)){
                if(last.equals('0') || numberOfOnes!=2){
                    return false;
                }
            }
        }
        return true;

    }
    //remove bits to reduce the number.
    public void reduce() {
        if (!isNumber()) {                  //check if the input number is valid.
            throw new IllegalArgumentException("The number: " + this.toString() + " is not a valid number");
        }
        while (!(this.isReduced())) {
            this.removeLast();              //removes the redundant last bit.
        }
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.6 ================================================
    //Creates and return a complement number.
    public BitList complement() {
        BitList c = new BitList();
        Iterator<Bit> it = this.iterator();
        while(it.hasNext()){                //iterates the input bits and adding the negate bit to the complement.
            c.addLast(it.next().negate());
        }
        return c;
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.7 ================================================
    // Remove the right bit.
    public Bit shiftRight() {
        if(super.size() == 0){
            return null;
        }
        return removeFirst();
    }
    //Adding zero to the right side of the number.
    public void shiftLeft() {
        addFirst(Bit.ZERO);
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.8 ================================================
    // Duplicating the MSB until the length of the number match the input value.
    public void padding(int newLength) {
        if (size() == 0){
            throw new IllegalArgumentException("BitList is empty");
        }
        Bit last = super.getLast();
        while(super.size() < newLength){           //check the msb value.
            addLast(last);
        }
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
