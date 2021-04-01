

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
    //Convert a Char 0-9 to a BinaryNumber representing the binary value of that char.
    public BinaryNumber(char c) {
        int numC = c - '0';
        if (!(numC >= 0 && numC <= 9)) {                //Input check.
            throw new IllegalArgumentException("Input out of range 0-9");
        }
        bits = new BitList();
        while (numC > 0) {                          //Dividing by 2 to create the binary value with the remainder
            int numCMod = numC % 2;
            Bit newBit = new Bit(numCMod);
            bits.addLast(newBit);
            numC = numC / 2;

        }
        bits.addLast(Bit.ZERO);
        bits.reduce();
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.2 ================================================
    //Convert a BinaryNumber to its String representation.
    public String toString() {
        // Do not remove or change the next two lines
        if (!isLegal()) // Do not change this line
            throw new RuntimeException("I am illegal.");// Do not change this line

        String s = bits.toString();                 //Cuts the <> from the edges.
        return s.substring(1, s.length() - 1);
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.3 ================================================
    //Check for equality between this and another BinaryNumber.
    public boolean equals(Object other) {
        if (other == null || !isLegal()){                     //Input check.
            throw new IllegalArgumentException("Can't use equals with null or illegal numbers");
        }
        boolean ans  = false;
        //Check length number of ones ans instance.
        if(other instanceof BinaryNumber && length() == ((BinaryNumber) other).length() && bits.getNumberOfOnes() == ((BinaryNumber) other).bits.getNumberOfOnes()){
            Iterator<Bit> myIt = bits.iterator();
            Iterator<Bit> otherIt = ((BinaryNumber) other).bits.iterator();
            while(myIt.hasNext()){                          //Compare each bit to find exceptions.
                if(!myIt.next().equals(otherIt.next())){
                    return false;
                }
            }
            ans = true;

        }
        return ans;
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.4 ================================================
    //Sum the binary value of two BinaryNumbers and returns the summation.
    public BinaryNumber add(BinaryNumber addMe) {
        if(addMe == null || !addMe.isLegal()){                      //Input check
            throw new IllegalArgumentException("Can't add null");
        }
        //Equalizing numbers length.
        if (bits.size() < addMe.length()){
            bits.padding(addMe.length());
        }
        else{
            addMe.bits.padding(bits.size());
        }

        //Looping throw the BinaryNumbers summing the bit value and passing on the carry value.
        BinaryNumber ans = new BinaryNumber('0');
        Bit otherLast = addMe.bits.getLast();
        Bit myLast = bits.getLast();
        int carry = 0 ;
        int sum ;
        boolean isOverflow = otherLast.equals(myLast);
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
        if (isOverflow){            //Check and handles Bit overflow cases
            ans.bits.addLast(myLast);
        }
        addMe.bits.reduce();    //Fixing the added number back to a legal number.
        ans.bits.reduce();      //Reducing the ans.

        return ans;
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.5 ================================================
    //Convert a BinaryNumber to its complement 2 representation.
    public BinaryNumber negate() {
        if(!isLegal()){             //Input check.
            throw new IllegalArgumentException("Can't negate an illegal number");
        }
        BinaryNumber negative = new BinaryNumber(0);
        BitList negBits = bits.complement();
        Iterator<Bit> bitIt = negBits.iterator();
        while(bitIt.hasNext()){             //Creating a complement 1 representation.
            negative.bits.addLast(bitIt.next());
        }
        negative.bits.removeFirst();
        negative = negative.add(ONE);             //Adding 1 to convert to complement 2.
        return negative;

    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.6 ================================================
    //Subtract two BinaryNumbers and return the difference.
    public BinaryNumber subtract(BinaryNumber subtractMe) {
        if(subtractMe == null || !subtractMe.isLegal() || !isLegal()){          //Input check.
            throw new IllegalArgumentException("Can't subtract an illegal number");
        }
        BinaryNumber negativeSubMe = subtractMe.negate();           //Convert the subtracted number to its negative form
        return add(negativeSubMe);                                  //Adding the two numbers.
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.7 ================================================
    //Returns -1 if th BinaryNUmber is negative 1 if its positive and 0 if its ZERO.
    public int signum() {
        if(!isLegal()){
            throw new IllegalArgumentException("Can't use signum with an illegal number");
        }
        if(equals(ZERO)){
            return 0;
        }
        int last = bits.getLast().toInt();
        if(last == 1){
            return -1;
        }
        return 1;
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.8 ================================================
    //Compare two BinaryNumbers returns 1 if this is bigger than other, -1 if this is smaller than other, 0 if they are equal.
    public int compareTo(BinaryNumber other) {
        if(other ==null ||!isLegal() || !other.isLegal()){              //Input Check.
            throw new IllegalArgumentException("Can't use compareTo with an illegal number");
        }
        BinaryNumber otherNum = new BinaryNumber(other);
        return subtract(other).signum();
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.9 ================================================
    //Converts a binary number to an Integer representation of the decimal value.
    public int toInt() {
        // Do not remove or change the next two lines
        if (!isLegal()) // Do not change this line                  //Input check.
            throw new RuntimeException("I am illegal.");// Do not change this line

        //Check if the number is in Integer range.
        if((bits.getLast().toInt() == 0 && length()>32) || (bits.getLast().toInt() ==1 && length()> 33)){
            throw new RuntimeException("Number out of range for Integer try this.toIntString");
        }
        if(length() == 33){
            int last = bits.removeLast().toInt();
            if (last != bits.getLast().toInt()){
                throw new RuntimeException("Number out of range for Integer try this.toIntString");
            }
            bits.addLast(new Bit(last));
        }
        double ans = 0;
        double power = 0;
        Iterator<Bit> it = bits.iterator();
        while(power<length()-1){                        //Summaries the decimal value.
            ans = (int)(ans + (it.next().toInt() * Math.pow(2.0,power)));
            power++;
        }
        ans = ans - (it.next().toInt() * Math.pow(2.0,power));          //Negative and positive treatment
        return (int)ans;
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.10 ================================================
    //Multiply two BinaryNumbers returns Multiplication.
    // Do not change this method
    public BinaryNumber multiply(BinaryNumber multiplyMe) {
        if(multiplyMe == null || !isLegal() || !multiplyMe.isLegal()){      //Input check.
            throw new IllegalArgumentException("Can't multiply an illegal number");
        }

        BinaryNumber mult = new BinaryNumber(multiplyMe);
        if(bits.getLast().toInt() == 1 && mult.bits.getLast().toInt() ==1){     //Both negative
            BinaryNumber ans = negate().multiplyPositive(mult.negate());
            return  ans;
        }
        if(bits.getLast().toInt() == 1 && mult.bits.getLast().toInt() ==0){     //One is positive and the other is negative
            BinaryNumber ans = negate().multiplyPositive(mult);
            return  ans.negate();
        }
        if(bits.getLast().toInt() == 0 && mult.bits.getLast().toInt() ==1){     //One is positive and the other is negative
            BinaryNumber ans = multiplyPositive(mult.negate());
            return  ans.negate();
        }
        return multiplyPositive(mult);      //Both positive.
    }

    //Assist function for Multiplication, multiply two positive numbers only.
    private BinaryNumber multiplyPositive(BinaryNumber multiplyMe) {
        BinaryNumber mult = new BinaryNumber(multiplyMe);
        BinaryNumber ans = new BinaryNumber('0');
        BinaryNumber me = new BinaryNumber(this);
        Iterator<Bit> multiplyMeIt = mult.bits.iterator();
        while(multiplyMeIt.hasNext()){              //Adding me multiplied by the position of the number.
            if(multiplyMeIt.next().toInt() == 1){
                ans = ans.add(me);
            }
            me.bits.addFirst(new Bit(0));       //Adding Zeroes according to the position of the number.
            me.bits.reduce();
        }
        ans.bits.reduce();
        return ans;
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.11 ================================================
    //Dividing two BinaryNumbers returns division.
    // Do not change this method
    public BinaryNumber divide(BinaryNumber divisor) {
        if(divisor == null || !isLegal() || !divisor.isLegal()){            //Input check.
            throw new IllegalArgumentException("Can't multiply an illegal number");
        }

        // Do not remove or change the next two lines
        if (divisor.equals(ZERO)) // Do not change this line
            throw new RuntimeException("Cannot divide by zero."); // Do not change this line


        BinaryNumber div = new BinaryNumber(divisor);
        if(bits.getLast().toInt() == 1 && div.bits.getLast().toInt() ==1){      //Both negative
            BinaryNumber ans = negate().dividePositive(div.negate());
            return  ans;
        }
        if(bits.getLast().toInt() == 1 && div.bits.getLast().toInt() ==0){      //One is positive and the other is negative
            BinaryNumber ans = negate().dividePositive(div);
            return  ans.negate();
        }
        if(bits.getLast().toInt() == 0 && div.bits.getLast().toInt() ==1){         //One is positive and the other is negative
            BinaryNumber ans = dividePositive(div.negate());
            return  ans.negate();
        }
        return dividePositive(div);     //Both positive.


    }

    //Assist function for Divide, divide two positive numbers only.
    private BinaryNumber dividePositive(BinaryNumber divisor) {
        if(compareTo(divisor) < 0){             //If me is smaller than other return zero.
            return new BinaryNumber(ZERO);
        }

        BinaryNumber subNum = new BinaryNumber('0');
        BinaryNumber ans = new BinaryNumber('0');
        BinaryNumber me = new BinaryNumber(this);
        int divLength = divisor.length();
        for (int i =0 ; i<divLength;i++){           //Creating a sub number of me that mach the length of divisor.
            subNum.bits.addFirst(me.bits.removeLast());

        }
        subNum.bits.removeLast();
        if(!subNum.isLegal() || subNum.compareTo(divisor)<0){           //Fixing the sub number to be bigger ot equal to divisor.
            subNum.bits.addFirst(me.bits.removeLast());
        }
        while(me.length() > 0){                                         //Subtracting and constructing sub number to find the division.
            if(!subNum.isLegal() || subNum.compareTo(divisor)<0){
                ans.bits.addFirst(new Bit(0));
            }
            else {
                ans.bits.addFirst(new Bit(1));
                subNum = subNum.subtract(divisor);
            }
            subNum.bits.addFirst(me.bits.removeLast());

        }
        if(subNum.isLegal() && subNum.compareTo(divisor)>=0){
            ans.bits.addFirst(new Bit(1));
        }else{
            ans.bits.addFirst(new Bit(0));
        }

        ans.bits.reduce();
        return ans;
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.12 ================================================
    //Constructor from String input.
    public BinaryNumber(String s) {
        if(s == null){                  //Input Check.
            throw new IllegalArgumentException("Constructor input can't be null");
        }
        boolean isNeg = false;          //Negative numbers handling.
        if(s.charAt(0) == '-'){
            isNeg = true;
            s = s.substring(1);
        }
        BinaryNumber ten = new BinaryNumber('9').add(ONE);
        BinaryNumber mult = new BinaryNumber(ONE);
        BinaryNumber ans = new BinaryNumber(ZERO);
        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i)-'0' < 0 || s.charAt(i) - '0' > 9){      //Characters check
                throw new IllegalArgumentException("Input is an illegal number");
            }
            BinaryNumber next = new BinaryNumber(s.charAt(i)).multiply(mult);      //Multiplication of integer by its numeric coefficient
            ans = ans.add(next);
            mult = mult.multiply(ten);
        }
        if(isNeg){
            if(s.length() == 0){                    //Input check.
                throw new IllegalArgumentException("Input is an illegal number");
            }
            ans = ans.negate();
        }
        bits = ans.bits;
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.13 ================================================
    public String toIntString() {
        //Convert a Binary number to a decimal String representation.
        // Do not remove or change the next two lines
        if (!isLegal()) // Do not change this line
            throw new RuntimeException("I am illegal.");// Do not change this line

        BinaryNumber me = new BinaryNumber(this);
        Boolean isNeg = me.bits.getLast().toInt() == 1;
        if(isNeg){          //Negative numbers handling
            me = me.negate();
        }
        String ans = "0";
        while(me.length()>0) {          //Using the Tip provided in assignment 3 and the assist function constructing the String decimal representation
            ans = add(multiply(ans, 2), me.bits.removeLast().toString());
        }
        if (isNeg){             //Negative numbers handling
            ans = "-" +ans;
        }
        return ans;
    }
    //Assist function for toIntString, adding two decimal numbers that are represented in Strings.
    private String add(String Num,String S){
        // Reverse the strings to make it easier to iterate throw them.
        Character[] num = reverse(Num);
        Character[] s = reverse(S);
        String ans = "";
        int carry = 0;   // Contain the carry value of each sum action.
        int tmp;        //Temporary integer value that holds the sum of two index matching numbers is num and s.
        for (int i = 0; i< num.length; i++) {
            if (i==num.length-1){               //adding the remainder to the end of the string with no carry saved.
                if (i>s.length-1) {
                    tmp = num[i] + carry - 48;
                }
                else{                       //in case num and s are the same length.
                    tmp = num[i] + s[i] + carry - 96;
                }
                ans = tmp + ans;
            }else if (i < s.length) {         //Adding indexed numbers from s to num.
                tmp = num[i] + s[i] + carry - 96;
                carry = tmp / 10;
                ans = tmp % 10 + ans;
            } else {                        //Adding the carry value for the rest of num.
                tmp = num[i]+ carry - 48;
                carry = tmp / 10;
                ans = tmp%10 + ans;
            }
        }
        return ans;
    }

    //Assist function for toIntString, revers a string representation of a number to a matching Char array.
    private Character[] reverse(String s){
        Character[] ans  = new Character[s.length()];
        for (int i = 0; i<ans.length;i++){
            ans[i] = s.charAt(s.length()-1-i);
        }
        return ans;
    }

    //Assist function for toIntString, multiply a string number by an Integer.
    private String multiply(String num, int num2){
        String ans= "0";
        while(num2>0){
            if (ans.length()<num.length()) {
                ans = add(num, ans);
            }else{
                ans = add(ans,num);
            }
            num2--;
        }
        return ans;
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
