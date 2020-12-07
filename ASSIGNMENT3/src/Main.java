import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Bit bitT = new Bit(true);
        Bit[] bits = { bitT, new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),
                new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),
                new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),new Bit(false),
                new Bit(true),new Bit(true),new Bit(true),new Bit(true),new Bit(true),};
        NumberAsBits number = new NumberAsBits (bits);
//        System.out.println(bits.length);

        System.out.println((number.base2().length()));
        System.out.println(number.toString());
//        int n =8589934592;
    }
}
