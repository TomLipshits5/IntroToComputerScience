import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Bit bitT = new Bit(true);
        Bit[] bits = {bitT,bitT,bitT,bitT};
        Bit[] bits1 = {};
        NumberAsBits number = new NumberAsBits (bits);
//        System.out.println(bits.length);
        bitT = new Bit(false);
        System.out.println(number.base2());
        System.out.println(number.toString());
//        int n =8589934592;
//        throw new NullPointerException();
    }
}
