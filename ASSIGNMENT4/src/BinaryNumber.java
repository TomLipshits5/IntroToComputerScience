

import java.util.Iterator;

public class BinaryNumber implements Comparable<BinaryNumber> {
    //Static fields:
    private static final BinaryNumber ZERO = new BinaryNumber(0);
    private static final BinaryNumber ONE = new BinaryNumber(1);

    //Fields:
    private BitList bits;

    // Copy constructor
    //Do not chainge this constructor
    public BinaryNumber(BinaryNumber number) {
        bits = new BitList(number.bits);
    }

    //Do not change this constructor
    private BinaryNumber(int i) {
        bits = new BitList();
        bits.addFirst(Bit.ZERO);
        if (i == 1)
            bits.addFirst(Bit.ONE);
        else if (i != 0)
            throw new IllegalArgumentException("This Constructor may only get either zero or one.");
    }

    //Do not change this method
    public int length() {
        return bits.size();
    }

    //Do not change this method
    public boolean isLegal() {
        return bits.isNumber() & bits.isReduced();
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.1 ================================================
    public BinaryNumber(char c) {
        int numC = c - '0';
        if (!(numC >= 0 && numC <= 9)) {
            throw new IllegalArgumentException("Input out of range 0-9");
        }
        bits = new BitList();
        while (numC > 0) {
            int numCMod = numC % 2;
            Bit newBit = new Bit(numCMod);
            bits.addLast(newBit);
            numC = numC / 2;

        }
        bits.addLast(Bit.ZERO);
        bits.reduce();
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.2 ================================================
    public String toString() {
        // Do not remove or change the next two lines
        if (!isLegal()) // Do not change this line
            throw new RuntimeException("I am illegal.");// Do not change this line

        String s = bits.toString();
        return s.substring(1, s.length() - 1);
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.3 ================================================
    public boolean equals(Object other) {
        boolean ans  = false;
        if(other instanceof BinaryNumber && length() == ((BinaryNumber) other).length()){
            Iterator<Bit> myIt = bits.iterator();
            Iterator<Bit> otherIt = ((BinaryNumber) other).bits.iterator();
            while(myIt.hasNext()){
                if(!myIt.next().equals(otherIt.next())){
                    return false;
                }
            }
            ans = true;

        }
        return ans;
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.4 ================================================
    public BinaryNumber add(BinaryNumber addMe) {
        if(isLegal()){
            throw new IllegalArgumentException("Can't add null");
        }
        if (bits.size() < addMe.length()){
            bits.padding(addMe.length());
        }
        else{
            addMe.bits.padding(bits.size());
        }
        BinaryNumber ans = new BinaryNumber('0');
        Bit otehrlast = addMe.bits.getLast();
        Bit myLast = bits.getLast();
        int carry = 0 ;
        int sum ;
        boolean isOverflow = otehrlast.equals(myLast);
        Iterator<Bit> myIt = bits.iterator();
        Iterator<Bit> otherIt = addMe.bits.iterator();
        while(myIt.hasNext()){
            int myNext = myIt.next().toInt();
            int otherNext = otherIt.next().toInt();
            sum = myNext + otherNext + carry;
            carry = sum/2;
            sum = sum%2;
            ans.bits.addLast(new Bit(sum));
        }
        ans.bits.removeFirst();
        if (isOverflow){
            ans.bits.addLast(myLast);
        }
        ans.bits.reduce();
        return ans;

    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.5 ================================================
    public BinaryNumber negate() {
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.6 ================================================
    public BinaryNumber subtract(BinaryNumber subtractMe) {
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.7 ================================================
    public int signum() {
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.8 ================================================
    public int compareTo(BinaryNumber other) {
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.9 ================================================
    public int toInt() {
        // Do not remove or change the next two lines
        if (!isLegal()) // Do not change this line
            throw new RuntimeException("I am illegal.");// Do not change this line
        //
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.10 ================================================
    // Do not change this method
    public BinaryNumber multiply(BinaryNumber multiplyMe) {
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    private BinaryNumber multiplyPositive(BinaryNumber multiplyMe) {
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.11 ================================================
    // Do not change this method
    public BinaryNumber divide(BinaryNumber divisor) {
        // Do not remove or change the next two lines
        if (divisor.equals(ZERO)) // Do not change this line
            throw new RuntimeException("Cannot divide by zero."); // Do not change this line
        //
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    private BinaryNumber dividePositive(BinaryNumber divisor) {
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.12 ================================================
    public BinaryNumber(String s) {
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.13 ================================================
    public String toIntString() {
        // Do not remove or change the next two lines
        if (!isLegal()) // Do not change this line
            throw new RuntimeException("I am illegal.");// Do not change this line
        //
        throw new UnsupportedOperationException("Delete this line and implement the method.");
    }


    // Returns this * 2
    public BinaryNumber multBy2() {
        BinaryNumber output = new BinaryNumber(this);
        output.bits.shiftLeft();
        output.bits.reduce();
        return output;
    }

    // Returens this / 2;
    public BinaryNumber divBy2() {
        BinaryNumber output = new BinaryNumber(this);
        if (!equals(ZERO)) {
            if (signum() == -1) {
                output.negate();
                output.bits.shiftRight();
                output.negate();
            } else output.bits.shiftRight();
        }
        return output;
    }

}
