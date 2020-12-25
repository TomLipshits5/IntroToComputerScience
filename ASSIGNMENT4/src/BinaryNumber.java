

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
        if(other instanceof BinaryNumber && length() == ((BinaryNumber) other).length() && bits.getNumberOfOnes() == ((BinaryNumber) other).bits.getNumberOfOnes()){
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
        if (bits.size() < addMe.length()){
            bits.padding(addMe.length());
        }
        else{
            addMe.bits.padding(bits.size());
        }
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
        if (isOverflow){
            ans.bits.addLast(myLast);
        }
        addMe.bits.reduce();
        ans.bits.reduce();
        if(!ans.isLegal()){
            throw new IllegalArgumentException("Can't add an illegal number");
        }
        return ans;
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.5 ================================================
    public BinaryNumber negate() {
        if(!isLegal()){
            throw new IllegalArgumentException("Can't negate an illegal number");
        }
        BinaryNumber negative = new BinaryNumber(0);
        BitList negBits = bits.complement();
        Iterator<Bit> bitIt = negBits.iterator();
        while(bitIt.hasNext()){
            negative.bits.addLast(bitIt.next());
        }
        negative.bits.removeFirst();
        negative = negative.add(ONE);
        return negative;

    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.6 ================================================
    public BinaryNumber subtract(BinaryNumber subtractMe) {
        if(!subtractMe.isLegal() || !isLegal()){
            throw new IllegalArgumentException("Can't subtract an illegal number");
        }
        BinaryNumber negativeSubMe = subtractMe.negate();
        return add(negativeSubMe);
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.7 ================================================
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
    public int compareTo(BinaryNumber other) {
        if(!isLegal() || !other.isLegal()){
            throw new IllegalArgumentException("Can't use compareTo with an illegal number");
        }
        int myLast = bits.getLast().toInt();
        int otherLast = other.bits.getLast().toInt();
        if(myLast != otherLast){
            return otherLast-myLast;
        }
        String meS = bits.toString();
        String otherS = other.bits.toString();
        if(meS.length() != otherS.length()){
            if(myLast == 0){
                return (int)Math.signum(meS.length()-otherS.length());
            }else{
                return (int)Math.signum(-1*(meS.length()-otherS.length()));
            }
        }
        for(int i =1; i<meS.length(); i++){
            if(meS.charAt(i) != otherS.charAt(i)){
                return (int)Math.signum(meS.charAt(i) - otherS.charAt(i));
            }
        }
        return 0;
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.9 ================================================
    public int toInt() {
        // Do not remove or change the next two lines
        if (!isLegal()) // Do not change this line
            throw new RuntimeException("I am illegal.");// Do not change this line

        int ans = 0;
        double power = 0;
        Iterator<Bit> it = bits.iterator();
        while(power<length()-1){
            ans = ans + (it.next().toInt() * (int)Math.pow(2.0,power));
            power++;
        }
        ans = ans - (it.next().toInt() *(int)Math.pow(2.0,power));
        return ans;
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.10 ================================================
    // Do not change this method
    public BinaryNumber multiply(BinaryNumber multiplyMe) {
        if(!isLegal() || !multiplyMe.isLegal()){
            throw new IllegalArgumentException("Can't multiply an illegal number");
        }
        BinaryNumber mult = new BinaryNumber(multiplyMe);
        if(bits.getLast().toInt() == 1 && mult.bits.getLast().toInt() ==1){
            BinaryNumber ans = negate().multiplyPositive(mult.negate());
            return  ans;
        }
        if(bits.getLast().toInt() == 1 && mult.bits.getLast().toInt() ==0){
            BinaryNumber ans = negate().multiplyPositive(mult);
            return  ans.negate();
        }
        if(bits.getLast().toInt() == 0 && mult.bits.getLast().toInt() ==1){
            BinaryNumber ans = multiplyPositive(mult.negate());
            return  ans.negate();
        }
        return multiplyPositive(mult);
    }

    private BinaryNumber multiplyPositive(BinaryNumber multiplyMe) {
        BinaryNumber ans = new BinaryNumber('0');
        BinaryNumber me = new BinaryNumber(this);
        int multiplierLast = multiplyMe.bits.removeLast().toInt();
        Iterator<Bit> multiplyMeIt = multiplyMe.bits.iterator();
        while(multiplyMeIt.hasNext()){
            if(multiplyMeIt.next().toInt() == 1){
                ans = ans.add(me);
            }
            me.bits.addFirst(new Bit(0));
        }
        ans.bits.reduce();
        return ans;
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.11 ================================================
    // Do not change this method
    public BinaryNumber divide(BinaryNumber divisor) {
        // Do not remove or change the next two lines
        if (divisor.equals(ZERO)) // Do not change this line
            throw new RuntimeException("Cannot divide by zero."); // Do not change this line

        if(!isLegal() || !divisor.isLegal()){
            throw new IllegalArgumentException("Can't multiply an illegal number");
        }
        BinaryNumber div = new BinaryNumber(divisor);
        if(bits.getLast().toInt() == 1 && div.bits.getLast().toInt() ==1){
            BinaryNumber ans = negate().dividePositive(div.negate());
            return  ans;
        }
        if(bits.getLast().toInt() == 1 && div.bits.getLast().toInt() ==0){
            BinaryNumber ans = negate().dividePositive(div);
            return  ans.negate();
        }
        if(bits.getLast().toInt() == 0 && div.bits.getLast().toInt() ==1){
            BinaryNumber ans = dividePositive(div.negate());
            return  ans.negate();
        }
        return dividePositive(div);


    }

    private BinaryNumber dividePositive(BinaryNumber divisor) {
        BinaryNumber subNum = new BinaryNumber('0');
        BinaryNumber ans = new BinaryNumber('0');
        BinaryNumber me = new BinaryNumber(this);
        int divLength = divisor.length();
        String meS = toString();
        for (int i =0 ; i<divLength;i++){
            subNum.bits.addFirst(me.bits.removeLast());

        }
        subNum.bits.removeLast();
        if(!subNum.isLegal() || subNum.compareTo(divisor)<0){
            subNum.bits.addFirst(me.bits.removeLast());
        }
        while(me.length() > 0){
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
    public BinaryNumber(String s) {
        if(s == null){
            throw new IllegalArgumentException("Constructor input can't be null");
        }
        boolean isNeg = false;
        if(s.charAt(0) == '-'){
            isNeg = true;
            s = s.substring(1);
        }
        BinaryNumber ten = new BinaryNumber('9').add(ONE);
        BinaryNumber mult = new BinaryNumber(ONE);
        BinaryNumber ans = new BinaryNumber(ZERO);
        for(int i = s.length()-1; i>=0; i--){
            BinaryNumber next = new BinaryNumber(s.charAt(i)).multiply(mult);
            ans = ans.add(next);
            mult = mult.multiply(ten);
        }
        if(isNeg){
            ans = ans.negate();
        }
        bits = ans.bits;
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.13 ================================================
    public String toIntString() {
        // Do not remove or change the next two lines
        if (!isLegal()) // Do not change this line
            throw new RuntimeException("I am illegal.");// Do not change this line
        //
        BinaryNumber me = new BinaryNumber(this);
        Boolean isNeg = me.bits.removeLast().toInt() == 1;
        String ans = "" + me.bits.removeLast().toInt();
        while(me.length()>0) {
            ans = add(multiply(ans, 2), me.bits.removeLast().toString());
        }
        if (isNeg){
            ans = "-" + ans;
        }
        return ans;
    }

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
    private Character[] reverse(String s){
        Character[] ans  = new Character[s.length()];
        for (int i = 0; i<ans.length;i++){
            ans[i] = s.charAt(s.length()-1-i);
        }
        return ans;
    }
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
