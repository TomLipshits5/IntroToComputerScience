import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Bit bitT = new Bit(true);
        Bit[] bits = { new Bit(false),bitT, new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),
                new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),
                new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),
                new Bit(true),new Bit(true),new Bit(true),new Bit(true),new Bit(true),};
        Bit[] bits1 = {};
        NumberAsBits number = new NumberAsBits (bits1);
//        System.out.println(bits.length);

        System.out.println((number.toString()));
        System.out.println(number.toString());
//        int n =8589934592;
//        throw new NullPointerException();
    }
}
