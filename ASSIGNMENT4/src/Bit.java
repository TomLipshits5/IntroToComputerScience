public class Bit {
    //Fields:
    private  boolean value;

    //Static Fields:
    public static  final Bit ONE  = new Bit(true);
    public static  final Bit ZERO = new Bit(false);


    //Constructors:
    public Bit(boolean value) {
        this.value = value;
    }

    public Bit(int intValue) {
        if (intValue == 0)
            value = false;
        else {
            if (intValue == 1)
                value = true;
            else throw new IllegalArgumentException(value + " is neither 0 nor 1.");
        }
    }



    //Methods:
    public String toString() {
        return "" + toInt();
    }

    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof Bit))
            return false;
        else return value == ((Bit) obj).value;
    }

    public Bit negate() {
        Bit output;
        if (value)
            output = ZERO;
        else output = ONE;
        return output;
    }

    public int toInt() {
        int output;
        if(value)
            output = 1;
        else
            output = 0;
        return output;
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 1.1 ================================================
    //We learned about the full adder operator in Numeric Systems course, The outputs are as followed:
    //SUM = A(Xor)B(Xor)Cin,  Cout= A*B + Cin*(A+B)     +=||, * = &&

    //implementation of Sum = A(Xor)B(Xor)Cin
    public static Bit fullAdderSum(Bit bit1, Bit bit2, Bit bit3) {
        Bit ans = ONE;
        if(bit1.equals(bit2)){
            ans = ZERO;
        }
        if(bit3.equals(ans)){
            ans = ZERO;
        }else {
            ans = ONE;
        }
        return ans;
    }

    //implementation of Cout = A*B + Cin*(A+B)
    public static Bit fullAdderCarry(Bit bit1, Bit bit2, Bit bit3) {
        boolean a = bit1.value;
        boolean b = bit2.value;
        boolean c = bit3.value;
        boolean ans = (a&b) || c&(a|b);
        return new Bit(ans);
    }

}
