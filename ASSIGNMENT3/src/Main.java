import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Bit bitT = new Bit(true);
        Bit[] bits = {};
        Bit[] bits1 = {};
        NumberAsBits number = new NumberAsBits (bits);
//        System.out.println(bits.length);

        System.out.println(number.base2());
        System.out.println(number.toString());
//        int n =8589934592;
//        throw new NullPointerException();
    }
}
